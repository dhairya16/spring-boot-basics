package com.dcode.springbootdemo.service;

import com.dcode.springbootdemo.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(String id);

    void deleteEmployeeById(String id);
}
