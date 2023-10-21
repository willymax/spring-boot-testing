package com.willymax.springboottesting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author william makau
 * @version 1.0.0
 * Date 2023-10-15
 * Email: william.k.makau@gmail.com
 */
@ExtendWith(SpringExtension.class)
class EmployeeWithoutContextTest {
    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Test
    void givenEmployees_whenGetEmployees_thenStatus200()
            throws Exception {
        Assertions.assertEquals(1, employeeService.getAllEmployees().size());
    }

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public EmployeeService employeeService() {
            return new EmployeeService() {
                @Override
                public List<EmployeeDto> getAllEmployees() {
                    Stream<EmployeeDto>
                            stream = Stream.of(new EmployeeDto(1L, "william"));

                    return stream.collect(Collectors.toList());
                }
            };
        }
    }
}
