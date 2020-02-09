package cn.ChaosWong.flash.utils.cache;

import cn.ChaosWong.flash.utils.Maps;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class TimeCacheMap<K, V> {
    private static final int DEFAULT_NUM_BUCKETS = 3;



    public static interface ExpiredCallback<K, V> {
        public void expire(K key, V val);
    }


    private LinkedList<HashMap<K, V>> buckets;

    private final Object lock = new Object();
    private Thread cleaner;
    private ExpiredCallback callback;

    public TimeCacheMap(int expirationSecs, int numBuckets, ExpiredCallback<K, V> callback) {
        if (numBuckets < 2) {
            throw new IllegalArgumentException("numBuckets must be >= 2");
        }

        buckets = new LinkedList<HashMap<K, V>>();
        for (int i = 0; i < numBuckets; i++) {
            buckets.add(new HashMap<K, V>());
        }


        this.callback = callback;
        final long expirationMillis = expirationSecs * 1000L;
        final long sleepTime = expirationMillis / (numBuckets - 1);
        cleaner = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Map<K, V> dead = null;
                    try {
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException e) {

                    }

                    synchronized (lock) {

                        dead = buckets.removeLast();
                        buckets.addFirst(Maps.newHashMap());
                    }
                    if (TimeCacheMap.this.callback != null) {
                        for (Map.Entry<K, V> entry : dead.entrySet()) {
                            TimeCacheMap.this.callback.expire(entry.getKey(), entry.getValue());
                        }
                    }
                }
            }
        });

        cleaner.setDaemon(true);
        cleaner.start();
    }

    public TimeCacheMap(int expirationSecs, ExpiredCallback<K, V> callback) {
        this(expirationSecs, DEFAULT_NUM_BUCKETS, callback);
    }

    public TimeCacheMap(int expirationSecs) {
        this(expirationSecs, DEFAULT_NUM_BUCKETS);
    }

    public TimeCacheMap(int expirationSecs, int numBuckets) {
        this(expirationSecs, numBuckets, null);
    }


    public boolean containsKey(K key) {
        if (buckets.getFirst().containsKey(key)) {
            return true;
        } else {
            return false;
        }
    }

    public V get(K key) {
        return buckets.getFirst().get(key);
    }

    public void put(K key, V value) {
        buckets.getFirst().put(key, value);

    }

    public Object remove(K key) {
        return buckets.getFirst().remove(key);
    }

    public int size() {
        return buckets.getFirst().size();
    }


    public void neverCleanup() {
        cleaner.interrupt();

    }
}