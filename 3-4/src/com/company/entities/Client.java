package com.company.entities;

import com.company.card.DebitCard;
import com.company.card.OverdraftCard;
import com.company.card.cardtype;

import java.util.Scanner;
import static java.lang.System.out;

public class Client implements IClient{

    public DebitCard dc;
    public boolean dcFlag;
    public OverdraftCard oc;
    public boolean ocFlag;

    public Client(cardtype typeOfCard)
    {
        if(typeOfCard == cardtype.DEBIT)
        {
            dc = new DebitCard();
            dcFlag = true;
        }
        else if(typeOfCard == cardtype.OVERDRAFT)
        {
            oc = new OverdraftCard();
            ocFlag = true;
        }


    }

    @Override
    public void showBalance() {
        if(dcFlag && dc.account.isStatus())
        {
            out.println(dc.getBalance());
        }
        else if (ocFlag && oc.account.isStatus())
        {
            out.println(oc.getBalance());
        }
    }

    @Override
    public boolean blockCard() {
        if(dcFlag && dc.account.isStatus())
        {
            out.println("\nВаша карта заблокирована\n");
            dc.account.setStatus(false);
            return true;
        }
        else if(ocFlag && oc.account.isStatus())
        {
            out.println("\nВаша карта заблокирована\n");
            oc.account.setStatus(false);
            return true;
        }
        else
        {
            out.println("\nВаша карта уже заблокирована\n");
            return false;
        }
    }

    @Override
    public boolean unblockCard() {
        if(!(dcFlag && dc.account.isStatus()))
        {
            out.println("\nВаша карта разблокирована\n");
            dc.account.setStatus(true);
            return true;
        }
        else if(!(ocFlag && oc.account.isStatus()))
        {
            out.println("\nВаша карта разблокирована\n");
            oc.account.setStatus(true);
            return true;
        }
        else
        {
            out.println("\nВаша карта уже разблокирована\n");
            return false;
        }
    }

    @Override
    public boolean makePayment() {
        if(dcFlag && dc.account.isStatus())
        {
            Scanner in = new Scanner(System.in);
            out.println("\nВведите сумму:\n");
            dc.makePurchase(in.nextDouble());
            out.println();
            return true;
        }
        else if(ocFlag && oc.account.isStatus())
        {
            Scanner in = new Scanner(System.in);
            out.println("\nВведите сумму:\n");
            oc.makePurchase(in.nextDouble());
            out.println();
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean replenishAccount() {
        Scanner in = new Scanner(System.in);
        if(dcFlag && dc.account.isStatus())
        {
            out.println("\nВведите сумму пополнения\n");
            dc.refill(in.nextDouble());
            out.println();
            return true;
        }
        else if (ocFlag && oc.account.isStatus())
        {
            out.println("\nВведите сумму пополнения\n");
            oc.refill(in.nextDouble());
            out.println();
            return true;
        }
        else {
            return false;
        }
    }
}
