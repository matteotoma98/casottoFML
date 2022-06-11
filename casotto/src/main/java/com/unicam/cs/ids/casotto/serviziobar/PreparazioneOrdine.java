package com.unicam.cs.ids.casotto.serviziobar;

import com.unicam.cs.ids.casotto.serviziospiaggia.AddettoSpiaggia;
import com.unicam.cs.ids.casotto.utilities.Scontrino;

import java.util.ArrayList;

public class PreparazioneOrdine {
    public ArrayList<ProdottiBar> utilizza = new ArrayList<ProdottiBar>();
    public AddettoBar prepara;
    public ArrayList<AddettoSpiaggia> consegna = new ArrayList<AddettoSpiaggia>();
    private boolean ordinePronto;
    private ArrayList<Scontrino> scontrini;
    private int id_ordinazione;

    public PreparazioneOrdine(boolean ordinePronto, ArrayList<Scontrino> scontrini, int id_ordinazione) {
        this.ordinePronto = ordinePronto;
        this.scontrini = scontrini;
        this.id_ordinazione = id_ordinazione;
    }

    public boolean StampaScontrino() {
        throw new UnsupportedOperationException();
    }

    public void AddProdotto(ProdottiBar p, int id_ordinazione) {
        throw new UnsupportedOperationException();
    }

    public boolean checkDisponibilta() {
        throw new UnsupportedOperationException();
    }

    public void aggiornaTotale(double prezzo) {
        throw new UnsupportedOperationException();
    }

    public boolean isOrdinePronto() {
        return ordinePronto;
    }

    public void setOrdinePronto(boolean ordinePronto) {
        this.ordinePronto = ordinePronto;
    }

    public ArrayList<Scontrino> getScontrini() {
        return scontrini;
    }

    public void setScontrini(ArrayList<Scontrino> scontrini) {
        this.scontrini = scontrini;
    }

    public int getId_ordinazione() {
        return id_ordinazione;
    }

    public void setId_ordinazione(int id_ordinazione) {
        this.id_ordinazione = id_ordinazione;
    }
}