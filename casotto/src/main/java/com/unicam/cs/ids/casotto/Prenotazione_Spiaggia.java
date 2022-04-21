package com.unicam.cs.ids.casotto;

import java.util.ArrayList;
import java.util.Date;

public class Prenotazione_Spiaggia {
    private Date data_finePrenotazione;
    private Date datainizioPrenotazione;
    private int num_fila_ombrellone;
    private int id_prenotazione;
    public Chalet unnamed_Chalet_;
    public Cliente effettua;
    public ArrayList<Ombrellone> riserva = new ArrayList<Ombrellone>();

    public ArrayList<Ombrellone> getOmbrellone() {
        throw new UnsupportedOperationException();
    }

    public boolean addOmbrellone() {
        throw new UnsupportedOperationException();
    }

    public ArrayList<Lettino> getLettino() {
        throw new UnsupportedOperationException();
    }

    public boolean addLettino() {
        throw new UnsupportedOperationException();
    }

    public void getOmbrelloniDisponibili(Object aData_inizioPrenotazione, Object aData_finePrenotazione) {
        throw new UnsupportedOperationException();
    }

    public void getLettiniDisponibili(Object aData_InizioPrenotazione, Object aData_finePrenotazione) {
        throw new UnsupportedOperationException();
    }

    public void cancellaPrenotazione(Object aId_prenotazione) {
        throw new UnsupportedOperationException();
    }

    public void addPrenotazione(Object aData_inizioPrenotazione, Object aData_finePrenotazione) {
        throw new UnsupportedOperationException();
    }

    public void notificaAddettoSpiaggia(Object aNum_fila_ombrellone, Object aNum_lettini, Object aNum_ombrelloni) {
        throw new UnsupportedOperationException();
    }

    public ArrayList<Ombrellone> scegliOmbrellone() {
        throw new UnsupportedOperationException();
    }

    public void sceltaFasciaOraria() {
        throw new UnsupportedOperationException();
    }

    public Prenotazione_Spiaggia(Date data_finePrenotazione, Date datainizioPrenotazione, int num_fila_ombrellone, int id_prenotazione) {
        this.data_finePrenotazione = data_finePrenotazione;
        this.datainizioPrenotazione = datainizioPrenotazione;
        this.num_fila_ombrellone = num_fila_ombrellone;
        this.id_prenotazione = id_prenotazione;
    }

    public Date getData_finePrenotazione() {
        return data_finePrenotazione;
    }

    public void setData_finePrenotazione(Date data_finePrenotazione) {
        this.data_finePrenotazione = data_finePrenotazione;
    }

    public Date getDatainizioPrenotazione() {
        return datainizioPrenotazione;
    }

    public void setDatainizioPrenotazione(Date datainizioPrenotazione) {
        this.datainizioPrenotazione = datainizioPrenotazione;
    }

    public int getNum_fila_ombrellone() {
        return num_fila_ombrellone;
    }

    public void setNum_fila_ombrellone(int num_fila_ombrellone) {
        this.num_fila_ombrellone = num_fila_ombrellone;
    }

    public int getId_prenotazione() {
        return id_prenotazione;
    }

    public void setId_prenotazione(int id_prenotazione) {
        this.id_prenotazione = id_prenotazione;
    }
}