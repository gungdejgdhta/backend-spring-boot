package com.bootcamp.jagadhita.backend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Produk {
    Integer id;
    String nama;
    String jenis;
    String berat;
    Produsen produsen;
    Double harga;
    // Meskipun pada database menggunakan variable produsen_id namun pada
    // penulisan produsen untuk menyambungkan dari FK produsen_id

}
