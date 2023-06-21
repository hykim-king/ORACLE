package com.pcwk.ehr.nmemeber;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface NotMemberMapper {
    void insertUserInfo(
    		@Param("mbti") String mbti,
    		@Param("nickname") String nickname,
            @Param("gender") String gender,
            @Param("ani") String zodiac
    );
}