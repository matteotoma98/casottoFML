package com.unicam.cs.ids.casotto.Connectors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PrenotazioneAttivitaConnector {

    Connection connection;

    public PrenotazioneAttivitaConnector() {
        try {
            connection = DBConnector.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<String> email_Iscritti(int id_attivita) {
        ResultSet resultSet = null;
        ArrayList<String> email_iscritti = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT email FROM prenotazioneattivita WHERE id_attivita='" + id_attivita + "'");


            while (resultSet.next()) {
                // System.out.print(resultSet.getString("email")+",\n");
                email_iscritti.add(resultSet.getString("email"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return email_iscritti;
    }
}
