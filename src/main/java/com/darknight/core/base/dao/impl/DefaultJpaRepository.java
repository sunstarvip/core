package com.darknight.core.base.dao.impl;

import com.darknight.core.base.dao.BaseJpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by DarKnight on 14-2-5.
 */
@NoRepositoryBean
public class DefaultJpaRepository<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseJpaRepository<T, ID> {
    private Class<T> entityClass;
    private final EntityManager entityManager;

    public DefaultJpaRepository(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
        this.entityClass = domainClass;
    }

    public DefaultJpaRepository(final JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

//    public Class<T> getEntityClass() {
//        return entityClass;
//    }
//
//    public void setEntityClass(Class<T> entityClass) {
//        this.entityClass = entityClass;
//    }
//
//    public EntityManager getEntityManager() {
//        return entityManager;
//    }
//
//    @PersistenceContext
//    public void setEntityManager(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
}
