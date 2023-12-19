package com.company.backendsystem;

import com.company.application.Application;
import com.company.application.Operation;

import java.util.concurrent.atomic.AtomicLong;

public class BackendSystem {

    private AtomicLong balance = new AtomicLong();

    public BackendSystem(long balance) {
        this.balance.getAndUpdate((x) -> balance + x);
    }


    public void applicationProcessor(Application application, String nameApplication) {
        Operation operationType = application.getTypeOperation();
        switch (operationType) {
            case INCREASE -> increaseBalance(application, nameApplication);
            case DECREASE -> decreaseBalance(application, nameApplication);
            default -> throw new IllegalStateException("Unexpected value: " + operationType);
        }
    }

    public void decreaseBalance(Application application, String nameApplication) {
        balance.getAndUpdate((x) -> x + application.getSum());
        System.out.printf("БЭК система: Заявка %s от %s обработана. Баланс банка = %d\n",
                application, nameApplication, balance.get());
    }


    public void increaseBalance(Application application, String nameApplication) {
        long amount = application.getSum();
        while (balance.get() < amount) {
            System.out.printf("БЭК система: Заявка %s от %s не обработана. Баланс банка = %d\n",
                    application, nameApplication, balance.get());
            return;
        }
        balance.getAndUpdate((x) -> x - application.getSum());
        System.out.printf("БЭК система: Заявка %s от %s обработана. Баланс банка = %d\n",
                application, nameApplication, balance.get());
    }

}
