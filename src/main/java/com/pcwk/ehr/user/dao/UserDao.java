package com.pcwk.ehr.user.dao;

import java.sql.SQLException;
import java.util.List;

import com.pcwk.ehr.user.domain.UserVO;

public interface UserDao {
	
	public List<UserVO> doRetrieve(UserVO search) throws SQLException;

	int update(UserVO user) throws SQLException;

	//건수 조회:OK
	int getCount(UserVO user) throws SQLException;

	//삭제:OK
	int deleteOne(UserVO user) throws SQLException;

	//OK
	List<UserVO> getAll(UserVO user) throws SQLException;

	UserVO get(UserVO user) throws ClassNotFoundException, SQLException;

	//데이터 추가
	int add(UserVO user) throws ClassNotFoundException, SQLException;

}