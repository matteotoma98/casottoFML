package com.unicam.cs.ids.casotto;

import java.util.Date;

public class Pagamento {
    private String tipologia_pagamento;
    private int id_prenotazione;
    private int id_ordinazione;
    private int id_ombrellone;
    private Date data_pagamento;
    public Ordinazione_Bar ordinazioneBar;
    public Prenotazione_Spiaggia prenotazioneSpiaggia;
    public String dati_carta;

    public String toString() {
        throw new UnsupportedOperationException();
    }

    public void sceltaMetodo(String tipologia_pagamento) {
        //throw new UnsupportedOperationException();
    }

    public void inserimentoDatiCarta(String dati_carta) {
       // throw new UnsupportedOperationException();
    }
}