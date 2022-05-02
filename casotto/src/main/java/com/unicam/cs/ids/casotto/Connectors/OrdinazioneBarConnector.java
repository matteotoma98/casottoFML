package com.unicam.cs.ids.casotto.Connectors;

import com.unicam.cs.ids.casotto.Ordinazione_Bar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.format.DateTimeFormatter;

public class OrdinazioneBarConnector {


    Connection connection;

    public OrdinazioneBarConnector(DateTimeFormatter date, int quantita, int incremento, String scelta) {
        try {
            connection = DBConnector.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        } //add exception here
    }

    public DateTimeFormatter getDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        //    System.out.println("yyyy/MM/dd HH:mm:ss-> "+dtf.format(LocalDateTime.now()));
        return dtf;
    }

    /*

    public LocalDateTime getDate() {
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatDateTime = now.format(format);
        //System.out.println("After Formatting: " + formatDateTime);


        LocalDateTime.now();

        return formatDateTime;
    }
    */
    public boolean addOrdine(Ordinazione_Bar ordinazione_bar) {
        int i = 0;
        boolean result;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ordini VALUES ( ?,?,?,?,?)");
            preparedStatement.setInt(1, ordinazione_bar.getId_prodotto());
            preparedStatement.setInt(2, ordinazione_bar.setId_ordinazione(i + 1));
            preparedStatement.setDate(3, ordinazione_bar.setData_ordinazione(ordinazione_bar.getData_ordinazione()Date()));
            preparedStatement.setInt(4, ordinazione_bar.getId_ombrellone());
            preparedStatement.setInt(5, ordinazione_bar.getQuantita());

            result = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

        /*

        public Ordinazione_Bar getOrdinazione(Date data_ordinazione, int id_ombrellone, int id_ordinazione, int quantita ) {
            ResultSet result;
            Cliente cliente = new Cliente();
            try {
                result = connection.createStatement().executeQuery("SELECT * FROM clienti WHERE email = '" + email + "'");
                while (result.next()) {

                    cliente = convertiRisultatoInCliente(result);
                }
            } catch (Exception e) {
                System.out.println(e);
            } //add exception here

            return cliente;
        }
       */


}
