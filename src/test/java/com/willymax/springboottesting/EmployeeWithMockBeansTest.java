package com.willymax.springboottesting;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

/**
 * @author william makau
 * @version 1.0.0
 * Date 2023-10-21
 * Email: william.k.makau@gmail.com
 */
@ExtendWith(SpringExtension.class)
class EmployeeWithMockBeansTest {
    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public EmployeeService employeeService() {
            return new EmployeeService();
        }
    }
    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;


    @BeforeEach
    public void setUp() {
        Employee alex = new Employee("alex");

        Mockito.when(employeeRepository.findByName(alex.getName()))
                .thenReturn(Optional.of(alex));
    }

    @Test
    void whenValidName_thenEmployeeShouldBeFound() {
        String name = "alex";
        Optional<Employee> found = employeeService.getEmployeeByName(name);
        org.junit.jupiter.api.Assertions.assertNotNull(found.orElse(null));
        Assertions.assertThat(found.get().getName())
                .isEqualTo(name);
    }
}
