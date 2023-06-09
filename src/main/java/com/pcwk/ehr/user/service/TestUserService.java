package com.pcwk.ehr.user.service;

import java.sql.SQLException;

import com.pcwk.ehr.user.domain.UserVO;

public class TestUserService extends UserServiceImpl {
	private String id;

	public TestUserService(String id) {
		super();
		this.id = id;
	} //user_id
	
	protected void upgradeLevel(UserVO user) throws Exception {
		if(user.getUserId().equals(id)) {
			throw new TestUserServiceException("TestUserServiceException.upgradeLevel:"+user.getUserId());
		}
		//UserServiceIml에 있는
		super.upgradeLevel(user);
	}
	
	
}
