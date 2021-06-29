package org.sber.lakirev.market.service;

import org.sber.lakirev.market.model.Employee;
import org.sber.lakirev.market.repository.EmployeeRepository;
import org.sber.lakirev.market.util.GeneralizedExceptionSwitcher;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

import static java.util.Objects.requireNonNull;
import static org.sber.lakirev.market.util.ValidationUtil.checkNotFound;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository repository;

    public EmployeeServiceImpl (EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee add(Employee employee) {
        return switchException(() -> {
            requireNonNull(employee);
            try {
                return repository.save(employee);
            }
            catch (DataIntegrityViolationException e) {
                return repository.update(employee);
            }
        });
    }

    @Override
    public Employee update (Employee employee) {
        return repository.update(employee);
    }

    @Override
    public List<Employee> getAll() {
        return switchException(repository::getAll);
    }

    @Override
    public Employee getById (Integer id) {
        return switchException(() -> checkNotFound(repository.getById(id), Employee.class));
    }

    @Override
    public List<Employee> getByStatus (String status) {
        return switchException(() -> repository.getByStatus(status));
    }

    private <T> T switchException(Supplier<T> supplier) {
        return GeneralizedExceptionSwitcher.switchException(supplier);
    }
}
