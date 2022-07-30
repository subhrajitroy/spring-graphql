package com.roy.graphql.demo.repository;

import com.roy.graphql.demo.entities.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticlesRepository extends JpaRepository<ArticleEntity,String> {
}
