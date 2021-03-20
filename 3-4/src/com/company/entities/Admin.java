package com.company.entities;

import com.company.account.Account;
import com.company.card.Card;
import com.company.cardset.CardSet;

import static java.lang.System.out;
public class Admin {

    CardSet cardset;
    public boolean blockCard(Account card)
    {
        if(card.isStatus())
        {
            out.println("\nКарта заблокирована\n");
            card.setStatus(false);
            return true;
        }
        else if(card.isStatus())
        {
            out.println("\nКарта заблокирована\n");
            card.setStatus(false);
            return true;
        }
        else
        {
            out.println("\nКарта уже заблокирована\n");
            return false;
        }
    }

    public boolean unblockCard(Account card) {
        if(!(card.isStatus()))
        {
            out.println("\nВаша карта разблокирована\n");
            card.setStatus(true);
            return true;
        }
        else if(!(card.isStatus()))
        {
            out.println("\nВаша карта разблокирована\n");
            card.setStatus(true);
            return true;
        }
        else
        {
            out.println("\nВаша карта уже разблокирована\n");
            return false;
        }
    }

    public Account searchByIndex(int index)
    {
        return cardset.searchByIndex(index);
    }
}
