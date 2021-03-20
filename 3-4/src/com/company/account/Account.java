package com.company.account;
import com.company.card.Card;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Account {

    private static final Logger log = Logger.getLogger(Card.class);
    String log4jConfPath = "D:\\ALEX\\STUDY\\4SEM_2COURSE\\MToPiI\\LABS\\Lab3\\src\\resources\\log4j.properties";

    public double balance;
    public boolean status;

    public Account(){}

    public Account(double balance,boolean status)
    {
        PropertyConfigurator.configure(log4jConfPath);
        this.balance = balance;
        this.status =status;
        log.info("Создан новый счёт");
    }

    public void replenishAccount(double amount)
    {
        PropertyConfigurator.configure(log4jConfPath);
        this.balance = amount;
        log.info("Счёт пополнен");
    }

    public void makePurchase(double cost)
    {
        this.balance -= cost;

    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.valueOf(getBalance()) + " " + String.valueOf(isStatus());
    }


}
