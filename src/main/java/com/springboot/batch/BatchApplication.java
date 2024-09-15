package com.springboot.batch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
// BatchAuto , SimpleBatch , BatchConfigurer
// [1]BathchAuto : Job을 수행 내부 JobLauhcerApplicationRunner를 가지고 있음(빈생성)
// [2]SimpleBatch : JobBuilderFactory , StepBuliderFactory 생성 , 주요구성요소/프록시 생성
// [2]BatchConfigure : Basic : 프록시의 실제 객체 적용  /  JpaBatch  : Jpa 관련 설정.
 */
@SpringBootApplication
@EnableBatchProcessing // batch 활성화.
public class BatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchApplication.class, args);
	}

}
