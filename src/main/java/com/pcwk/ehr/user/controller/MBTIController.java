package com.pcwk.ehr.user.controller;

import com.pcwk.ehr.user.service.MBTIService;
import com.pcwk.ehr.user.domain.MBTIVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.util.List;

@Controller
public class MBTIController {

    @Autowired
    MBTIService mbtiService;

    @RequestMapping(value = "/mbti")
    public String getMbti(Model model) throws SQLException {
        List<MBTIVO> data = mbtiService.getMBTI();
        model.addAttribute("list", data);
        System.out.println(data);
        return "mbti/mbti";
    }
}
