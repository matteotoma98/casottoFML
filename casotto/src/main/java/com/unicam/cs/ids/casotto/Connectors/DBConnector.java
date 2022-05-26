package com.unicam.cs.ids.casotto.Connectors;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {


    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/casotto", "root", "casottofml");
        } catch (Exception e) {
            connection = null;
            System.out.println(e);
            e.printStackTrace();
            System.out.println("Probabilmente non sei riuscito a connetterti al database. Assicurati di avere mysql installato e che tu sia collegato al database.");
        }
        return connection;
    }

    /*
        java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/casotto", "root", "casottofml");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from chalet ");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("firstname"));
        } */


}
