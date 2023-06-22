package com.pcwk.ehr.resultUrl;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;


public interface Result_UrlService {
	

	public List<Result_UrlVO> resultSelect(Result_UrlVO search) throws SQLException;


}
