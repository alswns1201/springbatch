package com.springboot.batch.thread.Service;


import com.fasterxml.jackson.core.JsonProcessingException;
import io.codef.api.EasyCodef;
import io.codef.api.EasyCodefServiceType;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ThreadService {
    private final EasyCodef codef;

    public ThreadService() {
        this.codef = new EasyCodef();
    }

    @PostConstruct
    public void init() {
        codef.setClientInfoForDemo(
                "**",
                "**"
        );
        codef.setPublicKey("**");
    }


    public void ThreadRun(HashMap<String,Object>  parameterMap) throws InterruptedException {

//         ExecutorService executorService = Executors.newFixedThreadPool(4);


        for(int i = 0; i<3;i++){
            Thread.sleep(500);

            CompletableFuture<HashMap<String, Object>> future = CompletableFuture.supplyAsync(() -> {
                try {
                    //실제 서비스 실행
                    codef.requestProduct("/v1/kr/public/pp/nhis-health-checkup/result",
                            EasyCodefServiceType.DEMO,
                            parameterMap);

                    HashMap<String, Object> result = new HashMap<>();
                    return  result;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }

            });
        }


    }

}
