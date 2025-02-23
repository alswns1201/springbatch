package com.springboot.batch.thread.Controller;


import com.springboot.batch.thread.Service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController

public class ThreadController {

    @Autowired
    private ThreadService threadService;

    @GetMapping("/api")
    public String RunTest() throws InterruptedException {

        threadService.ThreadRun();

        return "Running Version 1.1 test";
    }


}
