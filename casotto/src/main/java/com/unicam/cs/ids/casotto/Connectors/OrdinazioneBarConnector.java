package com.unicam.cs.ids.casotto.Connectors;

import com.unicam.cs.ids.casotto.Ordinazione_Bar;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class OrdinazioneBarConnector {


    Connection connection;

    public OrdinazioneBarConnector(DateTimeFormatter date, int quantita, int incremento, String scelta) {
        try {
            connection = DBConnector.getConnection();
        } catch (Exception e) {
            System.out.println(e);


        } //add exception here
    }

    public OrdinazioneBarConnector() {

    }

    public DateTimeFormatter getDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        // System.out.println("yyyy/MM/dd HH:mm:ss-> "+dtf.format(LocalDateTime.now()));

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
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ordinazionebar VALUES ( ?,?,?,?,?)");
            preparedStatement.setDate(1, ordinazione_bar.setData_ordinazione(getDate()));
            preparedStatement.setInt(2, ordinazione_bar.getQuantita());
            preparedStatement.setInt(3, ordinazione_bar.setId_ordinazione(i + 1));
            preparedStatement.setInt(4, ordinazione_bar.getId_ombrellone());
            preparedStatement.setInt(5, ordinazione_bar.getId_prodotto());

            result = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println(e);
            result = false;
            System.out.println("nope");
        } return result;
    }
/*
    public List<Ordinazione_Bar> getOrdini() {
        ResultSet result;
        List<Ordinazione_Bar> resultList = new ArrayList<Ordinazione_Bar>();
        try {
            result = connection.createStatement().executeQuery("SELECT * FROM ordinazionebar");

            while (result.next()) {
                resultList.add(convertiRisultatoInOrdine(result));
            }
        } catch (Exception e)
        { System.out.println(e); } //add exception here

        //error checking
        if (resultList.isEmpty())
            System.out.println("Empty result");

        return resultList;
    }

   private Ordinazione_Bar convertiRisultatoInOrdine(ResultSet result)throws SQLException
    {
        Date data_ordinazione= result.getDate("data_ordinazione");
        int quantita= result.getInt("quantita");
        int id_ordinazione= result.getInt("id_ordinazione");
        int id_ombrellone= result.getInt("id_ombrellone")
        int id_prodotto = result.getInt("id_prodotto");


       // DateTimeFormatter data_ordinazione, int quantita, int id_ordinazione, int id_ombrellone, int id_prodotto
      //  return new Ordinazione_Bar(data_ordinazione, quantita, id_ordinazione, id_ombrellone, id_prodotto);
    } */

        /*

        public Ordinazione_Bar getOrdinazione(Date data_ordinazione, int id_ombrellone, int id_ordinazione, int quantita ) {
            ResultSet result;
            Cliente cliente = new Cliente();
            try {
                result = connection.createStatement().executeQuery("SELECT * FROM cliente WHERE email = '" + email + "'");
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
