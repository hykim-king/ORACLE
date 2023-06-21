package com.pcwk.ehr.nmemeber;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pcwk.ehr.user.dao.UserDao;
import com.pcwk.ehr.user.domain.UserVO;

@Repository
public abstract class NotMemberDAOImpl implements UserDao {

	final String NAMESPACE = "com.pcwk.ehr.user";
	final String DOT       = ".";
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;//DB 연결객체
	
	private final Logger LOG = LogManager.getLogger(getClass());	
	
	//**** default 생성
	public NotMemberDAOImpl() {}
	 
	@Override
	public int update(UserVO user)throws SQLException{
		int flag = 0;
		String statement = this.NAMESPACE+DOT+"update";
		LOG.debug("1. statement-"+statement);
		LOG.debug("2. param="+user);
		
		flag = this.sqlSessionTemplate.update(statement, user);

		LOG.debug("3. flag="+flag);
		
		return flag;
	}

	//데이터 추가
	@Override
	public int add(final UserVO user)throws SQLException{
		int flag = 0;//등록 건수

		String statement  = this.NAMESPACE+DOT+"add";
		LOG.debug("----------------------------");
		LOG.debug("1. statement-"+statement);
		LOG.debug("----------------------------");
		LOG.debug("2. param=\n"+user.toString());
		flag = this.sqlSessionTemplate.insert(statement, user);
		LOG.debug("3. flag="+flag);		
			
		return flag;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}