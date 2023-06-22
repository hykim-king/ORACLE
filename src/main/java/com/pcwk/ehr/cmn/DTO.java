package com.pcwk.ehr.cmn;

public class DTO {

	private String id; // 검색어
	private String nickName; // 검색구분

	public DTO() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "DTO [id=" + id + ", nickName=" + nickName + "]";
	}

	
}
