package com.maven.bookService.service;

import java.util.List;
import java.util.Optional;

public interface GenericService<T> {
    public T getObjectById(long id);

    public List<T> findAllObject();

    public T saveObject(T obj);

    public Optional<T> findObjectById(long id);

}
