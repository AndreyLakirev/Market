package org.sber.lakirev.market.repository;

import org.sber.lakirev.market.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    Employee save (Employee employee);

    Employee update (Employee employee);

    List<Employee> getAll ();

    Employee getById (Integer id);

    List<Employee> getByStatus (String status);
}
