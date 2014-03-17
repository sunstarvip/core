package com.darknight.base.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Created by DarKnight on 14-2-5.
 */
public interface DefaultJpaRepository <T, ID extends Serializable> extends JpaRepository<T, ID> {
}
