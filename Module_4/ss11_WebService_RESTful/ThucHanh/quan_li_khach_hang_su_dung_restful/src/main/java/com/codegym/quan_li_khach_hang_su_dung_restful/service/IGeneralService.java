package com.codegym.quan_li_khach_hang_su_dung_restful.service;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    T save(T t);
    void remove(Long id);
}
