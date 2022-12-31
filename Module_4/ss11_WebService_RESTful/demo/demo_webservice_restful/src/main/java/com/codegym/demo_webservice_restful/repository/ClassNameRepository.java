package com.codegym.demo_webservice_restful.repository;

import codegym.vn.springboot.entity.ClassName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassNameRepository extends JpaRepository<ClassName, String> {
}
