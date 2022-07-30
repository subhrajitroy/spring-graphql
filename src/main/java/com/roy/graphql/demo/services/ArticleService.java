package com.roy.graphql.demo.services;

import com.roy.graphql.demo.entities.ArticleEntity;
import com.roy.graphql.demo.models.Article;
import com.roy.graphql.demo.models.Author;
import com.roy.graphql.demo.repository.ArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class ArticleService {


    private ArticlesRepository repository;
    private List<ArticleEntity> articleList = new ArrayList<>();

    @Autowired
    public ArticleService(ArticlesRepository repository) {
        this.repository = repository;
        articleList.add(new ArticleEntity("a123","Hello World","Article wished you good health"));
    }

    @Transactional
    public List<Article> getAllArticles(){
        final List<ArticleEntity> all = repository.findAll();
        final Stream<Article> articleStream = all.stream().map(a -> map(a));
        return articleStream.collect(Collectors.toList());
    }

    @Transactional
    public List<Article> add(Article article) {
        final String id = UUID.randomUUID().toString();
        repository.save(new ArticleEntity(id,article.getTitle(),article.getText()));
        return getAllArticles();
    }

    public Article getArticle(String id){
        final Optional<ArticleEntity> article = Optional.of(articleList.get(0));
        return map(article.get());
    }

    private Article map(ArticleEntity entity) {
        return new Article(entity.getId(),entity.getTitle(),entity.getText());
    }


}
