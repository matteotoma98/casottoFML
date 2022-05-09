package com.unicam.cs.ids.casotto;

import com.unicam.cs.ids.casotto.Connectors.PagamentoBarConnector;

import java.util.Date;

public class PagamentoBar {
    private String tipologia_pagamento;
    private int id_ordinazione;
    private int id_ombrellone;
    private Date data_pagamento;
    public Ordinazione_Bar ordinazioneBar;
    //  public Prenotazione_Spiaggia prenotazioneSpiaggia;
    public String dati_carta;

    public String toString() {
        throw new UnsupportedOperationException();
    }


    public void inserimentoDatiCarta(String dati_carta) {
        // throw new UnsupportedOperationException();
    }

    public void sceltaMetodo(String tipologia_pagamento, int id_ordinazione, int id_ombrellone, Date data_pagamento) {
        PagamentoBarConnector pc = new PagamentoBarConnector();
        pc.aggiornaListaPagamenti(tipologia_pagamento, id_ordinazione, id_ombrellone, (java.sql.Date) data_pagamento);
    }
    //tostring
}