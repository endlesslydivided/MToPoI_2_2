package com.company.authorization;

import com.company.card.cardtype;
import com.company.entities.Admin;
import com.company.entities.Client;

import java.util.Scanner;

public class Authorization {
    public byte typeOfEntities;
    public Client client;
    public boolean clientFlag;
    public Admin admin;
    public boolean adminFlag;

    public Authorization(byte typeOfEntities) {

        this.typeOfEntities = typeOfEntities;
        if (typeOfEntities == 1) {
            Scanner in = new Scanner(System.in);
            byte answer = 0;

            System.out.println("Тип карты: \n 1-Дебетовая \n 2-Овердрафт\n");

            while(answer != 1 && answer != 2)
            {
                System.out.print("Ввод:");
                answer = in.nextByte();
                System.out.print("\n");
            }
            if(answer == 1)
                client = new Client(cardtype.DEBIT);
            else if(answer == 2)
                client = new Client(cardtype.OVERDRAFT);
            clientFlag = true;
        }
        else if (typeOfEntities == 2) {
            admin = new Admin();
            adminFlag = true;
        }
    }
}
