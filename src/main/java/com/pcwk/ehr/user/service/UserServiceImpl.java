package com.pcwk.ehr.user.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.pcwk.ehr.user.dao.UserDao;
import com.pcwk.ehr.user.domain.Level;
import com.pcwk.ehr.user.domain.UserVO;

@Service
public class UserServiceImpl implements UserService {
	final Logger LOG = LogManager.getLogger(getClass());
	
	private MailSender mailSender; //mail
	
	private PlatformTransactionManager transactionManager;
	
	private DataSource dataSource;

	// BASIC에서 SILVER로 가기 위해 최소 로그인 수
	public static final int MIN_LOGIN_COUNT_FOR_SILVER = 50;
	// SILVER에서 GOLDㄹ 가기 위해 최소 추천수
	public static final int MIN_RECONMMEND_COUNT_FOR_GOLD = 30;

	@Autowired
	UserDao userDao;

	public UserServiceImpl() {
	}
	
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}


	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}



	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	private boolean canUpgradeLevel(UserVO user) {
		Level curentLevel = user.getLevel();

		switch (curentLevel) {
		case BASIC: // 레벨 별로 등업 조건을 판단
			return (user.getLogin() >= 50);

		case SILVER:
			return (user.getRecommend() >= 30);
		case GOLD:
			return false;
		default:
			throw new IllegalArgumentException("unknown Level" + curentLevel);

		}
	}

	/**
	 * 다음 Level로 등업
	 * @param user
	 * @throws SQLException
	 */
	protected void upgradeLevel(UserVO user) throws Exception{
		if(user.getUserId().equals("apt66")) {
			throw new TestUserServiceException("TestUserService**.upgradeLevel"+user.getUserId());
		}
		// 개선여지
		user.upgradeLevel();// user다음 Level 로 Up
		userDao.update(user); // 등업
		
		//mail 전송
		sendUpgradeEmail(user);
	}
	private void sendUpgradeEmail(UserVO user) {
		LOG.debug("┌────────────────────┐");
		LOG.debug("│sendUpgradeEmail:	│");
		LOG.debug("└────────────────────┘");
		
		LOG.debug("mailSender:"+this.mailSender);
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("momey7777@naver.com");
		message.setTo(user.getEmail());
		message.setSubject("등급안내!");
		message.setText("사용자 등급이"+user.getLevel().name()+"로 업그레이드 되었습니다.");
		
		this.mailSender.send(message);
		
		
//		MimeMessage mail = mailSender.createMimeMessage();
//		MimeMessageHelper mailHelper = new MimeMessageHelper(mail, "utf-8");
//		
////		//JavaMailSenderImpl mail = new JavaMailSenderImpl();
////		
////		//mail 정보 설정
////		MimeMessage upMail= mail.createMimeMessage();
////		MimeMessageHelper mailHelper = new MimeMessageHelper(upMail, "UTF-8");
////		//mail 인증 주소
//		try {
//			mailHelper.setFrom("momey7777@naver.com");
//			mailHelper.setTo(user.getEmail());//받는 사람
//			mailHelper.setSubject("등업 안내");//제목
//			mailHelper.setText("사용자 등급이"+user.getLevel().name()+"로 업그레이드 되었습니다.");
//			
//			mailSender.send(mail);
//		} catch (MessagingException e) {
//			LOG.debug("┌────────────────────────┐");
//			LOG.debug("│MessagingException		│");
//			LOG.debug("└────────────────────────┘");
//			e.printStackTrace();
//		}
		
}

	@Override
	public void upgradeLevels(UserVO inVO) throws Exception {
		// 1. 전체 사용자 조회(내가 등록한 사용자)
		// 2. 등업대상 등업

		try {
			// 1.
			List<UserVO> allUser = userDao.getAll(inVO);
			for (UserVO vo : allUser) {

				if (canUpgradeLevel(vo) == true) {
					upgradeLevel(vo);
				}
			}

		} catch (Exception e) {
			LOG.debug("┌───────────────┐");
			LOG.debug("│rollback	   │" + e.getMessage());
			LOG.debug("└───────────────┘");
			throw e;
			}
		}

	@Override
	public void add(UserVO inVO) throws ClassNotFoundException, SQLException {
		if (null == inVO.getLevel()) {
			inVO.setLevel(Level.BASIC);
		}
		this.userDao.add(inVO);
	}

	@Override
	public List<UserVO> doRetrieve(UserVO search) throws SQLException {
		
		return userDao.doRetrieve(search);
	}
}
