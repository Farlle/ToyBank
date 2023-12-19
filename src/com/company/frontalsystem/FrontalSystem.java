package com.company.frontalsystem;

import com.company.application.Application;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class FrontalSystem {

    /*
    * Используем блокирующую очередь, так как нам необходимо приостанавливать выполнение потока
    *  при пустой или переполненной очереди; take() имеет проверку на пустоту
    */
    private final ArrayBlockingQueue<Application> applicationQueue = new ArrayBlockingQueue<>(2);

    public void addApplication(Application application) throws InterruptedException {
         applicationQueue.put(application);
    }

    public Application getApplication() throws InterruptedException {
        return applicationQueue.take();
    }

}
