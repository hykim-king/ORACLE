package com.pcwk.ehr.share;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class shareController {
	
	@Autowired
	shareService shareService;

	@RequestMapping(value = "/ELCARO/urlSelect.do")
	public String urlSelect(shareVO search, Model model) throws SQLException{

		System.out.println("Client request received: " + search.toString());

		List<shareVO> list = shareService.urlSelect(search);
		model.addAttribute("list", list);

		return "user/Ne11_SharePage";
	}


	
	
}
