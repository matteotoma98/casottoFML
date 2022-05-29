package com.unicam.cs.ids.casotto.Connectors;

import com.unicam.cs.ids.casotto.serviziobar.ProdottiBar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdottiBarConnector {

    Connection connection;

    public ProdottiBarConnector() {
        try {
            connection = DBConnector.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        } //add exception here
    }

    public List<ProdottiBar> getProducts() {
        ResultSet result;
        List<ProdottiBar> resultList = new ArrayList<ProdottiBar>();
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

    public boolean updateProdottiBar(double prezzo_prodotto, int id_prodotto) {
        boolean risultato = false;
        boolean result = false;
        ResultSet result2;
        boolean resultattr = false;
        boolean prodotto_trovato = false;
        int id_ombr = 0;
        boolean result3 = false;
        String nome = "";
        try {
            result2 = connection.createStatement().executeQuery("SELECT id_prodotto,nome_prodotto FROM prodottibar WHERE id_prodotto='" + id_prodotto + "'");

            if (result2.next() == false) {
                System.out.println("L'id del prodotto non esiste, inserirne uno di quelli della lista.");
                prodotto_trovato = false;
            } else {
                do {
                    result2.getInt("id_prodotto");
                  nome=  result2.getString("nome_prodotto");
                    prodotto_trovato = true;
                } while (result2.next());
            }
            if (prodotto_trovato) {
                try {
                    PreparedStatement preparedStatement3 = connection.prepareStatement("UPDATE prodottibar SET prezzo='" + prezzo_prodotto + "'WHERE id_prodotto='"+id_prodotto+"'");
                    result3 = preparedStatement3.executeUpdate() > 0;
                    if (result3) {
                        System.out.println("Prezzo del prodotto "+nome+" e id " +id_prodotto+" aggiornato.");
                        risultato = true;
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (
                Exception e) {
            System.out.println(e);
        }
        return risultato;

    }
    /*
    public List<Prodotti_Bar> assegnaTempoPreparazione() {
        ResultSet result;
        List<Prodotti_Bar> resultList = new ArrayList<Prodotti_Bar>();
        Map<Integer,Integer> m = new HashMap<>();
        try {
            result = connection.createStatement().executeQuery("SELECT id_prodotti FROM prodottibar");

            while (result.next()) {
                m.put( result.getInt("id_prodotto"), (int) Math.random());
            }
            for (Integer key: m.keySet()){
                System.out.println("Id:"+key +", tempo di preparazione: "+m.get(key));
            }

        } catch (Exception e) {
            System.out.println(e);
        } //add exception here

        //error checking
        if (resultList.isEmpty())
            System.out.println("Empty result");

        return resultList;
    }
    */

    //public int TempoTotale(//lista di tutti i prodotti ordinati)
    public int TempoTotale(int id, int qta) {
        int tempo_totale = 0;
        ResultSet result;
        try {
            result = connection.createStatement().executeQuery("SELECT tempo_preparazione FROM prodottibar WHERE id_prodotto='" + id + "'");

            while (result.next()) {
                tempo_totale = tempo_totale + (result.getInt("tempo_preparazione") * qta);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return tempo_totale;
    }

    private ProdottiBar convertiRisultatoInProdotto(ResultSet result) throws SQLException {
        int id_prodotto = result.getInt("id_prodotto");
        String nome_prodotto = result.getString("nome_prodotto");
        double prezzo = result.getInt("prezzo");
        int quantita = result.getInt("quantita");

        return new ProdottiBar(prezzo, id_prodotto, quantita, nome_prodotto);
    }


    public double getTotaleOrdine(String id, int quantita) {
        ResultSet result;
        ProdottiBar prodotto = new ProdottiBar();
        try {
            result = connection.createStatement().executeQuery("SELECT * FROM prodotti WHERE id = " + id);

            while (result.next()) {
                prodotto = convertiRisultatoInProdotto(result);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        //add exception here
        return prodotto.getPrezzo() * quantita;
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
            preparedStatement.setDouble(7, prodotto.getPrezzo());

            result = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            result = false;
        }
        return result;
    }
    */

}
