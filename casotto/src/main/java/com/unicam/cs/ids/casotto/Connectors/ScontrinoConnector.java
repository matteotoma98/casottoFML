package com.unicam.cs.ids.casotto.Connectors;

import com.unicam.cs.ids.casotto.utilities.Scontrino;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class ScontrinoConnector {

    Connection connection;


    int id_prenotazione_ombrellone;
    int id_ordinazione_bar = 0;

    public ScontrinoConnector() {
        try {
            connection = DBConnector.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        } //add exception here
    }

    public boolean creaScontrino(int id_scontrino, Date data_scontrino, int id_ombrellone, double prezzo_totale, String tipologia) {
        Scontrino scontrino = new Scontrino(id_scontrino, data_scontrino, id_ombrellone, prezzo_totale);
        scontrino.toString();
        boolean result = false;
        boolean result2 = false;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX(id_scontrino) as last_id_scontrino FROM scontrino");
            int last_scontrino = 0;
            while (resultSet.next()) {
                last_scontrino = resultSet.getInt("last_id_scontrino");
            }
            id_scontrino = last_scontrino + 1;

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO scontrino VALUES ( ?,?,?,?,?)");
            preparedStatement.setInt(1, id_scontrino);
            // System.out.println(ordinazione_bar.getId_ombrellone());
            preparedStatement.setDate(2, (java.sql.Date) data_scontrino);
            preparedStatement.setInt(3, id_ombrellone);
            preparedStatement.setDouble(4, prezzo_totale);
            preparedStatement.setString(5, tipologia);

            result = preparedStatement.executeUpdate() > 0;

        } catch (Exception e) {
        /*    System.out.println(id_scontrino+"\n");
            System.out.println(data_scontrino+"\n");
            System.out.println(id_ombrellone+"\n");
            System.out.println(prezzo_totale); */
            System.out.println(e);
            System.out.println("problema");
            result2 = false;
        }
        return result;
    }

    /*public String toString(double prezzo_totale, int id_scontrino, Date data, int id_ombrellone) {
        return "" +
                "prezzo=" + prezzo_totale +
                "id_scontrino=" + id_scontrino +
                "data:" + data +
                "id_ombrellone" + id_ombrellone
                ;
    } */


}
