package com.bootcamp.jagadhita.backend.dao;

import com.bootcamp.jagadhita.backend.entity.Produk;
import com.bootcamp.jagadhita.backend.entity.Produsen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProdukDao {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public Produk findId(Integer id) {
        String query = "SELECT id, nama, jenis, berat\n" +
                "FROM public.produk where id = :idProduk";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("idProduk", id);

        return jdbcTemplate.queryForObject(query, map, new RowMapper<Produk>() {
            @Override
            public Produk mapRow(ResultSet rs, int rowNum) throws SQLException {
                Produk produk = new Produk();
                produk.setId(rs.getInt("id"));
                produk.setNama(rs.getString("nama"));
                produk.setJenis(rs.getString("jenis"));
                produk.setBerat(rs.getString("berat"));
                return produk;
            }
        });
    }

    public List<Produk> findAll() {
        String query = "SELECT id, nama, jenis, berat\n" +
                "FROM public.produk";
        return jdbcTemplate.query(query, new RowMapper<Produk>() {
            @Override
            public Produk mapRow(ResultSet rs, int rowNum) throws SQLException {
                Produk produk = new Produk();
                produk.setId(rs.getInt("id"));
                produk.setNama(rs.getString("nama"));
                produk.setJenis(rs.getString("jenis"));
                produk.setBerat(rs.getString("berat"));
                return produk;
            }
        });
    }
}
