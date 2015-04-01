package com.darknight.core.base.service;

import com.darknight.core.base.entity.DefaultEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.List;

/**
 * 公共Service接口
 * 用于定义通用的CURD方法
 * Created by DarKnight on 2015/4/1.
 */
public interface BaseService<M extends DefaultEntity, ID extends Serializable> {
    /**
     * 推送缓存中的数据操作至数据库
     */
    public void flush();

    /**
     * 保存对象
     * @param entity 实体对象
     * @return
     */
    public M save(M entity);

    /**
     * 批量保存对象
     * @param entitylist 实体对象列表
     * @return
     */
    public List<M> save(List<M> entitylist);

    /**
     * 删除该实体对象ID下的实体对象
     * 物理删除
     * @param entityId 实体对象ID
     */
    public void realDelete(ID entityId);

    /**
     * 根据传入实体对象ID, 批量删除实体对象
     * 物理删除
     * @param idList 实体对象ID列表
     */
    public void realDelete(List<ID> idList);

    /**
     * 删除实体对象
     * 物理删除
     * @param entity 实体对象
     */
    public void realDelete(M entity);

    /**
     * 批量删除实体对象
     * 物理删除
     * @param entityList 实体对象列表
     */
    public void realDeleteInBatch(List<M> entityList);

    /**
     * 删除所有的实体对象
     * 物理删除
     */
    public void realDeleteAll();

    /**
     * 统计所有实体对象的总数量
     * @return
     */
    public long count();

    /**
     * 根据传入实体对象ID, 判断该实体对象是否存在
     * @param entityId 实体对象ID
     * @return
     */
    public boolean exists(ID entityId);

    /**
     * 根据实体对象ID, 查询实体对象
     * @param entityId 实体对象ID
     * @return
     */
    public M find(ID entityId);

    /**
     * 根据传入的实体对象ID, 批量查询实体对象
     * @param idList 实体对象ID列表
     * @return
     */
    public List<M> find(List<ID> idList);

    /**
     * 查询所有的实体对象
     * @return
     */
    public List<M> findAll();

    /**
     * 分页查询所有的实体对象
     * @param page 分页容器
     * @return
     */
    public Page<M> findAll(Pageable page);

    /**
     * 查询所有的实体对象, 并根据Sort排序规则进行排序
     * @param sort 排序规则对象
     * @return
     */
    public List<M> findAll(Sort sort);

    /**
     * 查询所有未逻辑删除的实体对象
     * @return
     */
    public List<M> findAllVisible();

    /**
     * 删除该实体对象ID下的实体对象
     * 逻辑删除
     * @param entityId 实体对象ID
     */
    public void delete(ID entityId);

    /**
     * 根据传入实体对象ID, 批量删除实体对象
     * 逻辑删除
     * @param idList 实体对象ID列表
     */
    public void delete(List<ID> idList);

    /**
     * 删除实体对象
     * 逻辑删除
     * @param entity 实体对象
     */
    public void delete(M entity);

    /**
     * 批量删除实体对象
     * 逻辑删除
     * @param entityList 实体对象列表
     */
    public void deleteInBatch(List<M> entityList);

    /**
     * 删除所有的实体对象
     * 逻辑删除
     */
    public void deleteAll();
}
