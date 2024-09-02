package com.springboot.batch.config;


import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.support.DefaultBatchConfiguration;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;


@RequiredArgsConstructor // 자동으로 의존성 주입
@Configuration // 안에 bean을 직접 생성
public class JobConfiguration extends DefaultBatchConfiguration{

//    private final JobBuilderFactory jobBuilderFactory;  spring 3 이상 부터 없어져서 JobBuilder 를 사용해야함
//    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job helloJob(JobRepository repository,PlatformTransactionManager transactionManager){
        JobBuilder jobBuilder = new JobBuilder("hellojob",repository);
        return jobBuilder.start(helloStep1(repository,transactionManager))    //job 다음은 step이 진행되야함.
                .next(helloStep2(repository,transactionManager))
                .build();
    }


    @Bean
    public Step helloStep1(JobRepository repository, PlatformTransactionManager transactionManager){
        return
//                stepBuilderFactory.get("helloStep1")
                new StepBuilder("helloStep1",repository)
                        .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

                        System.out.println("----spring batch hellostep1");

                        return RepeatStatus.FINISHED;
                        // Repeat에서 계속 반복할것인지 (null : FINISHED와 동일 은 1번 실행시키고 종료 )

                    }
                },transactionManager).build();
    }

    @Bean
    public  Step helloStep2(JobRepository repository,PlatformTransactionManager transactionManager) {
        return
                // stepBuilderFactory.get("helloStep1")
                new StepBuilder("helloStep1", repository)
                        .tasklet(new Tasklet() {
                            @Override
                            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

                                System.out.println("----spring batch hellostep1");

                                return RepeatStatus.FINISHED;
                                // Repeat에서 계속 반복할것인지 (null : FINISHED와 동일 은 1번 실행시키고 종료 )

                            }
                        }, transactionManager).build();
            }
    }
