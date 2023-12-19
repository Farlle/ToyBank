package com.company.backendsystem;

import java.util.Random;
import java.util.concurrent.Callable;

public class BackendSystemTimeout implements Callable<Void> {

    private final int MIN_TIME_OUT = 5000;
    private final int MAX_TIME_OUT = 10000;
    private BackendSystem backendSystem;
    private Random random = new Random();

    public BackendSystemTimeout(BackendSystem backendSystem){
        this.backendSystem = backendSystem;
    }

    private int randomTime(){
        return random.nextInt(MAX_TIME_OUT-MIN_TIME_OUT+1)+MIN_TIME_OUT;
    }
    private int randomMoney(){
        return random.nextInt(5000)+5000;
    }

    @Override
    public Void call() throws Exception {
        try {
            Thread.sleep(randomTime());
            backendSystem.setBalance(randomMoney());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
