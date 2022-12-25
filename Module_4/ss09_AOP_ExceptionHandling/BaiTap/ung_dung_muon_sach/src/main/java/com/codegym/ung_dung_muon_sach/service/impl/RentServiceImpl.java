package com.codegym.ung_dung_muon_sach.service.impl;

import com.codegym.ung_dung_muon_sach.model.Rent;
import com.codegym.ung_dung_muon_sach.repository.IRentRepository;
import com.codegym.ung_dung_muon_sach.service.IRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RentServiceImpl implements IRentService {

    @Autowired
    IRentRepository rentRepository;

    @Override
    public Iterable<Rent> findAll() {
        return rentRepository.findAll();
    }

    @Override
    public Optional<Rent> findById(Integer id) {
        return rentRepository.findById(id);
    }

    @Override
    public void save(Rent rent) {
        rentRepository.save(rent);
    }
}
