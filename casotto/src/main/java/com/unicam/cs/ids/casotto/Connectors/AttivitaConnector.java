package com.unicam.cs.ids.casotto.Connectors;

import com.unicam.cs.ids.casotto.Cliente;

import java.sql.*;
import java.util.Date;

public class AttivitaConnector {

    Connection connection;

    public AttivitaConnector() {
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


    public boolean addPrenotazione(String email, int id, int num_posti) throws IllegalArgumentException {
        ResultSet result;
        ResultSet result4;
        boolean result2 = false;
        boolean result3 = false;
        Date data_inizio_attivita = null;
        Date data_fine_attivita = null;
        try {
            result = connection.createStatement().executeQuery("SELECT id_attivita,data_inizio_attivita,data_fine_attivita FROM attivita WHERE id_attivita='" + id + "'");
            while (result.next()) {
                data_inizio_attivita = result.getTimestamp("data_inizio_attivita");
                data_fine_attivita = result.getTimestamp("data_fine_attivita");
            }
            try {
                result4 = connection.createStatement().executeQuery("SELECT id_attivita, num_posti FROM attivita WHERE num_posti >='" + num_posti + "'AND id_attivita='" + id + "'");
                if (result4.next() == false) {
                    System.out.println("Posti non disponibili per l'attività");
                } else {

                    PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO prenotazioneattivita VALUES (?,?,?,?,?,?)");
                    preparedStatement.setString(1, email);
                    preparedStatement.setTimestamp(2, (Timestamp) data_inizio_attivita);
                    preparedStatement.setTimestamp(3, (Timestamp) data_fine_attivita);
                    preparedStatement.setInt(4, id);
                    preparedStatement.setInt(5, num_posti);
                    preparedStatement.setInt(6, last_prenotazione(email));
                    result2 = preparedStatement.executeUpdate() > 0;
                    if (result2) {
                        PreparedStatement preparedStatement3 = connection.prepareStatement("UPDATE attivita set num_posti= num_posti-'" + num_posti + "'WHERE id_attivita='" + id + "'"); //"'WHERE num_posti>=0 );
                        result3 = preparedStatement3.executeUpdate() > 0;
                        System.out.println("Prenotazione effettuata");
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
                result3 = false;
            }
           // throw new IllegalArgumentException("hai prenotato troppi posti rispetto a quelli disponibili");
        } catch (Exception e) {
            System.out.println(e);
        }
        return result2 = true;
    }
}
