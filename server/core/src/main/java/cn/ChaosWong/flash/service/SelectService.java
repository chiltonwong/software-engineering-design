package cn.ChaosWong.flash.service;

import cn.ChaosWong.flash.bean.vo.query.SearchFilter;
import cn.ChaosWong.flash.utils.factory.Page;
import org.springframework.data.domain.Sort;

import java.util.List;


public interface SelectService <T, ID> {


    T get(ID id);
    T get(SearchFilter filter);
    T get(List<SearchFilter> filters);


    List<T> query(Iterable<ID> ids);


    List<T> queryAll();


    Page<T> queryPage(Page<T> page);


    List<T> queryAll(List<SearchFilter> filters);


    List<T> queryAll(List<SearchFilter> filters, Sort sort);


    List<T> queryAll(SearchFilter filter);


    List<T> queryAll(SearchFilter filter,Sort sort);

    long count(SearchFilter filter);


    long count(List<SearchFilter> filters);
}
