package com.unicam.cs.ids.casotto;

import java.sql.Date;


public class Ordinazione_Bar {
    private Date data_ordinazione;
    private int quantita;
    private static int id_ordinazione;
    private int id_ombrellone;
    private int id_prodotto;
    public Cliente c;

    public void ordinazione_Prodotto(int idProdotto, int quantita) {
    }

    public int incremento(int id_ordinazione) {

        this.id_ordinazione = id_ordinazione + 1;
        return this.id_ordinazione;
    }

    private void decrementoProdotto(Prodotti_Bar id_prodotto) {
        throw new UnsupportedOperationException();
    }

    public Ordinazione_Bar(Date data_ordinazione, int quantita, int id_ordinazione, int id_ombrellone, int id_prodotto) {
        this.data_ordinazione = data_ordinazione;
        this.quantita = quantita;
        this.id_ordinazione = incremento(id_ordinazione);
        this.id_ombrellone = id_ombrellone;
        this.id_prodotto = id_prodotto;
    }

    public int getId_prodotto() {
        return id_prodotto;
    }

    public void setId_prodotto(int id_prodotto) {
        this.id_prodotto = id_prodotto + 1;
    }

    public Date getData_ordinazione() {
        return data_ordinazione;
    }

    public Date setData_ordinazione(Date data_ordinazione) {
        this.data_ordinazione = data_ordinazione;
        return this.data_ordinazione;
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

    public int setId_ordinazione(int id_ordinazione) {
        this.id_ordinazione = id_ordinazione;
        return id_ordinazione;
    }

    public int getId_ombrellone() {
        return id_ombrellone;
    }

    public void setId_ombrellone(int id_ombrellone) {
        this.id_ombrellone = id_ombrellone;
    }
}