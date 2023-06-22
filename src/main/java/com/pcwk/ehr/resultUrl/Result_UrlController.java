package com.pcwk.ehr.resultUrl;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;


@Controller
public class Result_UrlController {
	
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	Result_UrlService resultUrlService;

	
	@RequestMapping(value = "/ELCARO/resultSelect.do")
	public String resultSelect(Result_UrlVO search, Model model, HttpSession session) throws SQLException{

		System.out.println("Client request received: " + search.toString());

		String userId = (String) session.getAttribute("user");
		search.setId(userId);
		
		List<Result_UrlVO> list = resultUrlService.resultSelect(search);
		model.addAttribute("list", list);

		return "user/Ne10_ResultUrl";
		
		
	}
	
	


	
	
}
