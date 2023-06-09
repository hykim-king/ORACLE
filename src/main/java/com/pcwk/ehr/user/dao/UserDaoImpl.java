package com.pcwk.ehr.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.pcwk.ehr.user.domain.Level;
import com.pcwk.ehr.user.domain.UserVO;

@Repository
public class UserDaoImpl implements UserDao {
	
	final String NAMESPACE = "com.pcwk.ehr.user";
	final String DOT = ".";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;//DB연결객체

	private final Logger LOG = LogManager.getLogger(getClass());
	
	
	//**** default 생성
	public UserDaoImpl() {}
	
	public List<UserVO> doRetrieve(UserVO search) throws SQLException{
		List<UserVO> list = new ArrayList<UserVO>();
		
		String statement = NAMESPACE+DOT+"doRetrieve";
		LOG.debug("1. statement"+statement);
		LOG.debug("2. search"+search);
		
		list = sqlSessionTemplate.selectList(statement, search);
		for (UserVO vo : list) {
			LOG.debug("3. vo="+vo);
		}
		
		return list;
	}
	

	@Override
	public int update(UserVO user)throws SQLException{
		int flag = 0;

		String statement = this.NAMESPACE+DOT+"update";
		LOG.debug("1. statement"+statement);
		LOG.debug("2. param=\n"+user.toString());
		
		flag = this.sqlSessionTemplate.update(statement, user);
		
		return flag;
	}
	
	//건수 조회:OK
	@Override
	@SuppressWarnings("deprecation")
	public int getCount(UserVO user)throws SQLException{
		int cnt = 0;
		
		String statement = this.NAMESPACE+DOT+"getCount";
		
		//-------------------------------------------		
		
		LOG.debug("1. statement "+statement);
		LOG.debug("2. param="+user);
		cnt = this.sqlSessionTemplate.selectOne(statement,user);
		LOG.debug("3. cnt="+cnt);
		//-------------------------------------------
		
		return cnt;
	}
	
	
  


	//삭제:OK
	@Override
	public int deleteOne(final UserVO user)throws SQLException{
		int flag = 0;
		//---------------------------------------
		
		String statement = this.NAMESPACE+DOT+"deleteOne";
		
		LOG.debug("--------------------------");
		LOG.debug("1. statement-"+statement);
		LOG.debug("--------------------------");
		LOG.debug("2. param=\n"+user.toString());
		flag = this.sqlSessionTemplate.insert(statement,user);
		LOG.debug("3. flag="+flag);
		

		
		return flag;
	}
	
	//OK
	@Override
	public List<UserVO> getAll(UserVO user)throws SQLException{
		List<UserVO> outList = new ArrayList<>();
		
		String statement = this.NAMESPACE+DOT+"getAll";
		

		LOG.debug("1. statement"+statement);
		LOG.debug("2. param="+user);
		
		outList = sqlSessionTemplate.selectList(statement, user);
		
		
		return outList;
	}

	@Override
	@SuppressWarnings("deprecation")
	public UserVO get(UserVO user )throws SQLException{
		UserVO outVO = null;

		
		String statement = NAMESPACE+DOT+"get";
		
		LOG.debug("--------------------------");
		LOG.debug("1. statement-"+statement);
		LOG.debug("--------------------------");
		LOG.debug("2. param=\n"+user.toString());
		
		outVO = this.sqlSessionTemplate.selectOne(statement,user);
		LOG.debug("3. flag="+outVO);

		
	
		return outVO;
	}

	//데이터 추가
	@Override
	public int add(final UserVO user)throws ClassNotFoundException,SQLException{
		int flag = 0;//등록 건수
		//무명 이너 클래스(Anonymous Inner Class)
		//--------------------------------------------------------------

		
		String statement = this.NAMESPACE+DOT+"add";
	
		LOG.debug("1. statement" +statement);
		LOG.debug("2. param=\n" + user.toString());
		flag = this.sqlSessionTemplate.insert(statement,user);
		LOG.debug("3. flag="+flag);	

			
		
		//--------------------------------------------------------------		
		return flag;
		
	}
	
}
