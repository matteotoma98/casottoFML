package com.unicam.cs.ids.casotto.Connectors;

import com.unicam.cs.ids.casotto.utenti.Cliente;
import com.unicam.cs.ids.casotto.utilities.SendEmail;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AddettoAttivitaConnector {


    Connection connection;

    public AddettoAttivitaConnector() {
        try {
            connection = DBConnector.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        } //add exception here
    }


    public void setDate(Date data_inizio_attivita, Date data_fine_attività, int num_posti, int id_attivita) {
        boolean result = false;
        try {
            PreparedStatement preparedStatement3 = connection.prepareStatement("UPDATE attivita SET data_inizio_attivita='" + data_inizio_attivita + "',data_fine_attivita='" + data_fine_attività + "', num_posti='" + num_posti + "'WHERE id_attivita=" + id_attivita);
            result = preparedStatement3.executeUpdate() > 0;
            if (result) {
                System.out.println("Dati nella tabella attività cambiati");
            } else {
                System.out.println("id attività sbagliato");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ResultSet sendEmail(int id_attivita) {
        ResultSet result = null;
        Cliente cliente = new Cliente();
        //Date data= Date.valueOf(java.time.LocalDate.now());
        try {
            result = connection.createStatement().executeQuery("SELECT email FROM prenotazioneattivita WHERE id_attivita='" + id_attivita + "'");
            while (result.next()) {
                SendEmail sendEmail = new SendEmail();
                sendEmail.sendMail(result.getString("email"));
                System.out.print(result.getString("email") + "\n");
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

}
