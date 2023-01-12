package com.codegym.blog_spring_security.model;

import com.codegym.blog_spring_security.dto.BlogDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "blog")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String content;
    String title;

    @Column(name = "category_id")
    Category category;


    public Blog(BlogDTO blogDTO) {
        this.name = blogDTO.getName();
        this.content = blogDTO.getContent();
        this.title = blogDTO.getTitle();
        this.category = Category.getCategoryById(blogDTO.getCategory());
    }
}
