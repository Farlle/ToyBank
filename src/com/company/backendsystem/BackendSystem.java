package com.company.backendsystem;

import com.company.application.Application;
import com.company.application.Operation;

public class BackendSystem {

    private long balance;

    public BackendSystem(long balance) {
        this.balance = balance;
    }


    public void applicationProcessor(Application application, String nameApplication) {
        Operation operationType = application.getTypeOperation();
        switch (operationType) {
            case INCREASE: {
                increaseBalance(application, nameApplication);
                break;
            }
            case DECREASE: {
                decreaseBalance(application, nameApplication);
                break;
            }
        }
    }

    public synchronized void decreaseBalance(Application application, String nameApplication) {
        balance += application.getSum();
        System.out.printf("БЭК система: Заявка %s от %s обработана. Баланс банка = %d\n",
                application, nameApplication, balance);
    }


    public synchronized void increaseBalance(Application application, String nameApplication) {
        long amount = application.getSum();
        while (balance - amount < 0) {
            System.out.printf("БЭК система: Заявка %s от %s не обработана. Баланс банка = %d\n",
                    application, nameApplication, balance);
            return;
        }
        balance -= amount;
        System.out.printf("БЭК система: Заявка %s от %s обработана. Баланс банка = %d\n",
                application, nameApplication, balance);
    }

}
