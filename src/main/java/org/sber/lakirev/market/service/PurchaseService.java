package org.sber.lakirev.market.service;

import org.sber.lakirev.market.model.Purchase;

import java.util.List;

public interface PurchaseService {
    Purchase add (Purchase purchase);

    List<Purchase> getAll ();

    Purchase getById (Integer id);
}
