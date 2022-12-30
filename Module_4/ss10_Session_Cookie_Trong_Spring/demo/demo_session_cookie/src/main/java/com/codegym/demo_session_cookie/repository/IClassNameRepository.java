package com.codegym.demo_session_cookie.repository;

import com.codegym.demo_session_cookie.model.ClassName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassNameRepository extends JpaRepository<ClassName, String> {
}
