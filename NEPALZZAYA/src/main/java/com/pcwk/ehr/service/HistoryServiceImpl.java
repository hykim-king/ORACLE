package com.pcwk.ehr.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.pcwk.ehr.dao.SignUpDao;
import com.pcwk.ehr.domain.SignUpVO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class HistoryServiceImpl implements SignUpService {
	final Logger LOG = LogManager.getLogger(getClass());
	
	private MailSender mailSender; //mail
	
	private PlatformTransactionManager transactionManager;
	

	private DataSource dataSource;

	// import 통한 50, 30에 대한 상수 도입
	// BASIC에서 SILVER로 가기 위한 최소 로그인 수
	public static final int MIN_LOGIN_COUNT_FOR_SILVER = 50;

	// SILVER에서 GOLD로 가기 위한 최소 추천 수
	public static final int MIN_RECOMMAND_COUNT_FOR_GOLD = 30;

	@Autowired
	SignUpDao userDao;

	public HistoryServiceImpl() {
		
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

	public void setUserDao(SignUpDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * Level별 등업 대상 여부 판단
	 * 
	 * @param user
	 * @return true/false
	 */

		
//		MimeMessage mail = mailSender.createMimeMessage();
//		MimeMessageHelper mailHelper = new MimeMessageHelper(mail, "UTF-8");
//		
//		//mail인증 주소
//		try {
//			mailHelper.setFrom("turquois1218@naver.com");
//			
//			mailHelper.setTo(user.getEmail()); //받는 사람
//			
//			mailHelper.setSubject("등업 안내"); //제목
//			
//			mailHelper.setText("사용자 등급이 "+user.getLevel().name()+"로 승급 되었습니다.");
//			
//			mailSender.send(mail);
//		} catch (MessagingException e) {
//			LOG.debug("┌─────────────────────┐");
//			LOG.debug("│MessagingException : │"+e.getMessage());
//			LOG.debug("└─────────────────────┘");
//			e.printStackTrace();
//		}
		


	@Override
	public List<SignUpVO> doRetrieve(SignUpVO search) throws SQLException {
		
		return userDao.doRetrieve(search);
	}

	@Override
	public void upgradeLevels(SignUpVO inVO) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(SignUpVO inVO) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

}
