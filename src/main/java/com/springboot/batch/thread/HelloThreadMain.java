package com.springboot.batch.thread;

import com.springboot.batch.thread.util.ThreadLogger;

public class HelloThreadMain {

    public static void main(String[] args){

        System.out.println(Thread.currentThread().getName()+" start");

        HelloThread helloThread = new HelloThread();
        // 둘의 차이는 ? run 은 main 쓰레드가 직접 실행함.
        helloThread.start();
        ThreadLogger.log(helloThread);
//        helloThread.run();

        // runnable을 이용해서 사용 해야 한다.
        // (다중 상속이 안되닌까 implements runnable을 사용해야한다.)
        ThreadRunnable runnable = new ThreadRunnable();
        Thread thread = new Thread(runnable);


        System.out.println(Thread.currentThread().getName()+" start 호출 후 ");

        System.out.println(Thread.currentThread().getName()+"main end");


    }
}
