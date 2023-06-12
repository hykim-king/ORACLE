package com.pcwk.ehr.domain;

public class ResultVO {
	private String userId;// 회원id
	private String name;// 이름
	private String passwd;// 비번

	private int login;// 로그인
	private int recommend;// 추천수
	private String email;// 이메일
	private String reg_dt;// 등록일

	public ResultVO() {
	}

	public ResultVO(String userId, String name, String passwd, int login, int recommend, String email,
			String reg_dt) {
		super();
		this.userId = userId;
		this.name = name;
		this.passwd = passwd;
		this.login = login;
		this.recommend = recommend;
		this.email = email;
		this.reg_dt = reg_dt;

	}



	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	public int getLogin() {
		return login;
	}

	public void setLogin(int login) {
		this.login = login;
	}

	public int getRecommend() {
		return recommend;
	}

	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getReg_dt() {
		return reg_dt;
	}

	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}

	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", name=" + name + ", passwd=" + passwd + ", login="
				+ login + ", recommend=" + recommend + ", email=" + email + ", reg_dt=" + reg_dt + "]";
	}


}
