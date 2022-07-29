package com.bootcamp.jagadhita.backend.controller;

import com.bootcamp.jagadhita.backend.dto.TransaksiDto;
import com.bootcamp.jagadhita.backend.entity.Transaksi;
import com.bootcamp.jagadhita.backend.service.TransaksiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/transaksi")
@Slf4j

public class TransaksiController {

    @Autowired
    TransaksiService service;

    @GetMapping("")
    public List<Transaksi> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findId(@PathVariable Integer id) {
        try {
            Transaksi transaksi = service.findId(id);
            return ResponseEntity.ok(transaksi);
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.badRequest().body("Data Tidak Ditemukan");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> create
            (@RequestBody @Valid TransaksiDto.Create transaksi,
             BindingResult result) {
        Map<String, Object> output = new HashMap<>();
        if (result.hasErrors()) {
            output.put("id", null);
            output.put("status", "Create Data Gagal");
            output.put("errors", result.getAllErrors());
            return ResponseEntity.badRequest().body(output);
        } else {
            output.put("id", service.create(transaksi));
            output.put("status", "Create Data Berhasil");
            return ResponseEntity.ok(output);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Map<String, Object>> update
            (@RequestBody @Valid TransaksiDto.Update transaksi,
             BindingResult result) {
        Map<String, Object> output = new HashMap<>();
        if (result.hasErrors()) {
            output.put("status", "Update Data Gagal");
            output.put("errors", result.getAllErrors());
            return ResponseEntity.ok().body(output);
        } else {
            try {
                service.findId(transaksi.getId());
                service.update(transaksi);
                output.put("status", "Update Data Berhasil");
                return ResponseEntity.ok().body(output);
            } catch (EmptyResultDataAccessException e) {
                output.put("status", "Id Tidak Ditemukan");
                return ResponseEntity.badRequest().body(output);
            }
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> delete
            (@PathVariable Integer id) {
        Map<String, Object> output = new HashMap<>();
        try {
            service.findId(id);
            service.delete(id);
            output.put("status", "Delete Data Berhasil");
            return ResponseEntity.ok(output);
        } catch (EmptyResultDataAccessException e) {
            output.put("status", "Id Tidak Ditemukan");
            return ResponseEntity.badRequest().body(output);
        }
    }
}
