package com.company;

public class Main {

    public static void main(String[] args) {
        var connection = new com.company.InternetConnection();
        connection.getLocalHost();
        connection.getByName("www.belstu.by");
        byte ip[] = {(byte)127,(byte)0,(byte)0,(byte)7};
        connection.getByAdress("Unknown", ip);
        connection.ReadHTML("https://www.tut.by");
        connection.getInfo("https://www.tut.by");
    }
}
