package com.company.card;

import com.company.account.Account;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public abstract class Card
{
    String log4jConfPath = "D:\\ALEX\\STUDY\\4SEM_2COURSE\\MToPiI\\LABS\\Lab3\\src\\resources\\log4j.properties";

        public Account account;
        private static final Logger log = Logger.getLogger(Card.class);
        public Card()
        {
            PropertyConfigurator.configure(log4jConfPath);
            account = new Account(0,true);
                log.info("Создана новая карта");
        }

        public String getBalance()
        {
            return "\n Ваш баланс:" + account.toString();
        }

        public abstract  void refill(double amount);

        public abstract void makePurchase(double cost);
}
