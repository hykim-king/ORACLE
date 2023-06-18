package com.pcwk.ehr.share;

import java.sql.SQLException;
import java.util.List;

import javax.print.attribute.standard.SheetCollate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class shareServiceImpl implements shareService {
	final Logger LOG = LogManager.getLogger(getClass());


	@Autowired
	shareDao shareDao;


	@Override
	public List<shareVO> urlSelect(shareVO search) throws  SQLException{
		search.setId("mj");
		return shareDao.urlSelect(search);
	}
}
