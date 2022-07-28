package com.bootcamp.jagadhita.backend.entity;

public class Produk {
    Integer id;
    String nama;
    String jenis;
    String berat;
    Produsen produsen;
    // Meskipun pada database menggunakan variable produsen_id namun pada
    // penulisan produsen untuk menyambungkan dari FK produsen_id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getBerat() {
        return berat;
    }

    public void setBerat(String berat) {
        this.berat = berat;
    }

    public Produsen getProdusen() {
        return produsen;
    }

    public void setProdusen(Produsen produsen) {
        this.produsen = produsen;
    }
}
