package com.bootcamp.jagadhita.backend.controller;

import com.bootcamp.jagadhita.backend.dto.TransaksiDetailDto;
import com.bootcamp.jagadhita.backend.service.TransaksiDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transaksi/detail")
public class TransaksiDetailController {

    @Autowired
    TransaksiDetailService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> findId(@PathVariable Integer id) {
        try {
            TransaksiDetailDto detail = service.findId(id);
            return ResponseEntity.ok(detail);
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.badRequest().body("Id Tidak Ditemukan");
        }
    }
}
