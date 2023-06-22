package com.pcwk.ehr.NotMember;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NotMemberController {

	@Autowired
	NotMemberService notMemberService;
	
	@RequestMapping(value = "/User/notMemberInsert.do")
	public String notMemberInsert(NotMemberVO notMember, Model model) throws SQLException{
		
		notMemberService.insert(notMember);
		
		return "user/Ne03_NotMember";
	}

}
