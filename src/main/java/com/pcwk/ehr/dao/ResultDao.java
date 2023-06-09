package com.pcwk.ehr.dao;

import java.sql.SQLException;
import java.util.List;

import com.pcwk.ehr.domain.SignUpVO;

public interface ResultDao {

	public List<SignUpVO> doRetrieve(SignUpVO search)throws SQLException;

	int update(SignUpVO user) throws SQLException;

	// 건수 조회 : OK
	int getCount(SignUpVO user) throws SQLException;

	// 삭제 : OK
	int deleteOne(SignUpVO user) throws SQLException;

	//OK
	List<SignUpVO> getAll(SignUpVO user) throws SQLException;

	SignUpVO get(SignUpVO user) throws ClassNotFoundException, SQLException;

	// 데이터 추가
	int add(SignUpVO user) throws ClassNotFoundException, SQLException;

}