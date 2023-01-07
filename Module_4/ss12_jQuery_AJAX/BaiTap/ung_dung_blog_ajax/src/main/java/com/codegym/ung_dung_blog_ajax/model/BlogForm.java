package com.codegym.ung_dung_blog_ajax.model;

import org.springframework.web.multipart.MultipartFile;

public class BlogForm {
    private int id;
    private String createTime;
    private String author;
    private Integer category_id;
    private MultipartFile image;
    private String body;

    public BlogForm() {
    }

    public BlogForm(int id, String createTime, String author, MultipartFile image, String body) {
        this.id = id;
        this.createTime = createTime;
        this.author = author;
        this.image = image;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
