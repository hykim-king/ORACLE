package com.pcwk.ehr.nmemeber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotMemberServiceImpl implements NotMemberService {
    
    private final NotMemberDAO notMemberDAO;

    @Autowired
    public NotMemberServiceImpl(NotMemberDAO notMemberDAO) {
        this.notMemberDAO = notMemberDAO;
    }

    @Override
    public void saveUserInfo(String mbti, String nickname, String gender, String ani) {
        NotMemberVO notMemberVO = new NotMemberVO(mbti, nickname, gender, ani);
        notMemberDAO.saveUserInfo(notMemberVO);
    }
}





