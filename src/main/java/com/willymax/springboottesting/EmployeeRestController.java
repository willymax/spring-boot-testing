package com.willymax.springboottesting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author william makau
 * @version 1.0.0
 * Date 2023-10-15
 * Email: william.k.makau@gmail.com
 */
@RestController()
@RequestMapping("/api/v1")
public class EmployeeRestController {
    private final EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(produces = "text/plain")
    public String index() {
        return "Hello World";
    }

    @GetMapping(value = "/employees")
    public List<EmployeeDto> getEmployees() {
        return employeeService.getAllEmployees();
    }
}
