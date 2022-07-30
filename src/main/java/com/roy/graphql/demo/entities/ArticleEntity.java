package com.roy.graphql.demo.entities;

import com.roy.graphql.demo.models.Author;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ArticleEntity {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column
    private String title;
    @Column
    private String text;

    public ArticleEntity() {

    }

    public ArticleEntity(String id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }
}
