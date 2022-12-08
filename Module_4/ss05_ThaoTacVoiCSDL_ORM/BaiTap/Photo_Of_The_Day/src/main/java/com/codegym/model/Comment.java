package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "star")
    Integer star;

    @ManyToOne
    @JoinColumn(name = "id_picture", nullable = false, referencedColumnName = "id")
    Picture picture;

    @Column(name = "author")
    String author;

    @Column(name = "feedback")
    String feedback;

    public Comment() {
    }

    public Comment(Integer id, Integer star, Picture picture, String author, String feedback) {
        this.id = id;
        this.star = star;
        this.picture = picture;
        this.author = author;
        this.feedback = feedback;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
