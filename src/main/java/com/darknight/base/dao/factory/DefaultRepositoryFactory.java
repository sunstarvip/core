package com.darknight.base.dao.factory;

import com.darknight.base.dao.DefaultJpaRepository;
import com.darknight.base.dao.impl.DefaultJpaRepositoryManager;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.core.RepositoryMetadata;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by DarKnight on 14-2-5.
 */
public class DefaultRepositoryFactory<T, I extends Serializable> extends JpaRepositoryFactory {
    private EntityManager entityManager;

    public DefaultRepositoryFactory(EntityManager entityManager) {
        super(entityManager);
        this.entityManager = entityManager;
    }

    @Override
    protected Object getTargetRepository(RepositoryMetadata metadata) {
        return new DefaultJpaRepositoryManager(metadata.getDomainType(), this.entityManager);
    }

    @Override
    protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
        return DefaultJpaRepository.class;
    }
}
