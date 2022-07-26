package com.bootcamp.jagadhita.backend.service;

import com.bootcamp.jagadhita.backend.dao.ProdusenDao;
import com.bootcamp.jagadhita.backend.entity.Produsen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //repository yang digunakan pada service
public class ProdusenService {

    @Autowired
    ProdusenDao dao;

    public Produsen findId(Integer id) throws EmptyResultDataAccessException {
        return dao.findId(id);
    }

    public List<Produsen> findAll() {
        return dao.findAll();
    }
}
