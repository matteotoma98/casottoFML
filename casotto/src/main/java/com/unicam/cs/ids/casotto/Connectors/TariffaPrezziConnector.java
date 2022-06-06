package com.unicam.cs.ids.casotto.Connectors;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TariffaPrezziConnector {
    Connection connection;

    public TariffaPrezziConnector() {
        try {
            connection = DBConnector.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        } //add exception here
    }

    public boolean updatePolitichePrezzi(int id_fila, double prezzo_ombr_mg, double prezzo_ombr_gi) {
        boolean risultato = false;
        boolean result = false;
        ResultSet result2;
        boolean resultattr = false;
        boolean fila_trovata = false;
        int id_ombr = 0;
        boolean result3 = false;
        String tipologia = "";
        try {
            result2 = connection.createStatement().executeQuery("SELECT num_fila_ombrellone FROM ombrellone WHERE num_fila_ombrellone='" + id_fila + "'");

            if (result2.next() == false) {
                System.err.println("errore: La fila dell'ombrellone non esiste, inserirne una tra 1 e 15");
                fila_trovata = false;
            } else {
                do {
                    result2.getInt("num_fila_ombrellone");
                    fila_trovata = true;
                } while (result2.next());
            }
            if (fila_trovata) {
                try {
                    PreparedStatement preparedStatement3 = connection.prepareStatement("UPDATE tariffaprezzi SET prezzoOmbrelloneMG='" + prezzo_ombr_mg + "', prezzoOmbrelloneGI='" + prezzo_ombr_gi + "'WHERE num_fila_ombrellone= '" + id_fila + "'");
                    result3 = preparedStatement3.executeUpdate() > 0;
                    if (result3) {
                        System.out.println("Prezzi per la fila " + id_fila + " aggiornati.");
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

    public boolean cambiaPrezzoLettini(double prezzo) {
        boolean risultato = false;
        try {
            PreparedStatement preparedStatement3 = connection.prepareStatement("UPDATE tariffaprezzi SET prezzo_lettino='" + prezzo + "'");
            risultato = preparedStatement3.executeUpdate() > 0;
            if (risultato) {
                System.out.println("Prezzi dei lettini aggiornati.");
                risultato = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return risultato;
    }
}
