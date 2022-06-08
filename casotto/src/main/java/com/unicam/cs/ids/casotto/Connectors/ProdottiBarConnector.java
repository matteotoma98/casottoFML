package com.unicam.cs.ids.casotto.Connectors;

import com.unicam.cs.ids.casotto.OpenApp;
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
            System.err.println("errore: Empty result");

        return resultList;
    }

    public boolean aggiungiProdottoBar(int id_prodotto, double prezzo, String nome, int quantita, int tempo_preparazione) {
        boolean risultato = false;
        boolean result = false;
        ResultSet result2;
        boolean resultattr = false;
        boolean prodotto_trovato = false;
        int id_ombr = 0;
        boolean result3 = false;
        String nome_prod = "";
        try {
            result2 = connection.createStatement().executeQuery("SELECT id_prodotto,nome_prodotto FROM prodottibar WHERE id_prodotto='" + id_prodotto + "'");

            if (result2.next() == false) {
                System.out.println("L'id del prodotto non esiste, verrà quindi aggiunto");
                prodotto_trovato = false;
            } else {
                do {
                    result2.getInt("id_prodotto");
                    nome_prod = result2.getString("nome_prodotto");
                    prodotto_trovato = true;
                    System.err.println("errore: L'id del prodotto esiste già, inseriscine un'altro.");
                } while (result2.next());
            }
            if (!prodotto_trovato) {
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO prodottibar VALUES (?,?,?,?,?)");
                    preparedStatement.setInt(1, id_prodotto);
                    preparedStatement.setString(2, nome);
                    preparedStatement.setDouble(3, prezzo);
                    preparedStatement.setInt(4, quantita);
                    preparedStatement.setInt(5, tempo_preparazione);
                    result3 = preparedStatement.executeUpdate() > 0;
                    if (result3) {
                        System.out.println("Prodotto aggiunto al bar.");
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

    public int getMax() throws Exception {
        ResultSet result2;
        int max = 0;
        result2 = connection.createStatement().executeQuery("SELECT MAX(id_prodotto) FROM prodottibar");
        if (result2.next()) {
            System.out.println("");
            max = result2.getInt(1);
        }
        return max;
    }

    public boolean rimuoviProdottoBar(int id_prodotto) {
        boolean risultato = false;
        boolean result = false;
        ResultSet result2;
        boolean resultattr = false;
        boolean prodotto_trovato = false;
        int id_ombr = 0;
        boolean result3 = false;
        String nome_prod = "";
        try {
            result2 = connection.createStatement().executeQuery("SELECT id_prodotto,nome_prodotto FROM prodottibar WHERE id_prodotto='" + id_prodotto + "'");

            if (result2.next() == false) {
                System.err.println("errore: L'id del prodotto non esiste, inseriscine un'altro.");
                prodotto_trovato = false;
            } else {
                do {
                    result2.getInt("id_prodotto");
                    nome_prod = result2.getString("nome_prodotto");
                    prodotto_trovato = true;
                } while (result2.next());
            }
            if (prodotto_trovato) {
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM prodottibar WHERE id_prodotto= '" + id_prodotto + "'");
                    result3 = preparedStatement.executeUpdate() > 0;
                    if (result3) {
                        System.out.println("Prodotto " + id_prodotto + " e nome " + nome_prod + " rimosso dal bar.");
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
                System.err.println("errore: L'id del prodotto non esiste, inseriscine un'altro.");
                prodotto_trovato = false;
            } else {
                do {
                    result2.getInt("id_prodotto");
                    nome = result2.getString("nome_prodotto");
                    prodotto_trovato = true;
                } while (result2.next());
            }
            if (prodotto_trovato) {
                try {
                    PreparedStatement preparedStatement3 = connection.prepareStatement("UPDATE prodottibar SET prezzo='" + prezzo_prodotto + "'WHERE id_prodotto='" + id_prodotto + "'");
                    result3 = preparedStatement3.executeUpdate() > 0;
                    if (result3) {
                        System.out.println("Prezzo del prodotto " + nome + " e id " + id_prodotto + " aggiornato.");
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


    public void getQuantitaProdotto(int id_prodotto, int quantita) {
        ResultSet result2;
        PreparedStatement preparedStatement3;
      try{
          result2 = connection.createStatement().executeQuery("SELECT id_prodotto, quantita FROM prodottibar WHERE id_prodotto ='" + id_prodotto + "'  AND quantita >='" + quantita + "'");

        if (result2.next())
            //System.out.println("");
            connection.prepareStatement("UPDATE prodottibar SET quantita = quantita -'" + quantita + "'WHERE id_prodotto='" + id_prodotto + "'");
        else {
            System.err.println("Siamo spiacenti! Non abbiamo la quantità necessaria per il prodotto che vuoi acquistare, riprova diminuendo la quantità del " +
                    "prodotto che desideri");
            OpenApp o = new OpenApp();
            o.Open();
        }
      }
      catch (Exception e){
          System.out.println(e);
      }
    }
}
