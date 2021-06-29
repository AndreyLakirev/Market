package org.sber.lakirev.market.service;

import org.sber.lakirev.market.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee add (Employee employee);

    Employee update (Employee employee);

    List<Employee> getAll ();

    Employee getById (Integer id);

    List<Employee> getByStatus (String status);
}
