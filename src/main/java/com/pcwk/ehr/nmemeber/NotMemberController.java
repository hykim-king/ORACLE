package com.pcwk.ehr.nmemeber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NotMemberController {

    private final NotMemberService notMemberService;

    @Autowired
    public NotMemberController(NotMemberService notMemberService) {
        this.notMemberService = notMemberService;
    }

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("notMemberVO", new NotMemberVO());
        return "input-form";
    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute("notMemberVO") NotMemberVO notMemberVO, Model model) {
        notMemberService.saveUserInfo(notMemberVO.getMbti(), notMemberVO.getNickname(), notMemberVO.getGender(), notMemberVO.getAni());

        model.addAttribute("notMemberVO", notMemberVO);

        return "result-page";
    }
}