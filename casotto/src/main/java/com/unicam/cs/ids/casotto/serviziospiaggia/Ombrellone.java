package com.unicam.cs.ids.casotto.serviziospiaggia;

import com.unicam.cs.ids.casotto.model.Tipologia;
import com.unicam.cs.ids.casotto.serviziogestione.TariffaPrezzi;

import java.util.ArrayList;
import java.util.Date;

public class Ombrellone {
    public int id_ombrellone;
    private double prezzo;
    private TariffaPrezzi tariffaPrezzi;
    private Tipologia tipologia;
    private int num_fila_ombrellone;
    public PrenotazioneSpiaggia riserva;
    public ArrayList<TariffaPrezzi> appartiene = new ArrayList<TariffaPrezzi>();


    public void getTariffaPrezzi(Object aData_InizioPrenotazione, Object aData_finePrenotazione) {
        throw new UnsupportedOperationException();
    }

    public Ombrellone() {
        this.id_ombrellone = id_ombrellone;
        this.prezzo = prezzo;
        this.tariffaPrezzi = tariffaPrezzi;
        this.tipologia = tipologia;
        this.num_fila_ombrellone = num_fila_ombrellone;
    }

    public Ombrellone(int id_ombrellone, double prezzo, boolean disponibilita, TariffaPrezzi tariffaPrezzi, String tipologia, int num_fila_ombrellone) {
        this.id_ombrellone = id_ombrellone;
        this.prezzo = prezzo;
        //this.disponibilita = disponibilita;
        this.tariffaPrezzi = tariffaPrezzi;
        this.tipologia = Tipologia.valueOf(tipologia);
        this.num_fila_ombrellone = num_fila_ombrellone;
    }

    public int getId_ombrellone() {
        return id_ombrellone;
    }

    public void setId_ombrellone(int id_ombrellone) {
        this.id_ombrellone = id_ombrellone;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    /*public boolean isDisponibilita() {
        return disponibilita;
    }

    public void setDisponibilita(boolean disponibilita) {
        this.disponibilita = disponibilita;
    }*/

    public TariffaPrezzi getTariffaPrezzi(Date data_inizio_prenotazione, Date data_fine_prenotazione) {
        return tariffaPrezzi;
    }

    public void setTariffaPrezzi(TariffaPrezzi tariffaPrezzi) {
        this.tariffaPrezzi = tariffaPrezzi;
    }

    public Tipologia getTipologia() {
        return tipologia;
    }

    public void setTipologia(Tipologia tipologia) {
        this.tipologia = tipologia;
    }

    public int getNum_fila_ombrellone() {
        return num_fila_ombrellone;
    }

    public void setNum_fila_ombrellone(int num_fila_ombrellone) {
        this.num_fila_ombrellone = num_fila_ombrellone;
    }
}