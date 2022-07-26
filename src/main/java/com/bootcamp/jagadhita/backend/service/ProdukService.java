package com.bootcamp.jagadhita.backend.service;

import com.bootcamp.jagadhita.backend.dao.ProdukDao;
import com.bootcamp.jagadhita.backend.entity.Produk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdukService {

    @Autowired
    ProdukDao dao;

    public Produk findId(Integer id) throws EmptyResultDataAccessException {
        return dao.findId(id);
    }

    public List<Produk> findAll() {
        return dao.findAll();
    }

}
