package com.leojcl.employees.service;

import com.leojcl.employees.entity.Employee;
import com.leojcl.employees.request.EmployeeRequest;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findById(long id);

    Employee save(EmployeeRequest employeeRequest);

    Employee update(long id, EmployeeRequest employeeRequest);

    void deleteById(long id);

    Employee convertToEmployee(long id, EmployeeRequest employeeRequest);
}
