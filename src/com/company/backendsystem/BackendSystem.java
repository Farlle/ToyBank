package com.company.backendsystem;

public class BackendSystem {

    private long balance;

    public BackendSystem(long balance) {
        this.balance = balance;
    }

    public synchronized void increaseBalance(long amount) {
        balance += amount;
    }

    public synchronized void decreaseBalance(long amount) {
        if (balance < amount) {
            throw new RuntimeException("Not enough money");
        }

        balance -= amount;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}
