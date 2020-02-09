package cn.ChaosWong.flash.utils;


import com.google.common.base.Strings;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5 {

    public static final Logger LOG = LoggerFactory.getLogger(MD5.class);


    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public final static int HASH_ITERATIONS = 1024;

    public final static String HASH_ALGORITHM_NAME = "MD5";

    private static MessageDigest MESSAGE_DIGEST = null;


    static {
        try {
            MESSAGE_DIGEST = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }



    public static String getMD5String(String str) {
        if (Strings.isNullOrEmpty(str)) {
            return null;
        }
        return getMD5String(str.getBytes());
    }



    public static String getMD5String(byte[] bytes) {
        MESSAGE_DIGEST.update(bytes);
        return bytesToHex(MESSAGE_DIGEST.digest());
    }


    public static String getFileMD5String(File file) {
        String ret = "";
        FileInputStream in = null;
        FileChannel ch = null;
        try {
            in = new FileInputStream(file);
            ch = in.getChannel();
            ByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            MESSAGE_DIGEST.update(byteBuffer);
            ret = bytesToHex(MESSAGE_DIGEST.digest());
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        } finally {
            IOUtils.closeQuietly(in);
            IOUtils.closeQuietly(ch);
        }
        return ret;
    }


    public static String getFileMD5String(String fileName) {
        return getFileMD5String(new File(fileName));
    }



    public static String bytesToHex(byte[] bytes) {
        return bytesToHex(bytes, 0, bytes.length);
    }


    public static String bytesToHex(byte[] bytes, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < start + end; i++) {
            sb.append(byteToHex(bytes[i]));
        }
        return sb.toString();
    }


    public static String byteToHex(byte bt) {
        return HEX_DIGITS[(bt & 0xf0) >> 4] + "" + HEX_DIGITS[bt & 0xf];
    }



    public static String md5(String credentials, String salt) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();

            messageDigest.update(salt.getBytes("UTF-8"));

            messageDigest.update(credentials.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("NoSuchAlgorithmException caught!");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        byte[] byteArray = messageDigest.digest();

        StringBuffer md5StrBuff = new StringBuffer();

        for (int i = 0; i < byteArray.length; i++) {
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1) {
                md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
            } else {
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
            }
        }

        return md5StrBuff.toString();
    }

    public static void main(String[] args) {
        System.out.println(MD5.md5("admin", "8pgby"));
    }
}