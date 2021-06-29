package org.sber.lakirev.market.service;

import org.sber.lakirev.market.model.Purchase;
import org.sber.lakirev.market.repository.PurchaseRepository;
import org.sber.lakirev.market.util.GeneralizedExceptionSwitcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

import static java.util.Objects.requireNonNull;

@Service
public class PurchaseServiceImpl implements PurchaseService{
    private final PurchaseRepository repository;

    public PurchaseServiceImpl (PurchaseRepository repository) {
        this.repository = repository;
    }
    @Override
    public Purchase add(Purchase purchase) {
        return switchException(() -> {
            requireNonNull(purchase);
            return repository.save(purchase);
        });
    }

    @Override
    public List<Purchase> getAll() {
        return switchException(repository::getAll);
    }

    @Override
    public Purchase getById(Integer id) {
        return switchException(() -> repository.getById(id));
    }

    private <T> T switchException(Supplier<T> supplier) {
        return GeneralizedExceptionSwitcher.switchException(supplier);
    }
}
