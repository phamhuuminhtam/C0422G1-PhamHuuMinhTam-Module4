package com.example.blog_v2.model;

import javax.persistence.*;

@Entity
@Table
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;

    public Blog() {
    }

    public Blog(Category category) {
        this.category = category;
    }

    @ManyToOne()
    private Category category;

    public Category getCategory() {
        return category;
    }

    public Blog(Integer id, String title, String content, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.category = category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Blog(Integer id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Blog(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
