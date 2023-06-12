package com.pcwk.ehr.service;

import com.pcwk.ehr.service.MBTIDaoImpl;
import com.pcwk.ehr.domain.MBTIVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class MBTIService {
    @Autowired
    MBTIDaoImpl mbtiDao;

    public List<MBTIVO> getMBTI() throws SQLException {
        return mbtiDao.getMBTI();
    }
}
