package com.codegym.phone_manager.repository;

import com.codegym.phone_manager.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPhoneRepository extends JpaRepository<Smartphone, Long> {

    @Query("select p from Smartphone p where p.status = 'on'")
    List<Smartphone> findAll();

    List<Smartphone> findAllByModelContainsAndStatus(String model, String status);
}
