package com.company.main;

import com.company.application.Application;
import com.company.application.Operation;
import com.company.applicationprocessor.ApplicationProcessor;
import com.company.backendsystem.BackendSystem;
import com.company.client.Client;
import com.company.frontalsystem.FrontalSystem;

public class Main {

    public static void main(String[] args) {
        BackendSystem backendSystem = new BackendSystem(100_000L);

        FrontalSystem frontalSystem = new FrontalSystem();

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

        applicationProcessor1.start();
        applicationProcessor2.start();

        client1.start();
        client2.start();
        client3.start();
        client4.start();
        client5.start();




    }
}
