package com.pcwk.ehr.nmemeber;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pcwk.ehr.resultUrl.Result_UrlVO;

@Controller
public class NotMemberController {

	@Autowired
	NotMemberService NotMemberService;

	@RequestMapping(value = "/ELCARO/NotMember.do")
	public String resultSelect(Result_UrlVO search, Model model) throws SQLException{
		
		return "user/Ne03_NotMember";
	}
}