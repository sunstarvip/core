package com.darknight.core.base.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by DarKnight on 14-2-5.
 */
public interface BaseJpaDao<T, ID extends Serializable> extends JpaRepository<T, ID> {
    public Criteria createCriteria();

    public Disjunction createdDisjunction();
}
