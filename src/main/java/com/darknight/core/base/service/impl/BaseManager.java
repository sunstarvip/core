package com.darknight.core.base.service.impl;

import com.darknight.core.base.dao.BaseJpaDao;
import com.darknight.core.base.entity.DefaultEntity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 公共Service抽象类
 * 配合Spring的自动注入，用于实现通用的CURD方法
 * Created by DarKnight on 2015/3/30.
 */
@Transactional(readOnly = true)
public abstract class BaseManager<M extends DefaultEntity, ID extends Serializable> {
    private BaseJpaDao<M, ID> baseDao;

    @Resource
    public void setBaseDao(BaseJpaDao<M, ID> baseDao) {
        this.baseDao = baseDao;
    }

    /**
     * 推送缓存中的数据操作至数据库
     */
    public void flush() {
        baseDao.flush();
    }

    /**
     * 保存对象
     * @param entity 实体对象
     * @return
     */
    @Transactional(readOnly = false)
    public M save(M entity) {
        entity.setCreateTime(new Date());
        return baseDao.saveAndFlush(entity);
    }

    /**
     * 批量保存对象
     * @param entitylist 实体对象列表
     * @return
     */
    @Transactional(readOnly = false)
    public List<M> save(List<M> entitylist) {
        entitylist = baseDao.save(entitylist);
        flush();
        return entitylist;
    }

    /**
     * 删除该实体对象ID下的实体对象
     * 物理删除
     * @param entityId 实体对象ID
     */
    @Transactional(readOnly = false)
    public void realDelete(ID entityId) {
        baseDao.delete(entityId);
        flush();
    }

    /**
     * 根据传入实体对象ID, 批量删除实体对象
     * 物理删除
     * @param idList 实体对象ID列表
     */
    @Transactional(readOnly = false)
    public void realDelete(List<ID> idList) {
        for(ID entityId : idList) {
            baseDao.delete(entityId);
        }
        flush();
    }

    /**
     * 删除实体对象
     * 物理删除
     * @param entity 实体对象
     */
    @Transactional(readOnly = false)
    public void realDelete(M entity) {
        baseDao.delete(entity);
        flush();
    }

    /**
     * 批量删除实体对象
     * 物理删除
     * @param entityList 实体对象列表
     */
    @Transactional(readOnly = false)
    public void realDeleteInBatch(List<M> entityList) {
        baseDao.deleteInBatch(entityList);
        flush();
    }

    /**
     * 删除所有的实体对象
     * 物理删除
     */
    @Transactional(readOnly = false)
    public void realDeleteAll() {
        baseDao.deleteAll();
        flush();
    }

    /**
     * 统计所有实体对象的总数量
     * @return
     */
    public long count() {
        return baseDao.count();
    }

    /**
     * 根据传入实体对象ID, 判断该实体对象是否存在
     * @param entityId 实体对象ID
     * @return
     */
    public boolean exists(ID entityId) {
        return baseDao.exists(entityId);
    }

    /**
     * 根据实体对象ID, 查询实体对象
     * @param entityId 实体对象ID
     * @return
     */
    public M find(ID entityId) {
        return baseDao.findOne(entityId);
    }

    /**
     * 根据传入的实体对象ID, 批量查询实体对象
     * @param idList 实体对象ID列表
     * @return
     */
    public List<M> find(List<ID> idList) {
        List<M> entityList = baseDao.findAll(idList);
        if(entityList == null) {
            entityList = new ArrayList<M>();
        }
        return entityList;
    }

    /**
     * 查询所有的实体对象
     * @return
     */
    public List<M> findAll() {
        List<M> entityList = baseDao.findAll();
        if(entityList == null) {
            entityList = new ArrayList<M>();
        }
        return entityList;
    }

    /**
     * 分页查询所有的实体对象
     * @param page 分页容器
     * @return
     */
    public Page<M> findAll(Pageable page) {
        Page<M> entityPage = baseDao.findAll(page);
        return entityPage;
    }

    /**
     * 查询所有的实体对象, 并根据Sort排序规则进行排序
     * @param sort 排序规则对象
     * @return
     */
    public List<M> findAll(Sort sort) {
        List<M> entityList = baseDao.findAll(sort);
        if(entityList == null) {
            entityList = new ArrayList<M>();
        }
        return entityList;
    }

    /**
     * 查询所有未逻辑删除的实体对象
     * @return
     */
    public List<M> findAllVisible() {
        // 创建查询对象
        Criteria criteria = baseDao.createCriteria();
        // 添加查询规则
        criteria.add(Restrictions.eq("visibleTag", DefaultEntity.VisibleTag.YES));
        List<M> entityList = criteria.list();
        return entityList;
    }

    /**
     * 删除该实体对象ID下的实体对象
     * 逻辑删除
     * @param entityId 实体对象ID
     */
    @Transactional(readOnly = false)
    public void delete(ID entityId) {
        if(exists(entityId)) {
            M entity = find(entityId);
            entity.setUpdateTime(new Date());
            entity.setVisibleTag(DefaultEntity.VisibleTag.NO);
            save(entity);
        }
    }

    /**
     * 根据传入实体对象ID, 批量删除实体对象
     * 逻辑删除
     * @param idList 实体对象ID列表
     */
    @Transactional(readOnly = false)
    public void delete(List<ID> idList) {
        List<M> entityList = find(idList);
        if(!entityList.isEmpty()) {
            for(M entity : entityList) {
                entity.setUpdateTime(new Date());
                entity.setVisibleTag(DefaultEntity.VisibleTag.NO);
            }
            save(entityList);
        }
    }

    /**
     * 删除实体对象
     * 逻辑删除
     * @param entity 实体对象
     */
    @Transactional(readOnly = false)
    public void delete(M entity) {
        entity.setUpdateTime(new Date());
        entity.setVisibleTag(DefaultEntity.VisibleTag.NO);
        save(entity);
    }

    /**
     * 批量删除实体对象
     * 逻辑删除
     * @param entityList 实体对象列表
     */
    @Transactional(readOnly = false)
    public void deleteInBatch(List<M> entityList) {
        if(!entityList.isEmpty()) {
            for(M entity : entityList) {
                entity.setUpdateTime(new Date());
                entity.setVisibleTag(DefaultEntity.VisibleTag.NO);
            }
            save(entityList);
        }
    }

    /**
     * 删除所有的实体对象
     * 逻辑删除
     */
    @Transactional(readOnly = false)
    public void deleteAll() {
        List<M> entityList = findAllVisible();
        if(!entityList.isEmpty()) {
            for(M entity : entityList) {
                entity.setUpdateTime(new Date());
                entity.setVisibleTag(DefaultEntity.VisibleTag.NO);
            }
            save(entityList);
        }
    }
}
