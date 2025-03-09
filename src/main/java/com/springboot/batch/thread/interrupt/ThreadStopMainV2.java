package com.springboot.batch.thread.interrupt;

import com.springboot.batch.thread.util.ThreadLogger;
import com.springboot.batch.thread.util.ThreadUtils;

public class ThreadStopMainV2 {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();

        ThreadUtils.sleep(4000);
        ThreadLogger.log("작업 중단 지시 thread.interrupt()");
        thread.interrupt();
        ThreadLogger.log("work 스레드 인터럽트 상태1 = " + thread.isInterrupted());
    }

    static class MyTask implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    ThreadLogger.log("작업 중");
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                ThreadLogger.log("work 스레드 인터럽트 상태2 = " + Thread.currentThread().isInterrupted());
                ThreadLogger.log("interrupt message=" + e.getMessage());
                ThreadLogger.log("state=" + Thread.currentThread().getState());
            }
            ThreadLogger.log("자원 정리");
            ThreadLogger.log("자원 종료");
        }
    }
}
