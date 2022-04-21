package com.unicam.cs.ids.casotto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@SpringBootApplication
public class CasottoApplication {

    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/casotto", "root", "casottofml");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from chalet ");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("firstname"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Probabilmente non sei riuscito a connetterti al database. Assicurati di avere mysql installato e che tu sia collegato al database.");
        }

        SpringApplication.run(CasottoApplication.class, args);

    }
}
