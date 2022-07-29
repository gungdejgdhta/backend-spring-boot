package com.bootcamp.jagadhita.backend.service;

import com.bootcamp.jagadhita.backend.dao.TransaksiDetailDao;
import com.bootcamp.jagadhita.backend.dto.TransaksiDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Size;
import java.util.List;

@Service
public class TransaksiDetailService {

    @Autowired
    TransaksiDetailDao dao;

    public TransaksiDetailDto findId(Integer id) {
        return dao.findId(id);
    }
}
