package com.company.frontalsystem;

import com.company.application.Application;

import java.util.ArrayDeque;
import java.util.Queue;

public class FrontalSystem {

    private final ArrayDeque<Application> applicationQueue = new ArrayDeque<>(2);


    public synchronized void addApplication(Application application) throws InterruptedException {
        while (applicationQueue.size() >= 2) {
            wait();
        }
        applicationQueue.add(application);
        notifyAll();
    }

    public synchronized Application getApplication() throws InterruptedException {
        while (applicationQueue.isEmpty()) {
            wait();
        }
        Application application = applicationQueue.poll();
        notifyAll();
        return application;
    }


}
