package com.unicam.cs.ids.casotto.serviziogestione;

import com.unicam.cs.ids.casotto.serviziospiaggia.PrenotazioneSpiaggia;

public class Chalet {
    public PrenotazioneSpiaggia unnamed_Prenotazione_Spiaggia_;
    private int quantita_ombrelloni;
    private int quantita_lettini;
    private int quantita_ombrelloni_disponibili;
    private int quantita_lettini_disponibili;
    private int id_ombrellone;

    public Chalet(int quantita_ombrelloni, int quantita_lettini, int quantita_ombrelloni_disponibili, int quantita_lettini_disponibili) {
        this.quantita_ombrelloni = quantita_ombrelloni;
        this.quantita_lettini = quantita_lettini;
        this.quantita_ombrelloni_disponibili = quantita_ombrelloni_disponibili;
        this.quantita_lettini_disponibili = quantita_lettini_disponibili;
    }


    public Chalet() {
        this.quantita_ombrelloni = quantita_ombrelloni;
        this.quantita_lettini = quantita_lettini;
        this.quantita_ombrelloni_disponibili = quantita_ombrelloni_disponibili;
        this.quantita_lettini_disponibili = quantita_lettini_disponibili;
    }

    public void decrementaQuantitaLettiniDisponibili(int num_lettini) {

        this.quantita_lettini = this.quantita_lettini - num_lettini;
        //	throw new UnsupportedOperationException();
    }

    public void incrementaQuantitaLettiniDisponibili(int num_lettini) {
        this.quantita_lettini = this.quantita_lettini + num_lettini;
        //throw new UnsupportedOperationException();
    }

    public void decrementaQuantitaOmbrelloniDisponibili(int num_ombrelloni) {
        this.quantita_ombrelloni = this.quantita_ombrelloni - num_ombrelloni;
        //throw new UnsupportedOperationException();
    }

    public void incrementaQuantitaOmbrelloniDisponibili(int num_ombrelloni) {
        this.quantita_ombrelloni = this.quantita_ombrelloni + num_ombrelloni;
        //throw new UnsupportedOperationException();
    }

    public int getQuantita_ombrelloni() {
        return quantita_ombrelloni;
    }

    public void setQuantita_ombrelloni(int quantita_ombrelloni) {
        this.quantita_ombrelloni = quantita_ombrelloni;
    }

    public int getQuantita_lettini() {
        return quantita_lettini;
    }

    public void setQuantita_lettini(int quantita_lettini) {
        this.quantita_lettini = quantita_lettini;
    }

    public int getQuantita_ombrelloni_disponibili() {
        return quantita_ombrelloni_disponibili;
    }

    public void setQuantita_ombrelloni_disponibili(int quantita_ombrelloni_disponibili) {
        this.quantita_ombrelloni_disponibili = quantita_ombrelloni_disponibili;
    }

    public int getQuantita_lettini_disponibili() {
        return quantita_lettini_disponibili;
    }

    public void setQuantita_lettini_disponibili(int quantita_lettini_disponibili) {
        this.quantita_lettini_disponibili = quantita_lettini_disponibili;
    }
}