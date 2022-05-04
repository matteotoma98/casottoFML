package com.unicam.cs.ids.casotto.Connectors;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;

public class PrenotazioneSpiaggiaConnector {
    Connection connection;


    public PrenotazioneSpiaggiaConnector() {
        try {
            connection = DBConnector.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        } //a
    }

    public boolean PrenotaSpiaggia(int id_prenotazione, Date data_inizio_prenotazione, Date data_fine_prenotazione, int num_fila_ombrellone, int id_ombrellone, int lettini, String email) {
        boolean result = false;
        boolean result2 = false;
        boolean result3 = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO prenotazionespiaggia VALUES (?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, id_prenotazione);
            preparedStatement.setDate(2, data_inizio_prenotazione);
            preparedStatement.setDate(3, data_fine_prenotazione);
            preparedStatement.setInt(4, num_fila_ombrellone);
            preparedStatement.setInt(5, id_ombrellone);
            preparedStatement.setInt(6, lettini);
            preparedStatement.setString(7, email);

            result = preparedStatement.executeUpdate() > 0;
            if (result) {
                try {
                    PreparedStatement preparedStatement1 = connection.prepareStatement("UPDATE chalet set quantita_ombrelloni_disponibili = quantita_ombrelloni_disponibili-1 where quantita_ombrelloni_disponibili>0");
                    //preparedStatement.setInt(1,lettini);
                    result2 = preparedStatement1.executeUpdate() > 0;
                    if (result2) {
                        System.out.println("Decrementazione ombrelloni effettuata!");
                        try {
                            PreparedStatement preparedStatement2 = connection.prepareStatement("UPDATE chalet set quantita_lettini_disponibili = quantita_lettini_disponibili-'" + lettini + "' where quantita_lettini_disponibili>0");
                            result3 = preparedStatement2.executeUpdate() > 0;
                            if (result3) System.out.println("Decrementazione lettini effettuata!");
                            else System.out.println("Decrementazione lettini NON Riuscita.");
                        } catch (Exception e) {
                            System.out.println(e);
                            result3 = false;
                        }

                    } else System.out.println("Decrementazione ombrelloni NON Riuscita.");
                } catch (Exception e) {
                    System.out.println(e);
                    result2 = false;
                }
                System.out.print(email + ", ");
                System.out.println("hai effettuato la prenotazione con successo! \n");
            } else System.out.println("Prenotazione NON Riuscita.");
        } catch (Exception e) {
            System.out.println(e);
            result = false;
        }
        return result;
    }


    public boolean cancellazionePrenotazione(int id_prenotazione, int lettini) {
        boolean result = false;
        try {
            PreparedStatement preparedStatement1 = connection.prepareStatement("UPDATE chalet quantita_ombrelloni_disponibili = quantita_ombrelloni_disponibili-1 where quantita_ombrelloni_disponibili>0");
            //preparedStatement.setInt(1,lettini);
            result = preparedStatement1.executeUpdate() > 0;
            if (result) System.out.println("Decrementazione effettuata!");
            else System.out.println("Decrementazione NON Riuscita.");

        } catch (Exception e) {
            System.out.println(e);
            result = false;
        }
        return result;
    }
}
