package com.unicam.cs.ids.casotto;

import com.unicam.cs.ids.casotto.Connectors.PrenotazioneSpiaggiaConnector;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.util.ArrayList;

public class Prenotazione_Spiaggia {
    private Date data_finePrenotazione;
    private Date data_inizioPrenotazione;
    private int num_fila_ombrellone;
    private int id_prenotazione;
    private int id_ombrellone;
    private static int prenotazione_count = 0;
    private int lettini = 0;
    private String email = "";
    PrenotazioneSpiaggiaConnector prenotazioneSpiaggiaConnector = new PrenotazioneSpiaggiaConnector();

    public Date getData_inizioPrenotazione() {
        return data_inizioPrenotazione;
    }

    public void setData_inizioPrenotazione(Date data_inizioPrenotazione) {
        this.data_inizioPrenotazione = data_inizioPrenotazione;
    }

    public int getId_ombrellone() {
        return id_ombrellone;
    }

    public void setId_ombrellone(int id_ombrellone) {
        this.id_ombrellone = id_ombrellone;
    }

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
    public void listaPrenotazioni(String email) {
        PrenotazioneSpiaggiaConnector prenotazioneSpiaggiaConnector= new PrenotazioneSpiaggiaConnector();
        prenotazioneSpiaggiaConnector.listaPrenotazioni(email);
    }
    public void cancellaPrenotazione(int id_prenotazione) {
        PrenotazioneSpiaggiaConnector prenotazioneSpiaggiaConnector= new PrenotazioneSpiaggiaConnector();
        prenotazioneSpiaggiaConnector.cancellazionePrenotazione(id_prenotazione);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int incremento_prenotazione(int prenotazione_count){
        this.prenotazione_count += 1;
        return this.prenotazione_count;
    }

    public int getLettini() {
        return lettini;
    }

    public void setLettini(int lettini) {
        this.lettini = lettini;
    }

    public void addPrenotazione(Date data_inizioPrenotazione, Date data_finePrenotazione, int num_fila_ombrellone, int id_ombrellone, int lettini, String email) {
        //id_prenotazione = 0;

        setDatainizioPrenotazione(data_inizioPrenotazione);
        setData_finePrenotazione(data_finePrenotazione);
        setNum_fila_ombrellone(num_fila_ombrellone);
        setId_ombrellone(id_ombrellone);
        setLettini(lettini);
        setEmail(email);
        prenotazioneSpiaggiaConnector.PrenotaSpiaggia(incremento_prenotazione(prenotazione_count), data_inizioPrenotazione, data_finePrenotazione, num_fila_ombrellone, id_ombrellone, lettini, email);
        this.prenotazione_count++;
        //  Cliente cliente = new Cliente();
        //    cliente.addCliente(cliente);
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
        if (fasciaOraria.equals(FasciaOraria.MATTINA)) {
            fasciaOraria = "Mattina";
        }
        if (fasciaOraria.equals(FasciaOraria.POMERIGGIO)) {
            fasciaOraria = "Pomeriggio";
        }
        if (fasciaOraria.equals(FasciaOraria.GIORNATA_INTERA)) {
            fasciaOraria = "Giornata Intera";
        }
        throw new UnsupportedOperationException();
    }

    public Prenotazione_Spiaggia(Date data_finePrenotazione, Date datainizioPrenotazione, int num_fila_ombrellone, int id_prenotazione) {
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

    public Date getDatainizioPrenotazione() {
        return data_inizioPrenotazione;
    }

    public void setDatainizioPrenotazione(Date datainizioPrenotazione) {
        this.data_inizioPrenotazione = datainizioPrenotazione;
    }


    public Date getData_finePrenotazione() {
        return data_finePrenotazione;
    }

    public void setData_finePrenotazione(Date data_finePrenotazione) {
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