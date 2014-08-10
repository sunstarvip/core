package com.darknight.core.base.service.impl;

import com.darknight.core.base.dao.BaseJpaRepository;
import com.darknight.core.base.service.DefaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DarKnight on 2014/8/6.
 */
@Service
@Transactional(readOnly = true)
public class DefaultManager<T, ID extends Serializable> implements DefaultService<T, ID> {
    protected BaseJpaRepository defaultDao;

    @Resource
    public void setDefaultDao(BaseJpaRepository defaultDao) {
        this.defaultDao = defaultDao;
    }

    @Override
    public void flush() {
        defaultDao.flush();
    }

    @Override
    public T save(T entity) {
        return (T)defaultDao.saveAndFlush(entity);
    }

    @Override
    public Iterable<T> save(Iterable<T> entityList) {
        entityList = defaultDao.save(entityList);
        flush();
        return entityList;
    }

    @Override
    public T find(ID id) {
        return (T)defaultDao.getOne(id);
    }

    @Override
    public Iterable<T> find(Iterable<ID> idList) {
        List<T> entityList = defaultDao.findAll(idList);
        if(entityList == null) {
            entityList = new ArrayList<T>();
        }
        return entityList;
    }

    @Override
    public List<T> findAll() {
        List<T> entityList = defaultDao.findAll();
        if(entityList == null) {
            entityList = new ArrayList<T>();
        }
        return entityList;
    }

    @Override
    public Page<T> findAll(Pageable page) {
        Page<T> entityPage = defaultDao.findAll(page);
        return entityPage;
    }
}
