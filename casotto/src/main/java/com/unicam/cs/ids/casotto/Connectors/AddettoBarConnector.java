package com.unicam.cs.ids.casotto.Connectors;


import com.unicam.cs.ids.casotto.Cliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddettoBarConnector {

    Connection connection;

    public AddettoBarConnector() {
        try {
            connection = DBConnector.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        } //add exception here
    }

    public ResultSet getAttivita() {
        ResultSet result = null;
        Cliente cliente = new Cliente();
        //Date data= Date.valueOf(java.time.LocalDate.now());
        try {
            result = connection.createStatement().executeQuery("SELECT id_attivita, nome_attivita,data_inizio_attivita, data_fine_attivita,num_posti FROM attivita ORDER BY id_attivita");
            while (result.next()) {
                System.out.print("id attività: ");
                System.out.print(result.getInt("id_attivita") + ", ");
                System.out.print(result.getString("nome_attivita") + ", data inizio attività: ");
                System.out.print(result.getTimestamp("data_inizio_attivita") + ", data fine attività: ");
                System.out.print(result.getTimestamp("data_fine_attivita") + " , numero posti disponibili: ");
                System.out.print(result.getInt("num_posti"));
                System.out.println("");
            }
              /*ResultSet resultSet = statement.executeQuery("select * from chalet ");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("quantita_lettini"));
            } */
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }


    public int last_prenotazione(String email) {

        boolean result;
        int id_prenotazione = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id_prenotazione_attivita as last_id FROM prenotazioneattivita WHERE id_prenotazione_attivita= (SELECT MAX(id_prenotazione_attivita) FROM prenotazioneattivita)");
            int last_prenotazione = 0;
            while (resultSet.next()) {
                last_prenotazione = resultSet.getInt("last_id");
            }
            id_prenotazione = last_prenotazione + 1;
        } catch (Exception e) {
            System.out.println(e);
        }
        return id_prenotazione;
    }

}
