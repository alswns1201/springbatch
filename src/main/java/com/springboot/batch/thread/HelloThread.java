package com.springboot.batch.thread;

public class HelloThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"run()");
    }
}
