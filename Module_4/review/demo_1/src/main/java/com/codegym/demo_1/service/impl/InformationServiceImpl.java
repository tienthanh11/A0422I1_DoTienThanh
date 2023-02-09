package com.codegym.demo_1.service.impl;

import com.codegym.demo_1.model.Information;
import com.codegym.demo_1.repository.IInformationRepository;
import com.codegym.demo_1.service.IInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class InformationServiceImpl implements IInformationService {

    @Autowired
    private IInformationRepository informationRepository;

    @Override
    public Page<Information> findAll(Pageable pageable) {
        return informationRepository.findAll(pageable);
    }

    @Override
    public void create(Information information) {
        informationRepository.save(information);
    }

    @Override
    public void delete(Integer id) {
        informationRepository.deleteById(id);
    }

    @Override
    public Information findById(Integer id) {
        return informationRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Information> search(String title, String category, Pageable pageable) {
        return informationRepository.search("%" + title + "%", "%" + category + "%", pageable);
    }
}
