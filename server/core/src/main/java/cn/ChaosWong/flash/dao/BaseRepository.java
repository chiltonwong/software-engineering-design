package cn.ChaosWong.flash.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;
import java.util.List;


@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID>
        , PagingAndSortingRepository<T, ID>
        , JpaSpecificationExecutor<T> {

    List<Object[]> queryBySql(String sql);


    List<T> query(String sql);


    Object getBySql(String sql);


    T get(String sql);
    T getOne(ID id);


    int execute(String sql);


    Class<T> getDataClass();
}
