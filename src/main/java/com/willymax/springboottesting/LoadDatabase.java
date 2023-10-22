package com.willymax.springboottesting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author william makau
 * @version 1.0.0
 * Date 2023-10-15
 * Email: william.k.makau@gmail.com
 */
@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);


    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository) {
        return args -> {
            log.info("Preloading {}", employeeRepository.save(new Employee("william")));
            log.info("Preloading {}", employeeRepository.save(new Employee("makau")));
        };
    }
}
