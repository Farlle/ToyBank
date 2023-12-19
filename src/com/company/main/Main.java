package com.company.main;

import com.company.application.Application;
import com.company.application.Operation;
import com.company.applicationprocessor.ApplicationProcessor;
import com.company.backendsystem.BackendSystem;
import com.company.backendsystem.BackendSystemTimeout;
import com.company.client.Client;
import com.company.frontalsystem.FrontalSystem;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        BackendSystem backendSystem = new BackendSystem();
        FrontalSystem frontalSystem = new FrontalSystem();
        ExecutorService executorService = Executors.newFixedThreadPool(7);

        Thread applicationProcessor1 = new Thread(new ApplicationProcessor("Обработчи заявок №1",
                frontalSystem, backendSystem));
        Thread applicationProcessor2 = new Thread(new ApplicationProcessor("Обработчи заявок №2",
                frontalSystem, backendSystem));

        Thread client1 = new Thread(new Client("Клиент №1",
                new Application("Клиент №1", 30_000, Operation.DECREASE), frontalSystem));
        Thread client2 = new Thread(new Client("Клиент №2",
                new Application("Клиент №2", 15_000, Operation.INCREASE), frontalSystem));
        Thread client3 = new Thread(new Client("Клиент №3",
                new Application("Клиент №3", 20_000, Operation.INCREASE), frontalSystem));
        Thread client4 = new Thread(new Client("Клиент №4",
                new Application("Клиент №4", 50_000, Operation.DECREASE), frontalSystem));
        Thread client5 = new Thread(new Client("Клиент №5",
                new Application("Клиент №5", 15_000, Operation.DECREASE), frontalSystem));

        BackendSystemTimeout backendSystemTimeout1 = new BackendSystemTimeout(backendSystem);
        BackendSystemTimeout backendSystemTimeout2 = new BackendSystemTimeout(backendSystem);
        BackendSystemTimeout backendSystemTimeout3 = new BackendSystemTimeout(backendSystem);

        ArrayList<BackendSystemTimeout> backendSystemTimeouts = new ArrayList<>();
        backendSystemTimeouts.add(backendSystemTimeout1);
        backendSystemTimeouts.add(backendSystemTimeout2);
        backendSystemTimeouts.add(backendSystemTimeout3);

        try {
            executorService.invokeAll(backendSystemTimeouts);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        executorService.execute(client1);
        executorService.execute(client2);
        executorService.execute(client3);
        executorService.execute(client4);
        executorService.execute(client5);
        executorService.execute(applicationProcessor1);
        executorService.execute(applicationProcessor2);


    }
}
