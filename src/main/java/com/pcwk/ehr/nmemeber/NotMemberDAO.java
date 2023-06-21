package com.pcwk.ehr.nmemeber;

import java.sql.SQLException;

import com.pcwk.ehr.user.domain.UserVO;

public interface NotMemberDAO {
	
	//데이터 추가 O
		int add(NotMemberVO notMember) throws  SQLException;

		void saveUserInfo(NotMemberVO notMemberVO);
}
