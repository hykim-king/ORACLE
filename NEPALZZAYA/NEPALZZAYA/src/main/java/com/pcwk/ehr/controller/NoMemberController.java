package com.pcwk.ehr.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pcwk.ehr.domain.SignUpVO;
import com.pcwk.ehr.service.SignUpService;

@Controller
public class NoMemberController {

	@Autowired
	SignUpService userService;
	
	@RequestMapping(value = "/user/doRetrieve.do")
	public String doRetrieve(SignUpVO search, Model model) throws SQLException {
		
//		if(search.getPageNo() == 0) { //페이지 번호 초기값 1
//			search.setPageNo(1);
//		}
//		
//		if(search.getPageSize() == 0) { //페이지 사이즈 초기값 10
//			search.setPageSize(10);
//		}
//		
//		if(search.getSearchDiv() == null) {
//			search.setSearchDiv("");
//		}
		
		List<SignUpVO>list = userService.doRetrieve(search);
		model.addAttribute("list", list);
		
		return "user/user_mng";
	}
}
