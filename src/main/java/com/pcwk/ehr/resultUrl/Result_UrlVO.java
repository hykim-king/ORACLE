package com.pcwk.ehr.resultUrl;

public class Result_UrlVO {
//	private String Id;// 회원id
//	private String nickName;// 이름
//	private String passwd;// 비번
//	private int mbti;

	private  String Id;
	private  String result_date;

	private String url;

	private String mbti_type;


	public Result_UrlVO() {
	}
	private String nickname;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	@Override
	public String toString() {
		return "Result_UrlVO{" +
				"result_date='" + result_date + '\'' +
				", url='" + url + '\'' +
				", mbti_type='" + mbti_type + '\'' +
				", nickname='" + nickname + '\'' +
				'}';
	}

	public String getResult_date() {
		return result_date;
	}

	public void setResult_date(String result_date) {
		this.result_date = result_date;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMbti_type() {
		return mbti_type;
	}

	public void setMbti_type(String mbti_type) {
		this.mbti_type = mbti_type;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}



}
