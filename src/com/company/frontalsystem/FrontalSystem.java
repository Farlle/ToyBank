package com.company.frontalsystem;

import com.company.application.Application;

import java.util.Queue;

public class FrontalSystem {

    private Queue<Application> applicationQueue;


    public void addApplication(Application application){
        applicationQueue.add(application);
    }

    public Application getApplication(){
        var application = applicationQueue.poll();

        return application;
    }


}
