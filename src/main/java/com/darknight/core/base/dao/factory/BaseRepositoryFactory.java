package com.darknight.core.base.dao.factory;

import com.darknight.core.base.dao.impl.BaseJpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryMetadata;

import javax.persistence.EntityManager;

/**
 * Created by DarKnight on 2014/4/25 0025.
 */
public class BaseRepositoryFactory extends JpaRepositoryFactory {
//        private EntityManager entityManager;
//
//        public DefaultRepositoryFactory(EntityManager entityManager) {
//            super(entityManager);
//            this.entityManager = entityManager;
//        }
//
//        @Override
//        protected Object getTargetRepository(RepositoryMetadata metadata) {
//            return new DefaultJpaRepositoryManager(metadata.getDomainType(), this.entityManager);
//        }
//
//        @Override
//        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
//            return DefaultJpaRepository.class;
//        }

        public BaseRepositoryFactory(EntityManager entityManager) {
            super(entityManager);
        }

        @Override
        protected SimpleJpaRepository getTargetRepository(RepositoryMetadata metadata, EntityManager em) {
            return new BaseJpaRepository(metadata.getDomainType(), em);
        }


        @Override
        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
            return BaseJpaRepository.class;
        }
    }
