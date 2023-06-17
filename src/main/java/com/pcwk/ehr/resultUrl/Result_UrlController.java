package com.pcwk.ehr.resultUrl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Result_UrlController {
	
	@Autowired
	Result_UrlService resultUrlService;

	@RequestMapping(value = "/ELCARO/resultSelect.do")
	public String resultSelect(Result_UrlVO search, Model model) throws SQLException{

		System.out.println("Client request received: " + search.toString());

		List<Result_UrlVO> list = resultUrlService.resultSelect(search);
		model.addAttribute("list", list);

		return "user/Ne_10ResultUrl"; 
	}


	
	
}
