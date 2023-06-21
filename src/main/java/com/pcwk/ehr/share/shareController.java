package com.pcwk.ehr.share;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sun.util.locale.provider.LocaleServiceProviderPool.LocalizedObjectGetter;


@Controller
public class shareController {
	
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	shareService shareService;

	@RequestMapping(value = "/ELCARO/urlSelect.do")
	public String urlSelect(shareVO search, Model model) throws SQLException{

		System.out.println("Client request received: " + search.toString());

		List<shareVO> list = shareService.urlSelect(search);
		model.addAttribute("list", list);
		
		LOG.debug("           list : "+list);

		return "user/Ne11_SharePage";
	}


	
	
}
