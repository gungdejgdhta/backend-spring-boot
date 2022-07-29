package com.bootcamp.jagadhita.backend.dao;

import com.bootcamp.jagadhita.backend.dto.TransaksiDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TransaksiDetailDao {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public TransaksiDetailDto findId(Integer id) {
        String query = "select transaksi.id, transaksi.kuantitas,\n" +
                "produk.nama as produk,\n" +
                "produsen.nama as produsen,\n" +
                "produk.harga as harga,\n" +
                "produk.berat as produk_berat,\n" +
                "produk.harga as produk_harga\n" +
                "from public.transaksi transaksi\n" +
                "left join produk produk on transaksi.produk_id = produk.id\n" +
                "where transaksi.id = :idDetail";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("idDetail", id);
        return jdbcTemplate.queryForObject(query, map, new RowMapper<TransaksiDetailDto>() {
            @Override
            public TransaksiDetailDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                TransaksiDetailDto detail = new TransaksiDetailDto();
                detail.setId(rs.getInt("id"));
                detail.setProduk(rs.getString("produk_nama"));
                detail.setProdusen(rs.getString("produsen_nama"));
                detail.setHarga(rs.getDouble("produk_harga"));
                detail.setKuantitas(rs.getInt("kuantitas"));
                detail.setTotalHarga(rs.getDouble("produk_harga") * rs.getInt("kuantitas"));

                return detail;
            }
        });
    }

}
