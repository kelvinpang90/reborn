package com.reborn.test.multi_threading;

import java.util.concurrent.TimeUnit;

public class Profiler {
    private final static ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<>(){
        @Override
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };
    public static void begin(){
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }
    public static long end(){
        return System.currentTimeMillis()-TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws InterruptedException {
        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost:"+Profiler.end()+" mills");
    }
}
