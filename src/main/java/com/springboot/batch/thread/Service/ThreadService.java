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
                "7b96ef9f-dc67-4a09-9ac3-d8d11318d236",
                "a300f039-b4ab-495d-93fe-89d2ca108177"
        );
        codef.setPublicKey("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA6Sf7VZr+GB73JDBpkD0xhssPi7ancAxOGWljyjYCMMfmRM7OjwkhHoJyAJDOnru/3xrWbzT6qjZxHQ+TAg8cdSTKudWRmo2EoPyB9HHmO6SVfY/bUu6Ti1oRq8ZA//ErxhgZSyvlYBnk+QULbiRPw4bw8bZDhsU7zfZn52b5ZEvHSxAHJjuUzKSbtULiMUVj+t/vPI6CujS5GmmZRxTF32GT4rucuWxCGyR8/BChgRd+y0B9JRA5o92oJYkNR0gqNpCe0DtdWGe+bxzhzGwX75tnHHupFdzWQe/ydEr9I4lpPA9qIg1OLRGyqisEmF7c+HrtttsV3ZNXwW2Qxwu3LwIDAQAB");
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
