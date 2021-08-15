package com.example.demo1608.Service;

import java.util.Optional;

public interface IGenaralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    void save(T t);

    void remove(Long id);
}
