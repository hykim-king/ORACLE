package com.pcwk.ehr.service;

import java.sql.SQLException;
import java.util.List;

import com.pcwk.ehr.domain.SignUpVO;

public interface NoMemberService {

	/**
	 * 목록 조회
	 * @param search
	 * @return
	 * @throws SQLException
	 */
	public List<SignUpVO> doRetrieve(SignUpVO search)throws SQLException;
	/**
	 * 등업
	 * @param inVO
	 * @throws SQLException
	 */
	public void upgradeLevels(SignUpVO inVO)throws Exception;
	
	/**
	 * 신규회원 등록 : Level.BASIC
	 * @param inVO
	 * @throws SQLException
	 */
	public void add(SignUpVO inVO)throws ClassNotFoundException, SQLException;
}
