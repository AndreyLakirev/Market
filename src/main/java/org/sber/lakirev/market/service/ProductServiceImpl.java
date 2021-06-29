package org.sber.lakirev.market.service;

import org.sber.lakirev.market.model.Product;
import org.sber.lakirev.market.repository.ProductRepository;
import org.sber.lakirev.market.util.GeneralizedExceptionSwitcher;
import org.springframework.stereotype.Service;
import static java.util.Objects.requireNonNull;
import static org.sber.lakirev.market.util.ValidationUtil.checkNotFound;

import java.util.List;
import java.util.function.Supplier;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository repository;

    public ProductServiceImpl (ProductRepository repository) {
        this.repository = repository;
    }
    @Override
    public Product add(Product product) {
        return switchException(() -> {
            requireNonNull(product);
            return repository.save(product);
        });
    }

    @Override
    public List<Product> getAll() {
        return switchException(repository::getAll);
    }

    @Override
    public Product getById (Integer id) {
        return switchException(() -> checkNotFound(repository.getById(id), Product.class));
    }

    @Override
    public List<Product> getByStatus (String status) {
        return switchException(() -> repository.getByStatus(status));
    }

    private <T> T switchException(Supplier<T> supplier) {
        return GeneralizedExceptionSwitcher.switchException(supplier);
    }
}
