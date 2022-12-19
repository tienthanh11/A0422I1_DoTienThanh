package com.codegym.demo_validation.repository;

import com.codegym.demo_validation.model.ClassName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassNameRepository extends JpaRepository<ClassName, String> {
}
