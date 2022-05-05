package com.unicam.cs.ids.casotto.Connectors;

import com.unicam.cs.ids.casotto.Cliente;
import com.unicam.cs.ids.casotto.Ordinazione_Bar;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class OrdinazioneBarConnector {

    Connection connection;

    public OrdinazioneBarConnector() {
        try {
            connection = DBConnector.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public Date getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
        Date date = new Date(System.currentTimeMillis());
        // System.out.println(formatter.format(date));
        // System.out.println(date);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        // System.out.println("yyyy/MM/dd HH:mm:ss-> "+dtf.format(LocalDateTime.now()));
        return date;
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

    public ResultSet getIdOmbrelloni(String email) {
        boolean result = false;

        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT id_ombrellone FROM cliente WHERE email='" + email + "'");

            while (resultSet.next()) {
                System.out.println("Lista dei tuoi ombrelloni: "+ resultSet.getInt("id_ombrellone"));

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return resultSet;
    }

    public boolean addOrdine(Ordinazione_Bar ordinazione_bar) {
        int i = 0;
        boolean result;
        boolean result2;
        int id_ordinazione = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id_ordinazione as last_id FROM ordinazionebar WHERE id_ordinazione= (SELECT MAX(id_ordinazione) FROM ordinazionebar)");
            int lastordinazione = 0;
            while (resultSet.next()) {
                lastordinazione = resultSet.getInt("last_id");
            }
            id_ordinazione = lastordinazione + 1;
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ordinazionebar VALUES ( ?,?,?,?,?)");
            preparedStatement.setDate(1, ordinazione_bar.setData_ordinazione(getDate()));
            System.out.println(ordinazione_bar.getId_ombrellone());
            preparedStatement.setInt(2, ordinazione_bar.getId_ombrellone());
            preparedStatement.setInt(3, ordinazione_bar.setId_ordinazione(id_ordinazione));
            preparedStatement.setInt(4, ordinazione_bar.getQuantita());
            preparedStatement.setInt(5, ordinazione_bar.getId_prodotto());
            // INSERT INTO ordinazionebar VALUES ('2022/05/05',1,1,1,1);
            result = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println(e);
            result = false;
            System.out.println("nope");
        }
        return result;
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
