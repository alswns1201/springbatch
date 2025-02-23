package com.springboot.batch.thread.Service;


import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ThreadService {


    public void ThreadRun() throws InterruptedException {

//         ExecutorService executorService = Executors.newFixedThreadPool(4);


        for(int i = 0; i<3;i++){
            Thread.sleep(500);

            CompletableFuture<HashMap<String, Object>> future = CompletableFuture.supplyAsync(() -> {
                try {
                    //실제 서비스 실행
                    Thread.sleep(1000000);
                    HashMap<String, Object> result = new HashMap<>();
                    return  result;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            });




        }


    }

}
