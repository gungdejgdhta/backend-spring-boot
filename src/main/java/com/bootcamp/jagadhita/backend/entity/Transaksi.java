package com.bootcamp.jagadhita.backend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Transaksi {

    Integer id;
    Integer kuantitas;
    Produk produk;
}
