package com.roy.graphql.demo.models;

import org.springframework.graphql.data.method.annotation.SchemaMapping;


public class Author {
    private String name;

    public Author(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
