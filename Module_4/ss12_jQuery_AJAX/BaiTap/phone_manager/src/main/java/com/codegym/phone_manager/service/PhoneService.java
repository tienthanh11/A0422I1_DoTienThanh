package com.codegym.phone_manager.service;

import com.codegym.phone_manager.model.Smartphone;
import com.codegym.phone_manager.repository.IPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService implements IPhoneService {

    @Autowired
    IPhoneRepository phoneRepository;

    @Override
    public List<Smartphone> findAll() {
        return phoneRepository.findAll();
    }

    @Override
    public Smartphone findById(Long id) {
        return phoneRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Smartphone smartphone) {
        phoneRepository.save(smartphone);
    }

    @Override
    public List<Smartphone> findAllByModelContainsAndStatus(String model, String status) {
        return phoneRepository.findAllByModelContainsAndStatus(model, status);
    }
}
