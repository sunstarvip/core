package com.darknight.base.dao.impl;

import com.darknight.base.dao.DefaultJpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

/**
 * Created by DarKnight on 14-2-5.
 */
@NoRepositoryBean
public class DefaultJpaRepositoryManager<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements DefaultJpaRepository<T, ID> {
    private Class<T> entityClass;
    private EntityManager entityManager;

    public DefaultJpaRepositoryManager(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
        this.entityClass = domainClass;
    }

    public DefaultJpaRepositoryManager(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    public Class<T> getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
