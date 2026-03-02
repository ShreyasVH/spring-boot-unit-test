package com.example.demo.repositories;

import org.springframework.stereotype.Repository;

@Repository
public class IndexRepository
{
    public String index()
    {
        return "Index repository";
    }
}
