package com.example.demo.controllers;

import com.example.demo.services.IndexService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(IndexController.class)
public class IndexControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IndexService indexService;

    @Test
    public void testGetIndex_Success() throws Exception {
        // 1. Setup mock behavior
        String expectedResponse = "Hello from the Service!";
        when(indexService.index()).thenReturn(expectedResponse);

        // 2. Perform GET request and verify results
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedResponse));
    }
}