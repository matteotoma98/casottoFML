package com.unicam.cs.ids.casotto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

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

        /*Utente utente = new Utente();
        int scelta;
        do{
            System.out.println("Scegli cosa vuoi fare: ");
            System.out.println("1: Login ");
            System.out.println("2: Registrazione ");
            System.out.println("0: Esci ");
            Scanner scanner = new Scanner(System.in);
            scelta = scanner.nextInt();
            Scanner scanner2 = new Scanner(System.in);
            String username;
            String password;
            switch(scelta) {
                case 1:
                    System.out.println("Digita Username");
                    username = scanner2.nextLine();
                    System.out.println("Digita Password");
                    password = scanner2.nextLine();
                    utente.login(username, password);
                    break;
                case 2:
                    System.out.println("Digita Username");
                    username = scanner2.nextLine();
                    System.out.println("Digita Password");
                    password = scanner2.nextLine();
                    utente.registrazione(username, password);
                    break;
            }
        }
        while(scelta != 0);
        */



    }
}
