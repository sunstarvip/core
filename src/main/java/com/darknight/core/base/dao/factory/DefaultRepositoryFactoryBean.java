package com.darknight.core.base.dao.factory;

import com.darknight.core.base.dao.BaseJpaRepository;
import com.darknight.core.base.dao.impl.DefaultJpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by DarKnight on 14-2-5.
 */
public class DefaultRepositoryFactoryBean <R extends JpaRepository<T, I>, T, I extends Serializable> extends JpaRepositoryFactoryBean<R, T, I> {
    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
        return new DefaultRepositoryFactory(entityManager);
    }

//    private static class DynamicQueryRepositoryFactory<T, I extends Serializable> extends JpaRepositoryFactory {
//        private EntityManager entityManager;
//
//        public DynamicQueryRepositoryFactory(EntityManager entityManager) {
//            super(entityManager);
//            this.entityManager = entityManager;
//        }
//
//        protected Object getTargetRepository(RepositoryMetadata metadata)
//        {
//            return new DefaultJpaRepository(metadata.getDomainType(), this.entityManager);
//        }
//
//        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
//            return BaseJpaRepository.class;
//        }
//    }
}
