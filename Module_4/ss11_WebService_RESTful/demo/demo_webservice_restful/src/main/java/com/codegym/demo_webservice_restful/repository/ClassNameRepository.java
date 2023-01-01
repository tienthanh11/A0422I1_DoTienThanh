package com.codegym.demo_webservice_restful.repository;

import com.codegym.demo_webservice_restful.entity.ClassName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassNameRepository extends JpaRepository<ClassName, String> {
}
