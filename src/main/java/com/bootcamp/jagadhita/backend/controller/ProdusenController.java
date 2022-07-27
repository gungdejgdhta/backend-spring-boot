package com.bootcamp.jagadhita.backend.controller;

import com.bootcamp.jagadhita.backend.dto.ProdusenDto;
import com.bootcamp.jagadhita.backend.entity.Produsen;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.bootcamp.jagadhita.backend.service.ProdusenService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/produsen")
@Slf4j

public class ProdusenController {

    @Autowired
    ProdusenService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> findId(@PathVariable Integer id) {
        try { //digunakan untuk mengulang data
            Produsen produsen = service.findId(id);
            return ResponseEntity.ok(produsen);
        } catch (EmptyResultDataAccessException e) { //digunakan untuk menangkap data
            //return null; //digunakan jika tipe datanya Produsen
            return ResponseEntity.badRequest().body("Data tidak ditemukan");
        }
    }

    @GetMapping("")
    public List<Produsen> findAll() {
        return service.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> create
            (@RequestBody @Valid ProdusenDto.Create produsen, BindingResult result) {
        Map<String, Object> output = new HashMap<>();
        if (result.hasErrors()) {
            output.put("id", null);
            output.put("status", "Crate Data Gagal");
            output.put("errors", result.getAllErrors());
            return ResponseEntity.badRequest().body(output);

        } else {
            output.put("id", service.create(produsen));
            output.put("status", "Create Data Berhasil");
            return ResponseEntity.ok(output);
        }
    }

    @PutMapping("/update") //Digunakan jika ingin mengupdate semua data pada Produsen
    /*@PatchMapping("/update")*/ //Digunakan jika ingin mengupdate tiap 'satu' data pada Produsen
    public ResponseEntity<Map<String, Object>> update
    (@RequestBody @Valid ProdusenDto.Update produsen,
     BindingResult result) {
        Map<String, Object> output = new HashMap<>();
        if (result.hasErrors()) { //Mengecek Validasi terlebih dahulu
            output.put("status", "Update Data Gagal");
            output.put("errors", result.getAllErrors());
            return ResponseEntity.badRequest().body(output);
        } else {
            try {
                service.findId(produsen.getId());
                service.update(produsen);
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
