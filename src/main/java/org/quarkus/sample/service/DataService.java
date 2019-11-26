package org.quarkus.sample.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class DataService {
    @Inject
    EntityManager entityManager;

    public <E> Optional<E> save(final E e) {
        entityManager.persist(e);
        return Optional.ofNullable(e);
    }

    public <E> Optional<E> update(final E e) {
        entityManager.merge(e);
        return Optional.ofNullable(e);
    }

    public <E> Optional<E> delete(final E e) {
        entityManager.remove(e);
        return Optional.ofNullable(e);
    }

    public <E> Optional<E> findById(final Class<E> clazz, final Long id) {
        return Optional.ofNullable(entityManager.find(clazz, id));
    }

    public <E> List<E> findByNamedQuery(final Class<E> clazz, final String queryName) {
        return entityManager.createNamedQuery(queryName, clazz).getResultList();
    }

    public <E> List<E> findByNamedQueryWithParams(final Class<E> clazz, final String queryName, Object... parameters){
        Query namedQuery = entityManager.createNamedQuery(queryName, clazz);
        for (int i = 0; i < parameters.length; i++) {
            namedQuery.setParameter(i +1, parameters[i]);
        }
        return namedQuery.getResultList();
    }

    public <E> Optional<E> findUniqueByNameQueryWithParams(final Class<E> clazz, final String queryName, Object... parameters) {
        List<E> list = findByNamedQueryWithParams(clazz, queryName, parameters);
        return (list.size() == 1) ? Optional.ofNullable(list.get(0)) : Optional.empty();
    }

}
