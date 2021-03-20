package com.company.cardset;

import com.company.account.Account;

import java.util.ArrayList;
import java.util.List;

public class CardSet {

    public List<Account> cardSet;

    public CardSet()
    {
        this.cardSet = new ArrayList<Account>();
    }

    public CardSet(ArrayList<Account> cardSet)
    {
        this.cardSet = new ArrayList<Account>();
        this.cardSet = cardSet;
    }

    public List<Account> getCardSet() {
        return cardSet;
    }

    public void setCardSet(List<Account> cardSet) {
        this.cardSet = cardSet;
    }

    public void Add (Account item)
    {
        this.cardSet.add(item);
    }

    public void Remove (Account item)
    {
        this.cardSet.remove(item);
    }

    public Account searchByIndex(int index)
    {
        Account acc = new Account();
        if(!(index > cardSet.size() && index < 0))
            acc = cardSet.get(index);
        return acc;
    }
}
