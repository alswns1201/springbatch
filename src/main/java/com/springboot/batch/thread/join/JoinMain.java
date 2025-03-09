package com.springboot.batch.thread.join;

import com.springboot.batch.thread.util.ThreadLogger;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class JoinMain {


    public static void main(String[] args) throws InterruptedException {

        ThreadLogger.log("start");
        Thread thread1 = new Thread(new Job(1,50),"THREAD-1");
        Thread thread2 = new Thread(new Job(51,100),"THREAD-2");


        thread1.start();
        thread2.start();

        ThreadLogger.log("join - main thread 들이 종료까지 기다림");
        thread1.join();
        thread2.join();

        ThreadLogger.log("end");

    }

    static class Job implements Runnable{
         int startValue;
         int endValue;
         int result = 0;

         public Job(int s,int e){
             this.startValue= s;
             this.endValue = e;
         }

        @Override
        public void run() {
            try {
                ThreadLogger.log("working start");
                Thread.sleep(2000);
                int sum = 0;
                for(int i = startValue; i<=endValue;i++){
                    sum+=i;
                }
                result = sum;

                ThreadLogger.log("working end "+result);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
