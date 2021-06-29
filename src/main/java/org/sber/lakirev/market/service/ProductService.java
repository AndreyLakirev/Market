package org.sber.lakirev.market.service;

import org.sber.lakirev.market.model.Product;

import java.util.List;

public interface ProductService {
    Product add (Product product);

    List<Product> getAll();

    Product getById(Integer id);

    List<Product> getByStatus (String status);
}
