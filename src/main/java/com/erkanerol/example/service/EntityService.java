package com.erkanerol.example.service;

import com.erkanerol.example.exceptions.NoContentException;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by erkan on 15.06.2016.
 */
public interface EntityService<T> {

    @Transactional
    public  T getById(Long id) throws NoContentException;

    @Transactional
    public List<T> getAll();

    @Transactional
    public  T create(T entity);

    @Transactional
    public  T update(T entity);

    @Transactional
    public  void delete(Long id);
}
