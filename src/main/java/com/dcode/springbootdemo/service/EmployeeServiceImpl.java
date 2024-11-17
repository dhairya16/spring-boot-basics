package com.dcode.springbootdemo.service;

import com.dcode.springbootdemo.error.EmployeeNotFoundException;
import com.dcode.springbootdemo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> employees = new ArrayList<>();

    @Override
    public Employee save(Employee employee) {
        if (employee.getEmployeeId() == null || employee.getEmployeeId().isEmpty()) {
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employees
                .stream()
                .filter(emp -> Objects.equals(emp.getEmployeeId(), id))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee does not exists with id " + id));
    }

    @Override
    public void deleteEmployeeById(String id) {
        Employee emp = employees
                .stream()
                .filter(e -> Objects.equals(e.getEmployeeId(), id))
                .findFirst()
                .get();
        employees.remove(emp);
    }
}
