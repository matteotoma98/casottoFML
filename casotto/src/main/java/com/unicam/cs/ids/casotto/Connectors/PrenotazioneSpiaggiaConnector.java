package com.unicam.cs.ids.casotto.Connectors;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.sql.Date;
import java.util.GregorianCalendar;

public class PrenotazioneSpiaggiaConnector {
    Connection connection;


    public PrenotazioneSpiaggiaConnector() {
        try {
            connection = DBConnector.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        } //a
    }

    public boolean PrenotaSpiaggia(int id_prenotazione, Date data_inizio_prenotazione, Date data_fine_prenotazione, int num_fila_ombrellone, int id_ombrellone) {
        boolean result = true;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO prenotazionespiaggia VALUES (?,?,?,?,?)");
            preparedStatement.setInt(1, id_prenotazione);
            preparedStatement.setDate(2, data_inizio_prenotazione);
            preparedStatement.setDate(3, data_fine_prenotazione);
            preparedStatement.setInt(4, num_fila_ombrellone);
            preparedStatement.setInt(5, id_ombrellone);
            result = preparedStatement.executeUpdate() > 0;
            if(result) System.out.print("Prenotazione effettuata! \n");
        } catch (Exception e) {
            result = false;
        }
        return result;
    }
}
