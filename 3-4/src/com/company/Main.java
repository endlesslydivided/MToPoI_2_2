package com.company;

import java.io.FileWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.logging.LogManager;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.alibaba.fastjson.*;
import com.company.account.Account;
import com.company.authorization.Authorization;
import com.company.cardset.CardSet;
import com.company.cardmanager.CardManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

public class Main {

    private static final org.apache.log4j.Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            log.info("Начало программы_____________________________");
            CardSet cardSet = new CardSet();
            CardManager cm = new CardManager();
            cm.createCardSet(cardSet);

            Account newAcc = new Account();
            String jsonString;
            try(FileWriter writer = new FileWriter("card.json", false))
            {
                for(Account x: cardSet.cardSet)
                {
                    jsonString =  JSON.toJSONString(x);
                    writer.write(jsonString);
                    Account secAcc = JSON.parseObject(jsonString, Account.class);
                    System.out.println(secAcc.toString());
                }
            }



            System.out.println("Count of accounts -> " + cardSet.cardSet.stream().count());
            System.out.println("Sum of accounts -> " + cardSet.cardSet.stream().mapToDouble((s) -> s.getBalance()).sum());
            System.out.println("Average of accounts balance -> " + cardSet.cardSet.stream().mapToDouble(s -> s.getBalance()).average());


            String log4jConfPath = "D:\\ALEX\\STUDY\\4SEM_2COURSE\\MToPiI\\LABS\\Lab3\\src\\resources\\log4j.properties";
            PropertyConfigurator.configure(log4jConfPath);

            cm.createCardSet(cardSet);
            CardSet secCardSet = new CardSet();
            cm.generateCardSet(secCardSet);

            //Stream API
            Collection<Account> collec = Arrays.asList(new Account(1,true),
                    new Account(2,true),
                    new Account(3,false),
                    new Account(4,true),
                    new Account(55,false));
            Stream<Account> streamFromCollection_1 = collec.stream();
            System.out.println("Исходная коллекция:");
            for(Account x: streamFromCollection_1.collect(Collectors.toList()))
            {
                System.out.println(x);
            }
            System.out.println("Значение баланса больше 3:");
            Stream<Account> streamFromCollection_2 = collec.stream().filter(w -> w.balance >3);
            for(Account x: streamFromCollection_2.collect(Collectors.toList()))
            {
                System.out.println(x);
            }
            Stream<Account> streamFromCollection_3 = collec.stream().filter(w -> w.status == false);
            System.out.println("Заблокированные карты:");
            for(Account x: streamFromCollection_3.collect(Collectors.toList()))
            {
                System.out.println(x);
            }

            Stream<Account> streamFromCollection_4 = collec.stream().limit(3);
            System.out.println("Три элемента");
            for(Account x: streamFromCollection_4.collect(Collectors.toList()))
            {
                System.out.println(x);
            }





            Scanner in = new Scanner(System.in);
            byte answer = 0;
            System.out.println("Авторизация: \n 1-Клиент \n 2-Администратор\n");

            while (answer != 1 && answer != 2) {
                System.out.print("Ввод:");
                answer = in.nextByte();
                System.out.println();
            }


            Authorization authorization = new Authorization(answer);

            if (authorization.clientFlag) {
                int choice = 1;
                while (choice != 0) {

                    System.out.println("1-Показать баланс");
                    System.out.println("2-Пополнить счёт");
                    System.out.println("3-Заблокировать карту");
                    System.out.println("4-Совершить платёж");
                    System.out.println("5-Разблокировать карту");
                    System.out.println("0-Выход");

                    System.out.print("\nВвод:");
                    choice = in.nextInt();

                    switch (choice) {
                        case 1:
                            authorization.client.showBalance();
                            break;
                        case 2:
                            authorization.client.replenishAccount();
                            break;
                        case 3:
                            authorization.client.blockCard();
                            break;
                        case 4:
                            authorization.client.makePayment();
                            break;
                        case 5:
                            authorization.client.unblockCard();
                            break;
                    }
                }
            } else if (authorization.adminFlag) {
                int choice = 3;
                while (choice != 0) {

                    System.out.println("1-Заблокировать карту");
                    System.out.println("2-Разблокировать карту");
                    System.out.println("0-Выход");

                    System.out.print("\nВвод:");
                    choice = in.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.print("Введите номер карты:");
                            answer = in.nextByte();
                            System.out.println();
                            authorization.admin.blockCard(secCardSet.searchByIndex(answer));
                            break;
                        case 2:
                            System.out.print("Введите номер карты:");
                            answer = in.nextByte();
                            System.out.println();
                            authorization.admin.unblockCard(secCardSet.searchByIndex(answer));
                            break;
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
