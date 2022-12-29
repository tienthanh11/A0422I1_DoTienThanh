package com.codegym.demo_aop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Test {
    @Id
    @Column(columnDefinition = "varchar(20)")
    private String id;
    private String name;
}