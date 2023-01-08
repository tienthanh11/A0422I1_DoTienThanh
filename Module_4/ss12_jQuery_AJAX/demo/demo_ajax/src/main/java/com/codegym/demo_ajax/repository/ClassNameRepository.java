package com.codegym.demo_ajax.repository;

import com.codegym.demo_ajax.entity.ClassName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassNameRepository extends JpaRepository<ClassName, String> {
}
