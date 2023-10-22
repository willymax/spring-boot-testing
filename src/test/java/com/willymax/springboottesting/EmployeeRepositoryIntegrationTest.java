package com.willymax.springboottesting;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

/**
 * @author william makau
 * @version 1.0.0
 * Date 2023-10-21
 * Email: william.k.makau@gmail.com
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest // this is very important. When testing with database
class EmployeeRepositoryIntegrationTest {

    // add some records already in our database
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    // write test cases here

    @Test
    void whenFindByName_thenReturnEmployee() {
        // given
        Employee alex = new Employee("alex");
        entityManager.persist(alex);
        entityManager.flush();

        // when
        Optional<Employee> found = employeeRepository.findByName(alex.getName());

        org.junit.jupiter.api.Assertions.assertNotNull(found.orElse(null));

        // then
        Assertions.assertThat(found.get().getName())
                .isEqualTo(alex.getName());
    }
}
