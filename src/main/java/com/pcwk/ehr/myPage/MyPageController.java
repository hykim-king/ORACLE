package com.pcwk.ehr.myPage;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class MyPageController {

	final Logger LOG = LogManager.getLogger(getClass());

	@RequestMapping(value = "/ELCARO/myPage.do")
	public String selectNickname(HttpServletRequest request) throws SQLException {
		
		HttpSession session = request.getSession();
        
		//test를 위해 임시로 저장한 것(나중에 삭제)---------------------
		session.setAttribute("user", "mj");
		session.setAttribute("niName", "스파이더맨어크로스");
		//-----------------------------------------
		
        String userId = (String) session.getAttribute("user");
        String userNickname = (String) session.getAttribute("niName");

        
		LOG.debug("┌─────────────────────────────────┐");
	    LOG.debug("│ userId: "+userId);
	    LOG.debug("│ userNickname: "+userNickname);
		LOG.debug("└─────────────────────────────────┘");

		return "user/Ne09_MyPage";

	}

}
