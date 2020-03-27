package com.michalek.springboot.springbootthymeleaf.service;

import com.michalek.springboot.springbootthymeleaf.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int employeeId);

    void save(Employee employee);

    void deleteById(int employeeId);
}
