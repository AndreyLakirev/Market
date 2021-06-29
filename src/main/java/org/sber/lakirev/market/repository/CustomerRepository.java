package org.sber.lakirev.market.repository;

import org.sber.lakirev.market.model.Customer;

import java.util.List;

public interface CustomerRepository {
    public Customer save (Customer customer);

    public List<Customer> getAll ();

    public Customer getById (Integer id);
}
