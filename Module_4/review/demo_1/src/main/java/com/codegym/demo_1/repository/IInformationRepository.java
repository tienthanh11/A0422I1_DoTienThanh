package com.codegym.demo_1.repository;

import com.codegym.demo_1.model.Information;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IInformationRepository extends JpaRepository<Information, Integer> {
    @Query(value = "select * from Information where `title` like ? and category_id like ?", nativeQuery = true)
    Page<Information> search(String title, String category, Pageable pageable);
}
