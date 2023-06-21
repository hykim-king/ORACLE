package com.pcwk.ehr.login;

public class LoginVO {
	private String userId;// 회원id
	private String passwd;// 비번

	public LoginVO() {
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@java.lang.Override
	public java.lang.String toString() {
		return "LogInVO{" +
				"userId='" + userId + '\'' +
				'}';
	}
}
