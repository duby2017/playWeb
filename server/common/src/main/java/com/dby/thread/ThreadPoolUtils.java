package com.dby.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2018/1/5.
 */
public class ThreadPoolUtils {

    //使用volatile关键字保其可见性
    volatile private static ExecutorService instance = null;

    private ThreadPoolUtils() {
    }

    public static ExecutorService getInstance() {

        if (instance != null) {//懒汉式
            return instance;
        }

        synchronized (ThreadPoolUtils.class) {
            if (instance == null) {//二次检查
                instance = Executors.newCachedThreadPool();
            }
        }

        return instance;
    }
}
