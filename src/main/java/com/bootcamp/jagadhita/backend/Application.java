package com.bootcamp.jagadhita.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController //anotasi
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Halo Dunia!";
    }

    @GetMapping("/hello")
    public String hello(@RequestParam String namaDepan, @RequestParam String namaBelakang, @RequestParam Integer umur) {
        return "Halo, " + namaDepan + " " + namaBelakang + ". Umur saya adalah " + umur;
    }



}
