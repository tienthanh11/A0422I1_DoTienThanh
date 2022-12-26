package com.codegym.picture_update.service;

import com.codegym.picture_update.model.Image;

import java.util.Optional;

public interface ImageService {
    Iterable<Image> findAll();

    void save(Image image);

    void remove(Long id);

    Optional<Image> findById(Long id);
}
