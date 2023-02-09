package com.codegym.exam.service.impl;

import com.codegym.exam.model.Service;
import com.codegym.exam.repository.IServerRepository;
import com.codegym.exam.service.IServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@org.springframework.stereotype.Service
public class ServerServiceImpl implements IServerService {

    @Autowired
    private IServerRepository serverRepository;

    @Override
    public Page<Service> findAll(Pageable pageable) {
        return serverRepository.findAll(pageable);
    }

    @Override
    public Page<Service> search(String serviceType, String customerId, Pageable pageable) {
        return serverRepository.search("%" + serviceType + "%", "%" + customerId + "%", pageable);
    }

    @Override
    public List<Service> findAll() {
        return serverRepository.findAll();
    }

    @Override
    public void save(Service service) {
        serverRepository.save(service);
    }

    @Override
    public void delete(Integer id) {
        serverRepository.deleteById(id);
    }

    @Override
    public Service findById(Integer id) {
        return serverRepository.findById(id).orElse(null);
    }
}
