package com.darknight.core.base.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Created by DarKnight on 14-2-5.
 */
public interface BaseJpaRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
}
