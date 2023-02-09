package com.codegym.demo_1.service;

import com.codegym.demo_1.model.Information;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IInformationService {
    Page<Information> findAll(Pageable pageable);

    void create(Information information);

    void delete(Integer id);

    Information findById(Integer id);

    Page<Information> search(String title, String category, Pageable pageable);
}
