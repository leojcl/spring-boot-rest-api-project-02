package com.leojcl.employees.dao;

import com.leojcl.employees.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(long id);

    Employee save(Employee theEmployee);

    void deleteById(long id);
}
