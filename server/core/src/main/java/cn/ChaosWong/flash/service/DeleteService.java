package cn.ChaosWong.flash.service;


public interface DeleteService<ID> {


    void delete(ID id);


    void delete(Iterable<ID> ids);


    void clear();
}
