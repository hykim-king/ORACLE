package com.pcwk.ehr.myPage;

public class MyPageVO {
//	private String userId;// 회원id
//	private String userNickname;// 이름
//	private String passwd;// 비번
//	private int mbti;

	private  String userId;
	
	private  String userNickname;


	public MyPageVO() {
	}


	@Override
	public String toString() {
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
