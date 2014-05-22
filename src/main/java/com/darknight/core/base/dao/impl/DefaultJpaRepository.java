package com.darknight.core.base.dao.impl;

import com.darknight.core.base.dao.BaseJpaRepository;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    private Session getSession() {
        return (Session)this.entityManager.getDelegate();
    }

    private Criterion mapEntryToCriterion(String key, Object value) {
        String[] k = key.split("_");
        if (k.length < 2)
            return Restrictions.eq(k[0], value);
        if (StringUtils.equals("eq", k[1]))
            return Restrictions.eq(k[0], value);
        if (StringUtils.equals("ne", k[1]))
            return Restrictions.ne(k[0], value);
        if (StringUtils.equals("lt", k[1]))
            return Restrictions.lt(k[0], value);
        if (StringUtils.equals("le", k[1]))
            return Restrictions.le(k[0], value);
        if (StringUtils.equals("gt", k[1]))
            return Restrictions.gt(k[0], value);
        if (StringUtils.equals("ge", k[1]))
            return Restrictions.ge(k[0], value);
        if (StringUtils.equals("li", k[1]))
            return Restrictions.like(k[0], "%" + value + "%");
        if (StringUtils.equals("nl", k[1]))
            return Restrictions.not(Restrictions.like(k[0], "%" + value + "%"));
        if (StringUtils.equals("in", k[1]))
            return Restrictions.in(k[0], (List)value);
        if (StringUtils.equals("ni", k[1])) {
            return Restrictions.not(Restrictions.in(k[0], (List)value));
        }
        return Restrictions.eq(key, value);
    }

    @Override
    public Criteria createCriteria() {
        Criteria c = getSession().createCriteria(this.entityClass);
        return c;
    }

    @Override
    public Disjunction createdDisjunction() {
        Disjunction dj = Restrictions.disjunction();
        return dj;
    }
//    @Override
//    public Criteria createCriteria(Map<String, Map.Entry> paramMap) {
//        Set<Map.Entry> set = paramMap.entrySet();
//        Criteria c = getSession().createCriteria(this.entityClass);
//        for (Map.Entry entry : set) {
//            Object obj = entry.getValue();
//            if ((obj != null) && (StringUtils.isNotEmpty(obj.toString()))) {
//                Criterion criterion = mapEntryToCriterion((String)entry.getKey(), entry.getValue());
//                c.add(criterion);
//            }
//        }
//        return c;
//    }
//
//    @Override
//    public Disjunction createdDisjunction(Map<String, Map.Entry> paramMap) {
//        Set set = paramMap.entrySet();
//        Disjunction or = Restrictions.disjunction();
//        for (Map.Entry entry : set) {
//            Object obj = entry.getValue();
//            if ((obj != null) && (StringUtils.isNotEmpty(obj.toString()))) {
//                Criterion criterion = mapEntryToCriterion((String)entry.getKey(), entry.getValue());
//                or.add(criterion);
//            }
//        }
//        return or;
//    }

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
