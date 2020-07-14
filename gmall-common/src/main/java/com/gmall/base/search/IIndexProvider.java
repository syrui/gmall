package com.gmall.base.search;

/**
 * @author gmall
 * @Description
 * @create 2020-03-11 17:13
 **/


public interface IIndexProvider<E extends ISearchEntity> {
    E getEntity(Long id) ;
}
