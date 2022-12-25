package com.codegym.ung_dung_muon_sach.service;

import com.codegym.ung_dung_muon_sach.model.Rent;

import java.util.Optional;

public interface IRentService {
    Iterable<Rent> findAll();

    Optional<Rent> findById(Integer id);

    void save(Rent rent);
}
