package com.springboot.batch.thread.interrupt;

import com.springboot.batch.thread.util.ThreadLogger;
import com.springboot.batch.thread.util.ThreadUtils;


public class ThreadStopMainV4 {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();

        ThreadUtils.sleep(100); // 시간을 줄임
        ThreadLogger.log("작업 중단 지시 thread.interrupt()");
        thread.interrupt();
        ThreadLogger. log("work 스레드 인터럽트 상태1 = " + thread.isInterrupted());
    }

    static class MyTask implements Runnable {

        @Override
        public void run() {
            while (!Thread.interrupted()) { // 인터럽트 상태 변경O
                ThreadLogger.log("작업 중");
            }
            ThreadLogger.log("work 스레드 인터럽트 상태2 = " + Thread.currentThread().isInterrupted());

            try {
                ThreadLogger.log("자원 정리");
                Thread.sleep(1000);
                ThreadLogger.log("자원 종료");
            } catch (InterruptedException e) {
                ThreadLogger.log("자원 정리 실패 - 자원 정리 중 인터럽트 발생");
                ThreadLogger.log("work 스레드 인터럽트 상태3 = " + Thread.currentThread().isInterrupted());
            }
            ThreadLogger.log("작업 종료");
        }
    }
}
