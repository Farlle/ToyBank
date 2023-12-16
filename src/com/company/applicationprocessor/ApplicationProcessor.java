package com.company.applicationprocessor;

import com.company.application.Application;
import com.company.backendsystem.BackendSystem;
import com.company.frontalsystem.FrontalSystem;

public class ApplicationProcessor extends Thread {

    private FrontalSystem frontalSystem;
    private Application application;
    private BackendSystem backendSystem;



    @Override
    public void run() {
        while (true) {
            application = frontalSystem.getApplication();
            if (application.getTypeOperation().equals("increase")) {
                backendSystem.increaseBalance(application.getSum());
            } else if (application.getTypeOperation().equals("decrease")) {
                backendSystem.decreaseBalance(application.getSum());
            }
        }
    }
}
