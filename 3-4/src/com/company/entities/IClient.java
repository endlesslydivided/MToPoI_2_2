package com.company.entities;

public interface IClient {
    void showBalance();
    boolean blockCard();
    boolean unblockCard();
    boolean makePayment();
    boolean replenishAccount();
}
