package com.springboot.batch.thread;

public class DaemonThreadMain {

    public static void main(String[] args){
        System.out.println(Thread.currentThread().getName()+" start");
        Demon demon = new Demon();
        demon.setDaemon(true);
        demon.start();
        // demon을 기다리지 않고 꺼짐.
        System.out.println(Thread.currentThread().getName()+" end");
    }
    static class Demon extends Thread{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+" run");

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+" end");

        }
    }
}
