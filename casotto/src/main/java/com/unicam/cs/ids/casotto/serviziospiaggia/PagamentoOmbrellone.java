package com.unicam.cs.ids.casotto.serviziospiaggia;

import com.unicam.cs.ids.casotto.Connectors.PagamentoOmbrelloneConnector;
import com.unicam.cs.ids.casotto.serviziobar.OrdinazioneBar;

import java.util.Date;

public class PagamentoOmbrellone {

    private String tipologia_pagamento;
    private int id_prenotazione;
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

    public void sceltaMetodo(String tipologia_pagamento, int id_prenotazione, int id_ombrellone, Date data_pagamento) {
        PagamentoOmbrelloneConnector po = new PagamentoOmbrelloneConnector();
        po.aggiornaListaPagamenti(tipologia_pagamento, id_prenotazione, id_ombrellone, (java.sql.Date) data_pagamento);
    }
    //tostring

}
