package com.springboot.batch.test;


import lombok.extern.log4j.Log4j2;

@Log4j2
public class StartTestMain {

    public static void main(String[] args){
//        CounterThread thread = new CounterThread();
//        thread.start();

//        Thread thread = new Thread(new CounterRunnable());
//        thread.start();
        PrintWork a = new PrintWork("A",1000);
        PrintWork b = new PrintWork("B",500);

        Thread threadA =  new Thread(a,"ThreadA");
        Thread threadB = new Thread(b,"ThreadB");

        threadA.start();
        threadB.start();


    }

    /**
     *  thread 상속 받아 구현 예제
     */
    static class CounterThread extends Thread{

        @Override
        public void run() {
            for(int i =0 ; i <5;i++){
                log.info("time " +i);
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     *   runnable로 구현 .
     */
    static class CounterRunnable implements Runnable{
        @Override
        public void run() {
            for(int i =0 ; i <5;i++){
                log.info("time " +i);
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
        }
    }
    /**
     * A ,B 를 만들고 각각 1초, 0.5초로 만들자
     */
    static class PrintWork implements Runnable{
       private String name ;
       private int time;

        public PrintWork(String n, int t){
            this.name = n;
            this.time =t;
        }

        @Override
        public void run() {
            while (true){
                log.info(name);
                try {
                    Thread.sleep(time);
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
