package com.roy.graphql.demo.controllers;

import com.roy.graphql.demo.models.Article;
import com.roy.graphql.demo.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class ArticleController {

    private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService){
        this.articleService = articleService;
    }

    @SchemaMapping(typeName = "Query",field = "article")
    public Article getArticle(@Argument String id){
        return articleService.getArticle(id);
    }

    @SchemaMapping(typeName = "Query",field = "allArticles")
    public List<Article> getAllArticle(){
        return articleService.getAllArticles();
    }

//    @MutationMapping
//    public List<Article> addArticle(@Argument Article article){
//        return articleService.add(article);
//    }


}
