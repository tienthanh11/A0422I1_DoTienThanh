package com.codegym.repository;

import com.codegym.model.Medical;

import java.util.List;

public interface IMedicalRepository {
    List<Medical> findAll();

    void update(Medical medical);
}