package com.pcwk.ehr.share;

import java.sql.SQLException;
import java.util.List;


public interface shareDao {


	public List<shareVO> urlSelect(shareVO search) throws SQLException;

}