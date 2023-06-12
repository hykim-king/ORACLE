package com.pcwk.ehr.service;

import com.pcwk.ehr.domain.MBTIVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class MBTIDaoImpl {

    public List<MBTIVO> getMBTI()throws SQLException {
        List<MBTIVO> test = new ArrayList<>();

        // DB 연결!
        return test;
    }
}
