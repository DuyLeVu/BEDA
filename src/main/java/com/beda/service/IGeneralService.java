package com.beda.service;

import com.beda.exception.AppException;

import java.util.Optional;

public interface IGeneralService <T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save(T t) throws AppException;

    void remove(Long id);
}

