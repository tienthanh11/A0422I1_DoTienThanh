package com.codegym.services;

import com.codegym.model.Medical;

import java.util.List;

public interface IMedicalServices {
    List<Medical> findAll();

    void update(Medical medical);
}
