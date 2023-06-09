package com.pcwk.ehr.user.service;

import java.sql.SQLException;
import java.util.List;

import com.pcwk.ehr.user.domain.UserVO;

public interface UserService {
	
	/**
	 * 목록조회
	 * @param search
	 * @return
	 * @throws SQLException
	 */
	public List<UserVO> doRetrieve(UserVO search) throws SQLException;
	
	/**
	 * 등업
	 * @param inVO
	 * @throws SQLException
	 * @throws Exception 
	 */
	public void upgradeLevels(UserVO inVO)throws Exception;

	/*
	 * 신규회원 등록
	 * 
	 */
	public void add(UserVO inVO)throws  SQLException,ClassNotFoundException;
}
