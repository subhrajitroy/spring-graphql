package com.roy.graphql.demo.services;

import com.roy.graphql.demo.models.Article;
import com.roy.graphql.demo.models.Author;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Component
public class ArticleService {

    private List<Article> articles = new ArrayList<>();

    @PostConstruct
    private void init(){
        final Author roy = new Author("Roy");
        final Author john = new Author("John");
        final Article article1 = new Article("1", "GraphQL", "Demo 1");
        article1.setAuthor(roy);
        articles.add(article1);
        final Article article2 = new Article("2", "GraphQL 2", "Demo 2");
        article2.setAuthor(john);
        articles.add(article2);
    }

    public Article getArticle(String id){
        final Stream<Article> articleStream = articles.stream().filter(a -> a.getId().equals(id));
        final Optional<Article> first = articleStream.findFirst();
        return first.get();
    }

    public List<Article> getAllArticles(){
        return articles;
    }

    public List<Article> add(Article article) {
        articles.add(article);
        return articles;
    }
}
