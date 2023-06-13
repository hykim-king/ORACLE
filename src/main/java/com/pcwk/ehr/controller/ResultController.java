package com.pcwk.ehr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class ResultController {

    @GetMapping("/desiredURL")
    public String fetchDesiredURL(@RequestParam("ID") String ID) {
        // 여기에서 userID를 활용하여 ID가 일치하는 URL을 가져온 후 반환합니다.
        // 예시로 "https://example.com"을 반환하도록 설정합니다.
        String desiredURL = resultDao.fetchDesiredURL(ID);
        return desiredURL;
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
