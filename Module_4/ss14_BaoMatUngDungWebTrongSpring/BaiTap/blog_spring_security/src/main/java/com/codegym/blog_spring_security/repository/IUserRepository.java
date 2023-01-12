package com.codegym.blog_spring_security.repository;

import com.codegym.blog_spring_security.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<Customer, Long> {
    Customer findByUsername(String username);
}
