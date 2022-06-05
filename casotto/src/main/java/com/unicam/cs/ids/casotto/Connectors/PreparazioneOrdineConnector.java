package com.unicam.cs.ids.casotto.Connectors;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreparazioneOrdineConnector {
    Connection connection;

    public PreparazioneOrdineConnector() {
        try {
            connection = DBConnector.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean addOrdine(int id_ordinazione) {
        //elabora col timer di java il tempo per preparare l'ordine, aggiorna la tabella preparazione ordine e stampa il messaggio
        // "l'addetto alla spiaggia sta prendendo il tuo ordine e te lo consegnerà"
        ResultSet result3;
        int id = 0;
        boolean result = false;
        boolean id_trovato;
        boolean risultato = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO preparazioneordine VALUES (?,?)");
            preparedStatement.setBoolean(1, false);
            preparedStatement.setInt(2, id_ordinazione);
            result = preparedStatement.executeUpdate() > 0;
            if (result) {
                System.out.println("Ordine aggiunto in coda");
                risultato = true;
                                //decrementare la quantità dell'attrezzatura disponibile dalla tabella attrezzatura
            } else System.out.println("errore nell'inserire l'orine");
        } catch (Exception e) {
            System.out.println(e);
        }
        return risultato;
    }

    public boolean OrdinePronto(int id_ordinazione) {
        //elabora col timer di java il tempo per preparare l'ordine, aggiorna la tabella preparazione ordine e stampa il messaggio
        // "l'addetto alla spiaggia sta prendendo il tuo ordine e te lo consegnerà"
        ResultSet result3;
        int id = 0;
        boolean result = false;
        boolean id_trovato=false;
        try {
            /* result3 = connection.createStatement().executeQuery("SELECT id_ordinazione FROM preparazioneordine WHERE id_ordinazione='" + id_ordinazione + "'");
            while (result3.next()) {
                id= result3.getInt("id_ordinazione");
               // if (id==0) attivitaesistente = false;
                // else {
                    id_trovato = true;
                    System.out.println("esiste già quest'attività, inserirne un'altra diversa.");
                } */

            boolean result4 = false;
            PreparedStatement preparedStatement1 = connection.prepareStatement("UPDATE preparazioneordine set ordine_pronto = true WHERE id_ordinazione='"+id_ordinazione+"'");
            //preparedStatement.setInt(1,lettini);
            result4 = preparedStatement1.executeUpdate() > 0;
            if (result4) System.out.println("Ordine pronto!");
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;

    }
}
