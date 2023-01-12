package com.codegym.blog_spring_security.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "customer", uniqueConstraints = {@UniqueConstraint(name = "APP_USER_UK", columnNames = "username")})
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String password;
    @Column(name = "enabled", length = 1, nullable = false)
    private boolean enabled;
}
