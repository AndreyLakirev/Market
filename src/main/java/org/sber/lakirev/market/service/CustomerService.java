package org.sber.lakirev.market.service;

import org.sber.lakirev.market.model.Customer;

import java.util.List;


public interface CustomerService {
    Customer add (Customer customer);

    List<Customer> getAll ();

    Customer getById (Integer id);
}
