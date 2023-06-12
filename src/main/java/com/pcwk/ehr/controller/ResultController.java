package com.pcwk.ehr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class ResultController {

    @GetMapping("/")
    public String home(Model model) {
        List<Integer> randomNumbers = generateRandomNumbers(5, 1, 60);
        model.addAttribute("randomNumbers", randomNumbers);
        return "user/result_mng.jsp";
    }

    private List<Integer> generateRandomNumbers(int count, int min, int max) {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        while (numbers.size() < count) {
            int randomNumber = random.nextInt(max - min + 1) + min;
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
}
