package com.unicam.cs.ids.casotto;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@SpringBootApplication
public class CasottoApplication {

    private String email2;

    public CasottoApplication() {
        super();
    }

    public static void main(String[] args) throws Exception {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/casotto", "root", "casottofml");
            Statement statement = connection.createStatement();
            OpenApp app = new OpenApp();
            app.Open();

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Probabilmente non sei riuscito a connetterti al database. Assicurati di avere mysql installato e che tu sia collegato al database.");
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
