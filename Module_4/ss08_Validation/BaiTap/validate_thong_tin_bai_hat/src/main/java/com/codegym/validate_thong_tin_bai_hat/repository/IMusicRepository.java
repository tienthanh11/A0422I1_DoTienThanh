package com.codegym.validate_thong_tin_bai_hat.repository;

import com.codegym.validate_thong_tin_bai_hat.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMusicRepository extends JpaRepository<Music, String> {
}
