package com.springboot.batch.thread.interrupt;

import com.springboot.batch.thread.util.ThreadLogger;
import com.springboot.batch.thread.util.ThreadUtils;

public class ThreadStopMainV1 {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();

        ThreadUtils.sleep(4000);
        ThreadLogger.log("작업 중단 지시 runFlag=false");
        task.runFlag = false;
    }

    static class MyTask implements Runnable {

        volatile boolean runFlag = true;

        @Override
        public void run() {
            while (runFlag) {
                ThreadLogger.log("작업 중");
                ThreadUtils.sleep(3000);
            }
            ThreadLogger.log("자원 정리");
            ThreadLogger.log("자원 종료");
        }
    }
}