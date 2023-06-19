package com.pcwk.ehr.share;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class shareDaoImpl implements shareDao {
	
	final String NAMESPACE = "com.pcwk.ehr";
	final String DOT = ".";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;//DB연결객체

	private final Logger LOG = LogManager.getLogger(getClass());
	
	
	//**** default 생성
	public shareDaoImpl() {}

	public List<shareVO> urlSelect(shareVO search) throws SQLException{
		List<shareVO> list = new ArrayList<shareVO>();



		String statement = NAMESPACE+DOT+"urlSelect";
		LOG.debug("1. statement"+statement);
		LOG.debug("2. search"+search);

		list = sqlSessionTemplate.selectList(statement, search);
		for (shareVO vo : list) {
			LOG.debug("3. vo="+vo);
		}

		return list;
	}


	
}
