package com.dcode.springbootdemo.repository;

import com.dcode.springbootdemo.employee.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, String> { // entity, type of id
}
