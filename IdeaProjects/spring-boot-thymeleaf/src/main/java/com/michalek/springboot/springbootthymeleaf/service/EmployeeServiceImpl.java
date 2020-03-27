package com.michalek.springboot.springbootthymeleaf.service;

import com.michalek.springboot.springbootthymeleaf.dao.EmployeeRepository;
import com.michalek.springboot.springbootthymeleaf.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Employee findById(int employeeId) {

        Optional<Employee> result = employeeRepository.findById(employeeId);

        Employee employee = null;

        if(result.isPresent()) {
            employee = result.get();
        }else {
            throw new RuntimeException("Did not find employee id: " + employeeId);
        }

        return employee;
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
