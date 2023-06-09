package com.pcwk.ehr.cmn;

import org.omg.CORBA.PRIVATE_MEMBER;

public class DTO {
	
	private int num;		//글 번호
	private int totalCnt;	//총 글수
	
	private String searchWord;//검색어
	private String searchDiv;//검색구분
	
	private int pageNo; //페이즈 번호
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	private int pageSize;//페이지 사이즈
	
	public DTO () {}

	@Override
	public String toString() {
		return "DTO [num=" + num + ", totalCnt=" + totalCnt + ", searchWord=" + searchWord + ", searchDiv=" + searchDiv
				+ ", pageNo=" + pageNo + ", pageSize=" + pageSize + "]";
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public String getSearchDiv() {
		return searchDiv;
	}

	public void setSearchDiv(String searchDiv) {
		this.searchDiv = searchDiv;
	}
	
}
