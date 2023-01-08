package com.codegym.phone_manager.service;

import com.codegym.phone_manager.model.Smartphone;

import java.util.List;

public interface IPhoneService {
    List<Smartphone> findAll();

    Smartphone findById(Long id);

    void save(Smartphone smartphone);

    List<Smartphone> findAllByModelContainsAndStatus(String model, String status);
}
