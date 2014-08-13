package com.darknight.core.base.dao.impl;

import com.darknight.core.base.dao.BaseJpaDao;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * 设计用来生成进行统一处理各项实体的基本CURD操作的DAO层
 * Created by DarKnight on 2014/8/12.
 */
@Repository
public class CommonDao <T, ID extends Serializable> extends SimpleJpaRepository<T, ID> {
    private Class<T> entityClass;
    private final EntityManager entityManager;

    public CommonDao(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
        this.entityClass = domainClass;
    }

    public CommonDao(final JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public <S extends T> S save(S entity) {
        return super.save(entity);
    }
}
