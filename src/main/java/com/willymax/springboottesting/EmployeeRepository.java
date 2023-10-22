package com.willymax.springboottesting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author william makau
 * @version 1.0.0
 * Date 2023-10-15
 * Email: william.k.makau@gmail.com
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Override
    Optional<Employee> findById(Long aLong);

    Optional<Employee> findByName(String name);
}
