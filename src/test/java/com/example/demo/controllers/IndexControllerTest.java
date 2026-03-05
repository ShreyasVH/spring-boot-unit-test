package com.example.demo.controllers;

import com.example.demo.services.IndexService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(IndexController.class)
class IndexControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private IndexService indexService;

    @Test
    void testGetIndex_Success() throws Exception {
        String expectedResponse = "Hello from the Service!";
        when(indexService.index()).thenReturn(expectedResponse);

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedResponse));
    }
}