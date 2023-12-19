package com.company.frontalsystem;

import com.company.application.Application;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class FrontalSystem {

    /*
    * Используем блоктрующую очередь, так как нам необходимо приостанавливать выполнение потока,
    *  при пустой или переполненной очереди
    */
    private final BlockingQueue<Application> applicationQueue = new ArrayBlockingQueue<>(2);

    public void addApplication(Application application) throws InterruptedException {
         applicationQueue.put(application);
    }

    public Application getApplication() throws InterruptedException {
        Application application = applicationQueue.take();
        return application;
    }

}
