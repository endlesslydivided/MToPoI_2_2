package com.company.card;

import static java.lang.System.out;
public class DebitCard extends Card {

    @Override
    public void refill(double amount)
    {
        double commission = amount *0.01;
        amount -=commission;
        account.replenishAccount(amount);
    }

    @Override
    public void makePurchase(double cost) {
        if((account.getBalance() - cost) < 0 || account.getBalance() == 0)
        {
            out.println("\nНедостаточно средств на счёте\n");
        }
        else
        {
            account.makePurchase(cost);
            out.println("\nОплата прошла успешно\n");
        }
    }
}
