package org.sber.lakirev.market.repository;

import org.sber.lakirev.market.model.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{
    @PersistenceContext
    private EntityManager manager;

    @Transactional
    @Override
    public Customer save(Customer customer) {
        manager.persist(customer);
        return customer;
    }

    @Override
    public List<Customer> getAll() {
        return manager.createNamedQuery(Customer.GET_ALL, Customer.class).getResultList();
    }

    @Override
    public Customer getById(Integer id) {
        return manager.createNamedQuery(Customer.GET_BY_ID, Customer.class).setParameter("id", id).getSingleResult();
    }
}
