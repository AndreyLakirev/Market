package org.sber.lakirev.market.repository;

import org.sber.lakirev.market.model.Purchase;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PurchaseRepositoryImpl implements PurchaseRepository{
    @PersistenceContext
    private EntityManager manager;

    @Transactional
    @Override
    public Purchase save(Purchase purchase) {
        manager.persist(purchase);
        return purchase;
    }

    @Override
    public List<Purchase> getAll() {
        return manager.createNamedQuery(Purchase.GET_ALL, Purchase.class).getResultList();
    }

    @Override
    public Purchase getById(Integer id) {
        return manager.createNamedQuery(Purchase.GET_BY_ID, Purchase.class).setParameter("id", id).getSingleResult();
    }
}
