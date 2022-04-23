package com.unicam.cs.ids.casotto;

import java.util.Date;

public class Tariffa_Prezzi {
    private int num_fila_ombrellone;
    private FasciaOraria fasciaOraria;
    private double prezzoLettino;
    private double prezzoOmbrelloneMezzaGiornata;
    private double prezzoOmbrelloneGiornataIntera;
    private int id_prodotto;
    public Ombrellone apprartiene;
    public Prodotti_Bar riferisce;
    public static final int PREZZO_LETTINO = 2;
    public static final int PREZZO_OMBRELLONE_BASE = 4;
    public static final int PREZZO_OMBRELLONE_PREMIUM = 6;
    public static final int PREZZO_OMBRELLONE_VIP = 8;

    public void modificaPrezzo() {
        throw new UnsupportedOperationException();
    }

    public Tariffa_Prezzi() {
        this.num_fila_ombrellone = num_fila_ombrellone;
        this.fasciaOraria = fasciaOraria;
        this.prezzoLettino = prezzoLettino;
        this.prezzoOmbrelloneMezzaGiornata = prezzoOmbrelloneMezzaGiornata;
        this.prezzoOmbrelloneGiornataIntera = prezzoOmbrelloneGiornataIntera;
        this.id_prodotto = id_prodotto;
    }

    public Tariffa_Prezzi(int num_fila_ombrellone, FasciaOraria fasciaOraria, double prezzoLettino, double prezzoOmbrelloneMezzaGiornata, double prezzoOmbrelloneGiornataIntera, int id_prodotto) {
        this.num_fila_ombrellone = num_fila_ombrellone;
        this.fasciaOraria = fasciaOraria;
        this.prezzoLettino = prezzoLettino;
        this.prezzoOmbrelloneMezzaGiornata = prezzoOmbrelloneMezzaGiornata;
        this.prezzoOmbrelloneGiornataIntera = prezzoOmbrelloneGiornataIntera;
        this.id_prodotto = id_prodotto;
    }

    public double Imposta_Prezzi_Spiaggia(String fascia_oraria, int num_fila_ombrellone, Date data_inizio, Date data_fine) {
        double prezzo = 0;
        if (num_fila_ombrellone >= 1 && num_fila_ombrellone <= 3) prezzo = PREZZO_OMBRELLONE_VIP;
        if (num_fila_ombrellone >= 4 && num_fila_ombrellone <= 7) prezzo = PREZZO_OMBRELLONE_PREMIUM;
        if (num_fila_ombrellone >= 8 && num_fila_ombrellone <= 15) prezzo = PREZZO_OMBRELLONE_BASE;
        if (num_fila_ombrellone > 15 || num_fila_ombrellone<=0){
            try {
                throw new Exception("Errore: Seleziona fila da 1 a 15");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String data_in= data_inizio.toString();
        String[] dateParts = data_in.split("-");
        String day = dateParts[0];
        String month = dateParts[1];
        String year= dateParts[2];
        if (month=="6") prezzo= prezzo + 3;
        if(month=="")

        return prezzo;
    }

    public int getNum_fila_ombrellone() {
        return num_fila_ombrellone;
    }

    public void setNum_fila_ombrellone(int num_fila_ombrellone) {
        this.num_fila_ombrellone = num_fila_ombrellone;
    }

    public FasciaOraria getFasciaOraria() {
        return fasciaOraria;
    }

    public void setFasciaOraria(FasciaOraria fasciaOraria) {
        this.fasciaOraria = fasciaOraria;
    }

    public double getPrezzoLettino() {
        return prezzoLettino;
    }

    public void setPrezzoLettino(double prezzoLettino) {
        this.prezzoLettino = prezzoLettino;
    }

    public double getPrezzoOmbrelloneMezzaGiornata() {
        return prezzoOmbrelloneMezzaGiornata;
    }

    public void setPrezzoOmbrelloneMezzaGiornata(double prezzoOmbrelloneMezzaGiornata) {
        this.prezzoOmbrelloneMezzaGiornata = prezzoOmbrelloneMezzaGiornata;
    }

    public double getPrezzoOmbrelloneGiornataIntera() {
        return prezzoOmbrelloneGiornataIntera;
    }

    public void setPrezzoOmbrelloneGiornataIntera(double prezzoOmbrelloneGiornataIntera) {
        this.prezzoOmbrelloneGiornataIntera = prezzoOmbrelloneGiornataIntera;
    }

    public int getId_prodotto() {
        return id_prodotto;
    }

    public void setId_prodotto(int id_prodotto) {
        this.id_prodotto = id_prodotto;
    }
}