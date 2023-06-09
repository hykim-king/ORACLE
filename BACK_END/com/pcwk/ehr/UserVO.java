package com.pcwk.ehr.user.domain;
import com.pcwk.ehr.cmn.DTO;
	public class UserVO extends DTO{
		private String id;
		private String password;
		private String nickname;
		private int ani;
		private int mbti;
		private char gender;
		private String reg_dt;// 등록일
	public UserVO() {
	}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getNickname() {
			return nickname;
		}

		public void setNickname(String nickname) {
			this.nickname = nickname;
		}

		public int getAni() {
			return ani;
		}

		public void setAni(int ani) {
			this.ani = ani;
		}

		public int getMbti() {
			return mbti;
		}

		public void setMbti(int mbti) {
			this.mbti = mbti;
		}

		public char getGender() {
			return gender;
		}

		public void setGender(char gender) {
			this.gender = gender;
		}

		@Override
		public String toString() {
			return "UserVO{" +
					"id='" + id + '\'' +
					", password='" + password + '\'' +
					", nickname='" + nickname + '\'' +
					", ani=" + ani +
					", mbti=" + mbti +
					", gender=" + gender +
					'}';
		}
	}