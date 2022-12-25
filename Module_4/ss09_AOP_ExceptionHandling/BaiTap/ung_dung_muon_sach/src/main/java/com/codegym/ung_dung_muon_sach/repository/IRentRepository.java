package com.codegym.ung_dung_muon_sach.repository;

import com.codegym.ung_dung_muon_sach.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IRentRepository extends JpaRepository<Rent, Integer> {
    @Query("select r from Rent r where r.status = 'on'")
    List<Rent> findAll();

    @Query("select r from Rent r where r.status = 'on' and r.id = :id")
    Optional<Rent> findById(@Param("id") Integer id);
}
