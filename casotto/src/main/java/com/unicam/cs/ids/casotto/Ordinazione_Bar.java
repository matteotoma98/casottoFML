package com.unicam.cs.ids.casotto;

import java.util.ArrayList;
import java.util.Date;


public class Ordinazione_Bar {
    private Date data_ordinazione;
    private int quantita;
    private int id_ordinazione;
    private int id_ombrellone;
    public Cliente effettua;
    //public ArrayList<Preparazione_Ordine> effettua = new ArrayList<Preparazione_Ordine>();

    public Ordinazione_Bar() {
        throw new UnsupportedOperationException();
    }

    public void Ordinazione_Prodotto(String NomeProdotto, int Quantita) {
        throw new UnsupportedOperationException();
    }

    private void decrementoProdotto() {
        throw new UnsupportedOperationException();
    }

    public Ordinazione_Bar(Date data_ordinazione, int quantita, int id_ordinazione, int id_ombrellone) {
        this.data_ordinazione = data_ordinazione;
        this.quantita = quantita;
        this.id_ordinazione = id_ordinazione;
        this.id_ombrellone = id_ombrellone;
    }

    public Date getData_ordinazione() {
        return data_ordinazione;
    }

    public void setData_ordinazione(Date data_ordinazione) {
        this.data_ordinazione = data_ordinazione;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public int getId_ordinazione() {
        return id_ordinazione;
    }

    public void setId_ordinazione(int id_ordinazione) {
        this.id_ordinazione = id_ordinazione;
    }

    public int getId_ombrellone() {
        return id_ombrellone;
    }

    public void setId_ombrellone(int id_ombrellone) {
        this.id_ombrellone = id_ombrellone;
    }
}