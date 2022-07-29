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
    @Min(1)
    @NotNull
    Integer id;

    @Size(min = 4)
    @NotNull
    @NotEmpty
    String produk;

    @Size(min = 4)
    @NotNull
    @NotEmpty
    String produsen;

    @Min(3)
    @NotNull
    Double harga;

    @Min(1)
    @NotNull
    Integer kuantitas;

    @Min(4)
    @NotNull
    Double totalHarga;
}
