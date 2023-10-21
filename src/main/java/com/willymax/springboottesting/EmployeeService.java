package com.willymax.springboottesting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author william makau
 * @version 1.0.0
 * Date 2023-10-15
 * Email: william.k.makau@gmail.com
 */
@Service
public class EmployeeService implements EmployeeServiceInt {
    @Autowired
    private EmployeeRepository employeeRepository;

//    public EmployeeService(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }

    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll().stream().map(employee -> {
            return new EmployeeDto(employee.getId(), employee.getName());
        }).toList();
    }
    public Optional<Employee> getEmployeeByName(String name) {
        return employeeRepository.findByName(name);
    }
}
