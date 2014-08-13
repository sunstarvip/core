package com.darknight.core.base.service.impl;

import com.darknight.core.base.dao.impl.CommonDao;
import com.darknight.core.base.service.CommonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 *
 * Created by DarKnight on 2014/8/6.
 */
@Service
@Transactional(readOnly = true)
public class CommonManager implements CommonService {
    protected CommonDao commonDao;

    @Resource
    public void setcommonDao(CommonDao commonDao) {
        this.commonDao = commonDao;
    }
//
//    @Override
//    public void flush() {
//        commonDao.flush();
//    }

//    @Override
//    public <T> void save(T entity) {
//    }

    //    @Override
//    public <T> Serializable save(T entity); {
//        return commonDao.saveAndFlush(entity);
//    }

//    @Override
//    public List<T> save(Iterable<T> entityList) {
//        List<T> resultList = commonDao.save(entityList);
//        flush();
//        return resultList;
//    }
//
//    @Override
//    public T find(ID id) {
//        return (T)commonDao.getOne(id);
//    }
//
//    @Override
//    public List<T> find(Iterable<ID> idList) {
//        List<T> entityList = commonDao.findAll(idList);
//        if(entityList == null) {
//            entityList = new ArrayList<T>();
//        }
//        return entityList;
//    }
//
//    @Override
//    public List<T> findAll() {
//        List<T> entityList = commonDao.findAll();
//        if(entityList == null) {
//            entityList = new ArrayList<T>();
//        }
//        return entityList;
//    }
//
//    @Override
//    public Page<T> findAll(Pageable page) {
//        Page<T> entityPage = commonDao.findAll(page);
//        return entityPage;
//    }
}
