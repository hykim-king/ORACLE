package com.pcwk.ehr.service;

import com.pcwk.ehr.user.domain.ShareVO;

public interface ShareService {
    String fetchDesiredURL(String userID);

    void insertShare(ShareVO shareVO);

    ShareVO getShare(int i);

    void updateShare(ShareVO shareVO);

    void deleteShare(int i);
}
