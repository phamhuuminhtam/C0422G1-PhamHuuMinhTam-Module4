package com.furama.service.employee;

import com.furama.model.customer.Customer;
import com.furama.model.employee.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    void save(Employee employee);

    Employee findById(Integer id);

    void delete(Integer id);
}
