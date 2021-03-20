package com.company.card;

import java.util.Scanner;
import static java.lang.System.out;

public class OverdraftCard extends Card{


    @Override
    public void makePurchase(double cost) {
        if((account.getBalance() - cost)<0 || account.getBalance() == 0)
        {
            Scanner in = new Scanner((System.in));

            byte answer = 0;

            out.println("\nСделать покупку под кредит? (1 - да, 2 - нет) ▬ ");

            while(answer != 1 && answer != 2) {
                out.print("Ввод:");
                answer = in.nextByte();
                out.println();
            }

            if(answer == 1) {
                double sub = cost - account.getBalance();
                out.println("Недостаток составляет " + sub);
                out.println("\n" + "Будет взят кредит %30 от суммы " + sub);
                account.setBalance(0);
            }
            else if (answer == 2) {
                out.println("Продолжить");
            }
        }
        else
        {
            account.makePurchase(cost);
            out.println("\nОплата прошла успешно\n");
        }
    }

    @Override
    public void refill(double amount) {
        double commission = amount * 0.02;
        amount -= commission;
        account.replenishAccount(amount);
    }
}
