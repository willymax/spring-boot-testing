package com.willymax.springboottesting;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @author william makau
 * @version 1.0.0
 * Date 2023-10-15
 * Email: william.k.makau@gmail.com
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK
)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties"
)
class EmployeeDtoRestControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmployeeRepository repository;

    @Test
    void givenEmployees_whenGetEmployees_thenStatus200()
            throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/v1/employees")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", CoreMatchers.is("william")));
    }
}
