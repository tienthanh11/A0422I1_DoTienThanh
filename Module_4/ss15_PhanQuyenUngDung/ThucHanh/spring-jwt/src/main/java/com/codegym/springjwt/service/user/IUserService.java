package com.codegym.springjwt.service.user;

import com.codegym.springjwt.model.User;
import com.codegym.springjwt.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends IGeneralService<User>, UserDetailsService {
    Optional<User> findByUsername(String username);
}