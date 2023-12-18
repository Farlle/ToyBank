package com.company.applicationprocessor;

import com.company.application.Application;
import com.company.backendsystem.BackendSystem;
import com.company.frontalsystem.FrontalSystem;

import static com.company.application.Operation.DECREASE;
import static com.company.application.Operation.INCREASE;

public class ApplicationProcessor implements Runnable {

    private String nameApplicationProcessor;
    private FrontalSystem frontalSystem;
    private BackendSystem backendSystem;


    public ApplicationProcessor(String nameApplicationProcessor, FrontalSystem frontalSystem, BackendSystem backendSystem) {
        this.nameApplicationProcessor = nameApplicationProcessor;
        this.frontalSystem = frontalSystem;
        this.backendSystem = backendSystem;

    }

    @Override
    public void run() {
        while (true) {
            try {
                Application application = frontalSystem.getApplication();
                System.out.printf("%s:заявка по - %s\n",
                        this.nameApplicationProcessor, application.getNameClient());
                backendSystem.applicationProcessor(application, this.nameApplicationProcessor);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
