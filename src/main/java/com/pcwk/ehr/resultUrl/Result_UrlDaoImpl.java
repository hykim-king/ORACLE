package com.pcwk.ehr.resultUrl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Result_UrlDaoImpl implements Result_UrlDao {
	
	final String NAMESPACE = "com.pcwk.ehr";
	final String DOT = ".";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;//DB연결객체

	private final Logger LOG = LogManager.getLogger(getClass());
	
	
	//**** default 생성
	public Result_UrlDaoImpl() {}

	public List<Result_UrlVO> resultSelect(Result_UrlVO search) throws SQLException{
		List<Result_UrlVO> list = new ArrayList<Result_UrlVO>();



		String statement = NAMESPACE+DOT+"resultSelect";
		LOG.debug("1. statement"+statement);
		LOG.debug("2. search"+search);

		list = sqlSessionTemplate.selectList(statement, search);
		for (Result_UrlVO vo : list) {
			LOG.debug("3. vo="+vo);
		}

		return list;
	}


	
}
