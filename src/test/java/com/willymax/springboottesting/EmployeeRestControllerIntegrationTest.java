package com.willymax.springboottesting;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author william makau
 * @version 1.0.0
 * Date 2023-10-21
 * Email: william.k.makau@gmail.com
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(EmployeeRestController.class) // when testing controllers
class EmployeeRestControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private EmployeeService service;

    // write test cases here
    @Test
    void givenEmployees_whenGetEmployees_thenReturnJsonArray()
            throws Exception {
        EmployeeDto alex = new EmployeeDto(1L, "alex");

        List<EmployeeDto> allEmployees = List.of(alex);

        // mock the service here
        BDDMockito.given(service.getAllEmployees()).willReturn(allEmployees);


        mvc.perform(MockMvcRequestBuilders.get("/api/v1/employees")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", CoreMatchers.is(alex.getName())));
    }
}
