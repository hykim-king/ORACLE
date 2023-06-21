package com.pcwk.ehr.resultUrl;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Result_UrlServiceImpl implements Result_UrlService {
	final Logger LOG = LogManager.getLogger(getClass());


	@Autowired
	Result_UrlDao resultUrlDao;
	
	@Autowired
    HttpServletRequest request;  // HttpServletRequest 객체 주입


	@Override
	public List<Result_UrlVO> resultSelect(Result_UrlVO search) throws  SQLException{
		LOG.debug(request.getSession().getAttribute("id"));
		String userId = (String) request.getSession().getAttribute("id");  // jsp 세션에서 userId 값을 가져옴
		LOG.debug("userid : "+userId);
        search.setId(userId);
        
		return resultUrlDao.resultSelect(search);
	}
}
