package org.sber.lakirev.market.repository;

import org.sber.lakirev.market.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class ProductRepositoryImpl implements ProductRepository{

    @PersistenceContext
    private EntityManager manager;

    @Override
    @Transactional
    public Product save(Product product) {
        manager.persist(product);
        return product;
    }

    @Override
    public List<Product> getAll() {
        return manager.createNamedQuery(Product.GET_ALL, Product.class).getResultList();
    }

    @Override
    public Product getById (Integer id) {
        return manager.createNamedQuery(Product.GET_BY_ID, Product.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public List<Product> getByStatus (String status) {
        return manager.createNamedQuery(Product.GET_BY_STATUS, Product.class).setParameter("status", status).getResultList();
    }
}
