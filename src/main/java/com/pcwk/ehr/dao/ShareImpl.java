package com.pcwk.ehr.dao;

import com.pcwk.ehr.user.domain.ShareVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShareImpl implements ShareDao {

	final String NAMESPACE = "com.pcwk.ehr.user";
	final String DOT       = ".";


	@Autowired
	SqlSessionTemplate sqlSessionTemplate; //DB연결 객체

	private final Logger LOG = LogManager.getLogger(ShareImpl.class);


	// *** default 생성
	public ShareImpl() {}

	@Override
	public String fetchDesiredURL(String userID) {
		String desiredURL = "";
		String statement = NAMESPACE + DOT + "fetchDesiredURL";
		LOG.debug("┌───────────────┐");
		LOG.debug("│statement" + statement);
		LOG.debug("└───────────────┘");

		desiredURL = sqlSessionTemplate.selectOne(statement, userID);

		LOG.debug("┌───────────────┐");
		LOG.debug("│desiredURL" + desiredURL);
		LOG.debug("└───────────────┘");

		return desiredURL;
	}

	@Override
	public void insertShare(ShareVO shareVO) {

	}

	@Override
	public ShareVO getShare(int i) {
		return null;
	}

	@Override
	public void updateShare(ShareVO shareVO) {

	}

	@Override
	public void deleteShare(int i) {

	}

}
