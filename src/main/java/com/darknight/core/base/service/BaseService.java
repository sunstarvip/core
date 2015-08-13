package com.darknight.core.base.service;

import com.darknight.core.base.entity.DataGridEntity;
import com.darknight.core.base.entity.DefaultEntity;
import org.hibernate.Criteria;
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
    void flush();

    /**
     * 保存对象
     * @param entity 实体对象
     * @return
     */
    M save(M entity);

    /**
     * 批量保存对象
     * @param entitylist 实体对象列表
     * @return
     */
    List<M> save(List<M> entitylist);

    /**
     * 删除该实体对象ID下的实体对象
     * 物理删除
     * @param entityId 实体对象ID
     */
    void realDelete(ID entityId);

    /**
     * 根据传入实体对象ID, 批量删除实体对象
     * 物理删除
     * @param idList 实体对象ID列表
     */
    void realDelete(List<ID> idList);

    /**
     * 删除实体对象
     * 物理删除
     * @param entity 实体对象
     */
    void realDelete(M entity);

    /**
     * 批量删除实体对象
     * 物理删除
     * @param entityList 实体对象列表
     */
    void realDeleteInBatch(List<M> entityList);

    /**
     * 删除所有的实体对象
     * 物理删除
     */
    void realDeleteAll();

    /**
     * 统计所有实体对象的总数量
     * @return
     */
    long count();

    /**
     * 根据传入实体对象ID, 判断该实体对象是否存在
     * @param entityId 实体对象ID
     * @return
     */
    boolean exists(ID entityId);

    /**
     * 用来查询未逻辑删除的实体对象
     * 用来获取自定义Criteria对象
     * @return
     */
    Criteria getVisibleCriteria();

    /**
     * 用来查询未逻辑删除并进行默认排序过的实体对象
     * 默认排序：updateTime desc 更新时间倒序
     *          createTime desc 创建时间倒序
     * 用来获取自定义Criteria对象
     * @return
     */
    Criteria getOrderedVisibleCriteria();

    /**
     * 根据实体对象ID, 查询实体对象
     * @param entityId 实体对象ID
     * @return
     */
    M find(ID entityId);

    /**
     * 根据传入的实体对象ID, 批量查询实体对象
     * @param idList 实体对象ID列表
     * @return
     */
    List<M> find(List<ID> idList);

    /**
     * 查询所有的实体对象
     * @return
     */
    List<M> findAll();

    /**
     * 分页查询所有的实体对象
     * @param page 分页容器
     * @return
     */
    Page<M> findAll(Pageable page);

    /**
     * 查询所有的实体对象, 并根据Sort排序规则进行排序
     * @param sort 排序规则对象
     * @return
     */
    List<M> findAll(Sort sort);

    /**
     * 查询所有未逻辑删除的实体对象
     * @return
     */
    List<M> findAllVisible();

    /**
     * 查询所有未逻辑删除并默认排序过的实体对象
     * 默认排序：updateTime desc 更新时间倒序
     *          createTime desc 创建时间倒序
     * @return
     */
    List<M> findAllOrderedVisible();

    /**
     * 删除该实体对象ID下的实体对象
     * 逻辑删除
     * @param entityId 实体对象ID
     */
    void delete(ID entityId);

    /**
     * 根据传入实体对象ID, 批量删除实体对象
     * 逻辑删除
     * @param idList 实体对象ID列表
     */
    void delete(List<ID> idList);

    /**
     * 删除实体对象
     * 逻辑删除
     * @param entity 实体对象
     */
    void delete(M entity);

    /**
     * 批量删除实体对象
     * 逻辑删除
     * @param entityList 实体对象列表
     */
    void deleteInBatch(List<M> entityList);

    /**
     * 删除所有的实体对象
     * 逻辑删除
     */
    void deleteAll();

    /**
     * 通过分页容器对象来生成数据表格对象
     * @param page 分页容器对象
     * @return DataGridEntity 数据表格对象
     */
    DataGridEntity<M> makeDataGrid(Page<M> page);
}
