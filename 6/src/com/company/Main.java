package com.company;

import connector.DBConnector;
import java.sql.*;
import java.util.Scanner;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

public class Main {
    public static void main(String[] args) {
        DBConnector connector = new DBConnector();
        try {
            connector.SetConnection();
            String log4jConfPath = "..\\6\\src\\resources\\log4j.properties";
            PropertyConfigurator.configure(log4jConfPath);


            Scanner scanner = new Scanner(System.in);
            PreparedStatement preparedStatement = connector.connection.prepareStatement(connector.SELECT_ALL_PLANETS_WITH_LIFE);
            System.out.println("Найти планеты: 1-обитаемые; 0-не обитаемые");
            String value_life = scanner.nextLine();
            preparedStatement.setString(1, value_life);
            ResultSet queryResult1 = preparedStatement.executeQuery();
            connector.DisplayRows(queryResult1, connector.SELECT_ALL_PLANETS_WITH_LIFE, connector.NAME_COL,connector.RADIUS_COL,connector.AVG_COL,connector.LIFE_COL,"SatelliteName");

            ResultSet queryResult2 = connector.ExecuteQuery(connector.MIN_RADIUS_MAX_SATELLITES);
            connector.DisplayRows(queryResult2, connector.MIN_RADIUS_MAX_SATELLITES, connector.NAME_COL,"Минимальный радиус","Количество спутников");

            ResultSet queryResult3 = connector.ExecuteQuery(connector.PLANET_WITH_SATELLITE_RADIUS_MAX_SUM);
            connector.DisplayRows(queryResult3,connector.PLANET_WITH_SATELLITE_RADIUS_MAX_SUM,connector.NAME_COL,"Сумма радиусов");

            connector.CloseConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
