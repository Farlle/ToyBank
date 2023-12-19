package com.company.client;


import com.company.application.Application;
import com.company.applicationprocessor.ApplicationProcessor;
import com.company.frontalsystem.FrontalSystem;

public class Client implements Runnable {

    private String name;
    private FrontalSystem frontalSystem;
    private Application application;

    public Client(String name, Application application, FrontalSystem frontalSystem) {
        this.name = name;
        this.application = application;
        this.frontalSystem = frontalSystem;

    }

    @Override
    public void run() {
        try {
            System.out.printf("%s: Заявка %s отправлена в банк%n", name, application);
            frontalSystem.addApplication(application);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
