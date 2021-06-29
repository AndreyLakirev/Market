package org.sber.lakirev.market.repository;

import org.sber.lakirev.market.model.Purchase;

import java.util.List;

public interface PurchaseRepository {
    Purchase save (Purchase purchase);

    List<Purchase> getAll ();

    Purchase getById (Integer id);
}
