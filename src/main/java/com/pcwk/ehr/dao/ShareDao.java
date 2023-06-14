package com.pcwk.ehr.dao;

import com.pcwk.ehr.user.domain.ShareVO;
import org.springframework.stereotype.Repository;

@Repository
public interface ShareDao {

	String fetchDesiredURL(String userID);


	void insertShare(ShareVO shareVO);

	ShareVO getShare(int i);

	void updateShare(ShareVO shareVO);

	void deleteShare(int i);
}