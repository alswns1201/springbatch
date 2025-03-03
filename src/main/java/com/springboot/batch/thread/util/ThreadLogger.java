package com.springboot.batch.thread.util;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// 추상클래스로 직접 생성하지 못하게 한다.
public abstract class ThreadLogger {

    private static final DateTimeFormatter fommatter =
            DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
    public static void log(Object obj){
            String time = LocalDateTime.now().format(fommatter);

            System.out.printf("%s [%9s] %s\n",time,Thread.currentThread().getName(),obj);
    }
}
