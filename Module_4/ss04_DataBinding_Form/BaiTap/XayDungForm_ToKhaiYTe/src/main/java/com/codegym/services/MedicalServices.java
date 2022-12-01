package com.codegym.services;

import com.codegym.model.Medical;
import com.codegym.repository.IMedicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalServices implements IMedicalServices {
    @Autowired
    private IMedicalRepository iMedicalRepository;

    @Override
    public List<Medical> findAll() {
        return iMedicalRepository.findAll();
    }

    @Override
    public void update(Medical medical) {
        iMedicalRepository.update(medical);
    }
}
