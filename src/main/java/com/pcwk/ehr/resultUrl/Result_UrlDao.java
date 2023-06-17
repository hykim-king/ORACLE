package com.pcwk.ehr.resultUrl;

import java.sql.SQLException;
import java.util.List;


public interface Result_UrlDao {


	public List<Result_UrlVO> resultSelect(Result_UrlVO search) throws SQLException;

}