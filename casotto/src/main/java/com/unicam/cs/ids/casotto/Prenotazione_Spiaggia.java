package com.unicam.cs.ids.casotto;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Prenotazione_Spiaggia {
    private GregorianCalendar data_finePrenotazione;
    private GregorianCalendar data_inizioPrenotazione;
    private int num_fila_ombrellone;
    private int id_prenotazione;
    private Ombrellone ombrellone;
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

    public void cancellaPrenotazione(Data data_inizio_prenotazione, Data data_fine_prenotazione) {
        throw new UnsupportedOperationException();
    }

    public void addPrenotazione(String data_inizioPrenotazione, String data_finePrenotazione) {
        //throw new UnsupportedOperationException();
    }


    public void notificaAddettoSpiaggia(int num_fila_ombrellone, int num_lettini, int num_ombrelloni) {
        /*
         VEDERE PATTERN OBSERVER
         */
        throw new UnsupportedOperationException();
    }

    public void sceltaOmbrellone(Ombrellone o) {
        throw new UnsupportedOperationException();
    }

    /*
    public void aggiornaPrezzo(int id_ombrellone, int num_fila_ombrellone, Date data_inizio, Date data_fine ){
        throw new UnsupportedOperationException();
    } */


    public void sceltaFasciaOraria(String fasciaOraria) {
        if (fasciaOraria.equals(FasciaOraria.MATTINA)){
            fasciaOraria= "Mattina";
        }
        if (fasciaOraria.equals(FasciaOraria.POMERIGGIO)){
            fasciaOraria= "Pomeriggio";
        }
        if (fasciaOraria.equals(FasciaOraria.GIORNATA_INTERA)){
            fasciaOraria= "Giornata Intera";
        }
        throw new UnsupportedOperationException();
    }

    public Prenotazione_Spiaggia(GregorianCalendar data_finePrenotazione, GregorianCalendar datainizioPrenotazione, int num_fila_ombrellone, int id_prenotazione) {
        this.data_finePrenotazione = data_finePrenotazione;
        this.data_inizioPrenotazione = datainizioPrenotazione;
        this.num_fila_ombrellone = num_fila_ombrellone;
        this.id_prenotazione = id_prenotazione;
    }

    public Prenotazione_Spiaggia() {
        this.data_finePrenotazione = data_finePrenotazione;
        this.data_inizioPrenotazione = data_inizioPrenotazione;
        this.num_fila_ombrellone = num_fila_ombrellone;
        this.id_prenotazione = id_prenotazione;
    }

    public GregorianCalendar getDatainizioPrenotazione() {
        return data_inizioPrenotazione;
    }

    public void setDatainizioPrenotazione(GregorianCalendar datainizioPrenotazione) {
        this.data_inizioPrenotazione = datainizioPrenotazione;
    }


    public GregorianCalendar getData_finePrenotazione() {
        return data_finePrenotazione;
    }

    public void setData_finePrenotazione(GregorianCalendar data_finePrenotazione) {
        this.data_finePrenotazione = data_finePrenotazione;
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