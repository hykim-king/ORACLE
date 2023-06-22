package com.pcwk.ehr.login;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.pcwk.ehr.cmn.MessageVO;

@Controller("LoginContoller")
@RequestMapping("login")
public class LoginContoller {

	final Logger LOG = LogManager.getLogger(getClass());

	@Autowired
	LoginService loginService;

	public LoginContoller() {
		LOG.debug("┌──────────────────────────────┐");
		LOG.debug("│LoginContoller                │");
		LOG.debug("└──────────────────────────────┘");
	}

	@RequestMapping(value = "/loginView.do")
	public String loginView() {
		LOG.debug("┌──────────────────────────────┐");
		LOG.debug("│loginView                     │");
		LOG.debug("└──────────────────────────────┘");

		// prefix /WEB-IN    F/views/
		// suffix .jsp

		// -> /WEB-INF/views/login/login.jsp
		return "user/Ne07_Login";
	}

	@RequestMapping(value = "/doLogin.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doLogin(LoginVO user, HttpSession httpsession) throws SQLException, ClassNotFoundException {
		String jsonString = "";
		LOG.debug("┌──────────────────────────────┐");
		LOG.debug("│inVO                          │" + user);

		MessageVO message = new MessageVO();

		// 1 : id미입력
		// 2 : 비번 미입력
		// 10 : 아이디 오류
		// 20 : 비번 오류
		// 30 : 성공
		if (null == user.getUserId() || "".equals(user.getUserId())) {
			message.setMegId("1");
			message.setMsgContents("아이디를 입력 하세요");

			return new Gson().toJson(message);
		}

		if (null == user.getPasswd() || "".equals(user.getPasswd())) {
			message.setMegId("2");
			message.setMsgContents("비밀번호를 입력 하세요");
			return new Gson().toJson(message);
		}

		int status = loginService.doLogin(user);
		if (10 == status) {
			message.setMegId("10");
			message.setMsgContents("아이디를 확인 하세요");
		} else if (20 == status) {
			message.setMegId("20");
			message.setMsgContents("비밀번호를 확인 하세요");
		} else if (30 == status) {
			message.setMegId("30");
			message.setMsgContents(user.getUserId() + "로그인 되었습니다");

			// --------------------------------------------------
			// 사용자 정보 조회 : seesion처리
			// --------------------------------------------------
			LoginVO userinfo = loginService.get(user);
			LOG.debug("sesstion"+userinfo);
			if (null != userinfo) {
				httpsession.setAttribute("user", userinfo.getUserId());
				LOG.debug("-------------userinfo------------"+userinfo.getUserId());
			} else {
				message.setMegId("99");
				message.setMsgContents("알수 없는 오류");
			}
		}

		jsonString = new Gson().toJson(message);
		LOG.debug("│jsonSting                     │" + jsonString);
		LOG.debug("└──────────────────────────────┘");

		return jsonString;
	}

}
