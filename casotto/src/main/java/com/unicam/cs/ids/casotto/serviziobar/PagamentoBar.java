package com.unicam.cs.ids.casotto.serviziobar;

import com.unicam.cs.ids.casotto.Connectors.PagamentoBarConnector;
import com.unicam.cs.ids.casotto.utilities.NotifyOrder;

import java.util.Date;

public class PagamentoBar {
    private String tipologia_pagamento;
    private int id_ordinazione;
    private int id_ombrellone;
    private Date data_pagamento;
    public OrdinazioneBar ordinazioneBar;
    //  public Prenotazione_Spiaggia prenotazioneSpiaggia;
    public String dati_carta;


    public String toString() {
        throw new UnsupportedOperationException();
    }


    public void inserimentoDatiCarta(String dati_carta) {
        // throw new UnsupportedOperationException();
    }

    public boolean sceltaMetodo(String tipologia_pagamento, int id_ordinazione, int id_ombrellone, Date data_pagamento) {
        PagamentoBarConnector pc = new PagamentoBarConnector();
        boolean risultato = pc.aggiornaListaPagamenti(tipologia_pagamento, id_ordinazione, id_ombrellone, (java.sql.Date) data_pagamento);
        if (risultato) {
            NotifyOrder notifyOrder = new NotifyOrder("Addetto Bar");

            return risultato;
        } else return false;
    }
    //tostring
}