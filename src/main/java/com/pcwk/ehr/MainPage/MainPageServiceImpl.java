package com.pcwk.ehr.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainPageServiceImpl implements MainPageService {
   
	@Autowired
    private MainPageDAO mainPageDAO;

	@Override
	public void page(MainPageVO mainPage) {
		
	}
}
