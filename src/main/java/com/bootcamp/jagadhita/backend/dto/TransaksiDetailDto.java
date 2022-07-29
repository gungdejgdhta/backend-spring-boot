package com.bootcamp.jagadhita.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class TransaksiDetailDto {
    /*@Min(1)
    @NotNull*/ //Digunakan jika ada Validasi Data
    Integer id;
    String produk;
    String produsen;
    Double harga;
    Integer kuantitas;
    Double totalHarga;
}
