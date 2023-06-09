package com.pcwk.ehr.user.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pcwk.ehr.user.domain.UserVO;
import com.pcwk.ehr.user.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/user/doRetrieve.do")
	
	public String doRetrieve(UserVO search, Model model) throws SQLException{
		
		if (search.getPageNo()==0) {//페이지 번호 초기값
			search.setPageNo(1);
		}
		
		if (search.getPageSize()==0) {//페이지 사이즈 초기값 10
			search.setPageSize(20);
		}
		
		if (search.getSearchDiv()==null) {
			search.setSearchDiv("");
		}
		
		
		List<UserVO> list = userService.doRetrieve(search);
		model.addAttribute("list", list);
		
		return "user/user_mng";
	}
	
	
}
