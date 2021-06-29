package org.sber.lakirev.market.repository;

import org.sber.lakirev.market.model.Product;

import java.util.List;

public interface ProductRepository {
    Product save (Product product);

    List<Product> getAll ();

    Product getById(Integer id);

    List<Product> getByStatus(String status);

}
