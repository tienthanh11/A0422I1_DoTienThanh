package com.codegym.demo_1.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "information")
public class Information {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Bạn chưa nhập tiêu đề")
    @Size(max = 50, message = "Tiêu đề không quá 50 ký tự")
    private String title;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @NotNull(message = "Bạn chưa nhập danh mục")
    private Category categoryId;

    @NotEmpty(message = "Bạn chưa nhập nội dung")
    @Size(max = 500, message = "Nội dung không quá 500 ký tự")
    private String content;

    @NotNull(message = "Bạn chưa nhập ngày")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date date;

    @NotEmpty(message = "Bạn chưa nhập phóng viên")
    private String reporter;

    public Information() {
    }

    public Information(Integer id, String title, Category categoryId, String content, Date date, String reporter) {
        this.id = id;
        this.title = title;
        this.categoryId = categoryId;
        this.content = content;
        this.date = date;
        this.reporter = reporter;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }
}
