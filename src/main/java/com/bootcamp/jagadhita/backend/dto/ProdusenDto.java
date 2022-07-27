package com.bootcamp.jagadhita.backend.dto;

/*Fungsi DTO hampir mirip dengan entity namun pada DTO hanya memasukan
Variable yang kan diinputkan*/

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProdusenDto {
    //Penggunaan integer pada Data Dto hanya menggunakan NotNull karena sifat data adalah ""
    @Data //Untuk memasukan Getter dan Setter pada class
    @NoArgsConstructor //Untuk memasukan class kosong seperti ProdusenDto(){}
    public static class Create {
        /*@Min(5)*/ //Minimal input untuk integer
        @Size(min = 5) //Minimal input untuk String object
        @NotEmpty
        @NotNull
        String nama;

        @Size(min = 2)
        @NotEmpty
        @NotNull
        String kode;

        @NotEmpty
        @NotNull
        String alamat;
    }

    @Data
    @NoArgsConstructor
    public static class Update {
        @Min(1)
        @NotNull
        Integer id;

        @Size(min = 5) //Minimal input untuk String object
        @NotEmpty
        @NotNull
        String nama;

        @Size(min = 2)
        @NotEmpty
        @NotNull
        String kode;

        @NotEmpty
        @NotNull
        String alamat;
    }
}
