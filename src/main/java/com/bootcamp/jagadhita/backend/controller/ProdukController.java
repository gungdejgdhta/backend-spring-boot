package com.bootcamp.jagadhita.backend.controller;

import com.bootcamp.jagadhita.backend.entity.Produk;
import com.bootcamp.jagadhita.backend.service.ProdukService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/produk")
@Slf4j

public class ProdukController {

    @Autowired
    ProdukService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> findId(@PathVariable Integer id) {
        try {
            Produk produk = service.findId(id);
            return ResponseEntity.ok(produk);
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.badRequest().body("Data tidak ditemukan");
        }
    }

    @GetMapping("")
    public List<Produk> findAll() {
        return service.findAll();
    }
}
