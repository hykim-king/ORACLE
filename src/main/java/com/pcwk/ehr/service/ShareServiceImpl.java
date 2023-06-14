package com.pcwk.ehr.service;

import com.pcwk.ehr.user.dao.ShareDao;
import com.pcwk.ehr.user.domain.ShareVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShareServiceImpl implements ShareService {
    private final ShareDao shareDao;

    @Autowired
    public ShareServiceImpl(ShareDao shareDao) {
        this.shareDao = shareDao;
    }

    @Override
    public String fetchDesiredURL(String userID) {
        return shareDao.fetchDesiredURL(userID);
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
