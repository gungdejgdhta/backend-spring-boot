package com.bootcamp.jagadhita.backend.service;

import com.bootcamp.jagadhita.backend.dao.TransaksiDao;
import com.bootcamp.jagadhita.backend.dto.TransaksiDto;
import com.bootcamp.jagadhita.backend.entity.Transaksi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransaksiService {

    @Autowired
    TransaksiDao dao;

    public List<Transaksi> findAll() {
        return dao.findAll();
    }

    public List<Transaksi> findAllByIdProduk(Integer id) {
        return dao.findAllByIdProduk(id);
    }

    public List<Transaksi> findAllByIdProdusen(Integer id) {
        return dao.findAllByIdProdusen(id);
    }

    public Transaksi findId(Integer id) throws EmptyResultDataAccessException {
        return dao.findId(id);
    }

    @Transactional
    public Integer create(TransaksiDto.Create transaksi) {
        return dao.create(transaksi);
    }

    @Transactional
    public void update(TransaksiDto.Update transaksi) {
        dao.update(transaksi);
    }

    @Transactional
    public void delete(Integer id) {
        dao.delete(id);
    }
}
