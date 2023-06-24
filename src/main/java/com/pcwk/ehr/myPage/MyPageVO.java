package com.pcwk.ehr.myPage;

public class MyPageVO {
//	 String userId;// 회원id
//	 String userNickname;// 이름
//	 String passwd;// 비번
//	 int mbti;

	private  String userId;

	private  String userNickname;


	public MyPageVO() {
	}


	@java.lang.Override
	public java.lang.String toString() {
		return "MyPageVO{" +
				"userId='" + userId + '\'' +
				", userNickname='" + userNickname + '\'' +
				'}';
	}

	public String getId() {
		return userId;
	}

	public void setId(String id) {
		userId = id;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
}
