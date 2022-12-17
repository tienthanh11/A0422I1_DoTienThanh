package com.codegym.validate_form_register.service;

import com.codegym.validate_form_register.model.User;
import com.codegym.validate_form_register.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
