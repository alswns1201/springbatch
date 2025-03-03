package com.springboot.batch.thread.Controller;


import com.springboot.batch.thread.Service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController

public class ThreadController {

    @Autowired
    private ThreadService threadService;

    @GetMapping("/api")
    public String RunTest() throws InterruptedException {

        String ID = String.valueOf(UUID.randomUUID());

        HashMap<String, Object> parameterMap = new HashMap<String, Object>();
        parameterMap.put("organization", "0002");
        parameterMap.put("loginType", "5"); // "0":(공동/금융)인증서 "5":간편인증
        parameterMap.put("loginTypeLevel", "1");  // 1:카카오톡, 2:페이코, 3:삼성패스, 4:KB모바일, 5:통신사(PASS), 6:네이버, 7:신한인증서, 8: toss
        parameterMap.put("userName", "김민준");
        parameterMap.put("phoneNo", "01040651205");
        parameterMap.put("identity", "19941201");
        parameterMap.put("inquiryType", "0");

        parameterMap.put("id", ID); //식별아이디

        parameterMap.put("searchStartYear", "2020");
        parameterMap.put("searchEndYear", "2025");
        parameterMap.put("type", "1");


        threadService.ThreadRun(parameterMap);

        return "Running Version 1.1 test";
    }


}
