package com.darknight.core.base.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

/**
 * Created by DarKnight on 2014/8/6.
 */
public interface DefaultService<T, ID extends Serializable> {
    public void flush();

    public T save(T entity);

    public Iterable<T> save(Iterable<T> entityList);

    public T find(ID id);

    public Iterable<T> find(Iterable<ID> idList);

    public List<T> findAll();

    public Page<T> findAll(Pageable page);
}
