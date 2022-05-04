package com.unicam.cs.ids.casotto.Connectors;

import com.unicam.cs.ids.casotto.Prodotti_Bar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Prodotti_BarConnector {

    Connection connection;

    public Prodotti_BarConnector() {
        try {
            connection = DBConnector.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        } //add exception here
    }

    public List<Prodotti_Bar> getProducts() {
        ResultSet result;
        List<Prodotti_Bar> resultList = new ArrayList<Prodotti_Bar>();
        try {
            result = connection.createStatement().executeQuery("SELECT * FROM prodottibar");

            while (result.next()) {
                resultList.add(convertiRisultatoInProdotto(result));
            }
        } catch (Exception e) {
            System.out.println(e);
        } //add exception here

        //error checking
        if (resultList.isEmpty())
            System.out.println("Empty result");

        return resultList;

    }


    private Prodotti_Bar convertiRisultatoInProdotto(ResultSet result) throws SQLException {
        double prezzo = result.getInt("prezzo");
        int id_prodotto = result.getInt("id_prodotto");
        int quantita = result.getInt("quantita");
        String nome_prodotto = result.getString("nome_prodotto");
        return new Prodotti_Bar(prezzo, id_prodotto, quantita, nome_prodotto);
    }


    public double getTotaleOrdine(String id, int quantita) {
        ResultSet result;
        Prodotti_Bar prodotto = new Prodotti_Bar();
        try {
            result = connection.createStatement().executeQuery("SELECT * FROM prodotti WHERE id = " + id);

            while (result.next()) {
                prodotto = convertiRisultatoInProdotto(result);
            }
        } catch (Exception e) {
            System.out.println(e); }
        //add exception here
        return prodotto.getPrezzo()*quantita;
    }

    /*
    public boolean updateProdotto(Prodotto prodotto) {
        boolean result = true;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update products set nome = ?, descrizione = ?, quantita = ?, fornitore = ?, marca = ?, prezzo = ? where id = ?");
            preparedStatement.setString(1, prodotto.getNome());
            preparedStatement.setString(2, prodotto.getDescrizione());
            preparedStatement.setInt(3, prodotto.getQuantita());
            preparedStatement.setString(4, prodotto.getFornitore());
            preparedStatement.setString(5, prodotto.getMarca());
            preparedStatement.setDouble(6, prodotto.getPrezzo());
            preparedStatement.setString(7, prodotto.getId_prodotto());
            result = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
                    System.out.println(e);

            result = false;
        }
        return result;
    }

    public boolean deleteProdotto(String id)
    {
        ResultSet result;
        List<Prodotto> resultList = new ArrayList<Prodotto>();
        try {
            result = connection.createStatement().executeQuery("DELETE FROM products WHERE id = " + id);
        } catch (Exception e)
        { System.out.println(e); } //add exception here

        return true;
    }



    public Prodotto getProduct(String id)
    {
        ResultSet result;
        Prodotto prodotto = null;
        try {
            result = connection.createStatement().executeQuery("SELECT * FROM products WHERE id = " + id);

            while (result.next()) {
                prodotto = convertiRisultatoInProdotto(result);
            }
        } catch (Exception e)
        { System.out.println(e); } //add exception here
        return prodotto;

    }

    public boolean addProdotto(Prodotto prodotto) {
        boolean result;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO products VALUES ( ?,?,?,?,?,?,?)");
            preparedStatement.setString(1, prodotto.getId_prodotto());
            preparedStatement.setString(2, prodotto.getNome());
            preparedStatement.setString(3, prodotto.getDescrizione());
            preparedStatement.setInt(4, prodotto.getQuantita());
            preparedStatement.setString(5, prodotto.getFornitore());
            preparedStatement.setString(6, prodotto.getMarca());
            preparedStatement.setDouble(7, prodotto.getPrezzo());

            result = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            result = false;
        }
        return result;
    }


    */

}
