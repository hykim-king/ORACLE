package com.pcwk.ehr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.pcwk.ehr.domain.SignUpVO;

@Repository
public class ResultImpl implements ResultDao {

	final String NAMESPACE = "com.pcwk.ehr.user";
	final String DOT       = ".";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate; //DB연결 객체
	
	private final Logger LOG = LogManager.getLogger(ResultImpl.class);

		
	// *** default 생성
	public ResultImpl() {}

	@Override
	public String fetchDesiredURL(String userID) {
		String desiredURL = "";
		String statement = NAMESPACE + DOT + "fetchDesiredURL";
		LOG.debug("┌───────────────┐");
		LOG.debug("│statement" + statement);
		LOG.debug("└───────────────┘");

		desiredURL = sqlSessionTemplate.selectOne(statement, userID);

		LOG.debug("┌───────────────┐");
		LOG.debug("│desiredURL" + desiredURL);
		LOG.debug("└───────────────┘");

		return desiredURL;
	}
	public List<SignUpVO> doRetrieve(SignUpVO search)throws SQLException{
		List<SignUpVO> list = new ArrayList<SignUpVO>();
		
		String statement = NAMESPACE+DOT+"doRetrieve";
		LOG.debug("┌─────────┐");
		LOG.debug("│statement│"+statement);
		LOG.debug("└─────────┘");
		LOG.debug("2. param " + search);
		
		list = sqlSessionTemplate.selectList(statement, search);
		
		for(SignUpVO vo : list) {
			LOG.debug("3.vo" + vo);
		}
		
		return list;
	}
	
	@Override
	public int update(SignUpVO user) throws SQLException {
		int flag = 0;
		
		String statement = this.NAMESPACE+DOT+"update";
		LOG.debug("┌─────────┐");
		LOG.debug("│statement│"+statement);
		LOG.debug("└─────────┘");
		LOG.debug("2. param = \n" + user.toString());
		
		flag = this.sqlSessionTemplate.update(statement, user);
		
		LOG.debug("3. flag = " + flag);
		
		return flag;
	}

	// 건수 조회 : OK
	@Override
	@SuppressWarnings("deprecation")
	public int getCount(SignUpVO user) throws SQLException {
		int cnt = 0;
		
		String statement = this.NAMESPACE+DOT+"getCount";
		LOG.debug("┌─────────┐");
		LOG.debug("│statement│"+statement);
		LOG.debug("└─────────┘");
		LOG.debug("1. param=" + user);
		
		cnt = this.sqlSessionTemplate.selectOne(statement, user);
		
		LOG.debug("3. cnt=" + cnt);
		
		//---------------------------------------------
		
		return cnt;
	}


	// 삭제 : OK
	@Override
	public int deleteOne(final SignUpVO user) throws SQLException {
		int flag = 0;
		// ----------------------------------
		
		String statement = this.NAMESPACE+DOT+"deleteOne";
		LOG.debug("┌─────────┐");
		LOG.debug("│statement│"+statement);
		LOG.debug("└─────────┘");
		LOG.debug("2. param = \n" + user.toString());
		flag = this.sqlSessionTemplate.delete(statement, user);
		LOG.debug("3. flag = " + flag);

		//----------------------------------------------------------

		return flag;
	}
	
	//OK
	@Override
	public List<SignUpVO> getAll(SignUpVO user)throws SQLException{
		List<SignUpVO> outList = new ArrayList();

		String statement = this.NAMESPACE+DOT+"getAll";
		LOG.debug("┌─────────┐");
		LOG.debug("│statement│"+statement);
		LOG.debug("└─────────┘");
		LOG.debug("2. param=" + user);
		
		outList = sqlSessionTemplate.selectList(statement, user);
		
		return outList;
	}

	@Override
	@SuppressWarnings("deprecation")
	public SignUpVO get(SignUpVO user) throws SQLException {
		SignUpVO outVO = null;
		
		String statement = this.NAMESPACE+DOT+"get";
		LOG.debug("┌─────────┐");
		LOG.debug("│statement│"+statement);
		LOG.debug("└─────────┘");
		LOG.debug("2. param = \n" + user.toString());
		
		outVO = this.sqlSessionTemplate.selectOne(statement, user);
		LOG.debug("3. outVO = " + outVO);
		
		return outVO;
	}

	// 데이터 추가
	@Override
	public int add(final SignUpVO user) throws ClassNotFoundException, SQLException {
		int flag = 0;// 등록 건수
		// 무명 이너 클래스(Anonymous Inner Class)
		// ---------------------------------------------
		String statement = this.NAMESPACE+DOT+"add";
		LOG.debug("┌─────────┐");
		LOG.debug("│statement│"+statement);
		LOG.debug("└─────────┘");
		LOG.debug("2. param = \n" + user.toString());
		flag = this.sqlSessionTemplate.insert(statement, user);
		LOG.debug("3. flag = " + flag);
		
		return flag;

	}

}
