package com.codegym.exam.repository;

import com.codegym.exam.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IServerRepository extends JpaRepository<Service, Integer> {
    @Query(value = "select * from Service where service_type like ? and customer_id like ?", nativeQuery = true)
    Page<Service> search(String service_type, String customer_id, Pageable pageable);
}
