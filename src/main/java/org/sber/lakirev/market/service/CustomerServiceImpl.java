package org.sber.lakirev.market.service;

import org.sber.lakirev.market.exception.StorageException;
import org.sber.lakirev.market.model.Customer;
import org.sber.lakirev.market.repository.CustomerRepository;
import org.sber.lakirev.market.util.GeneralizedExceptionSwitcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

import static java.util.Objects.requireNonNull;
import static org.sber.lakirev.market.util.ValidationUtil.checkNotFound;

@Service
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository repository;

    public CustomerServiceImpl (CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer add(Customer customer) {
        return switchException(() -> {
            requireNonNull(customer);
            try {
                return repository.save(customer);
            }
            catch (Exception e) {
                throw new StorageException(e);
            }
        });
    }

    @Override
    public List<Customer> getAll() {
        return switchException(repository::getAll);
    }

    @Override
    public Customer getById(Integer id) {
        return switchException(() -> checkNotFound(repository.getById(id), Customer.class));
    }

    private <T> T switchException(Supplier<T> supplier) {
        return GeneralizedExceptionSwitcher.switchException(supplier);
    }
}
