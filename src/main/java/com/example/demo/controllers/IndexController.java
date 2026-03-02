package com.example.demo.controllers;

import com.example.demo.services.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class IndexController
{
    @Autowired
    private IndexService indexService;

    @GetMapping("/")
    public String get()
    {
        return this.indexService.index();
    }
}
