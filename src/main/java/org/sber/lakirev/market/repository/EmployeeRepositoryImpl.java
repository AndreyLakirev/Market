package org.sber.lakirev.market.repository;

import org.sber.lakirev.market.model.Employee;
import org.sber.lakirev.market.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class EmployeeRepositoryImpl implements EmployeeRepository{
    @PersistenceContext
    private EntityManager manager;

    @Override
    @Transactional
    public Employee save(Employee employee) {
        manager.persist(employee);
        return employee;
    }

    @Override
    @Transactional
    public Employee update (Employee employee) {
        manager.merge(employee);
        return employee;
    }

    @Override
    public List<Employee> getAll() {
        return manager.createNamedQuery(Employee.GET_ALL, Employee.class).getResultList();
    }

    @Override
    public Employee getById (Integer id) {
        return manager.createNamedQuery(Employee.GET_BY_ID, Employee.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public List<Employee> getByStatus (String status) {
        return manager.createNamedQuery(Employee.GET_BY_STATUS, Employee.class).setParameter("status", status).getResultList();
    }
}
