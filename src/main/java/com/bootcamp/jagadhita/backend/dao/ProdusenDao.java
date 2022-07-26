package com.bootcamp.jagadhita.backend.dao;

import com.bootcamp.jagadhita.backend.entity.Produsen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository //anotasi yang dibutuhkan pada 'dao'
public class ProdusenDao {

    //anotasi yang dibutuhkan pada kelas
    NamedParameterJdbcTemplate jdbcTemplate;

    public Produsen findId(Integer id) {
        String query = "SELECT id, nama, kode, alamat\n" +
                "FROM public.produsen where id = :idProdusen"; //where name = :name and kode = :kode
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("idProdusen", id);

        return jdbcTemplate.queryForObject(query, map, new RowMapper<Produsen>() {
            @Override
            public Produsen mapRow(ResultSet rs, int rowNum) throws SQLException {
                Produsen produsen = new Produsen();
                produsen.setId(rs.getInt("id"));
                produsen.setNama(rs.getString("nama"));
                produsen.setKode(rs.getString("kode"));
                produsen.setAlamat(rs.getString("alamat"));
                return produsen;
            }
        });
    }
}
