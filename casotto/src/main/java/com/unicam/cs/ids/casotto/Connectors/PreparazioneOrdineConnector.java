package com.unicam.cs.ids.casotto.Connectors;

import java.sql.Connection;

public class PreparazioneOrdineConnector {
    Connection connection;

    public PreparazioneOrdineConnector() {
        try {
            connection = DBConnector.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void statoOrdine(int id_ordine) {
        //elabora col timer di java il tempo per preparare l'ordine, aggiorna la tabella preparazione ordine e stampa il messaggio
        // "l'addetto alla spiaggia sta prendendo il tuo ordine e te lo consegnerà"


    }

}
