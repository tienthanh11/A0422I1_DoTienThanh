package com.codegym.demo_spring_data_repository.repository;

import com.codegym.demo_spring_data_repository.entity.ClassName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassNameRepository extends JpaRepository<ClassName, String> {
}
