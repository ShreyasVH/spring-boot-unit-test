package com.example.demo.services.impl;

import com.example.demo.repositories.IndexRepository;
import com.example.demo.services.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexServiceImpl implements IndexService
{
    @Autowired
    private IndexRepository indexRepository;

    public String index()
    {
        return this.indexRepository.index();
    }
}
