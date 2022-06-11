package com.unicam.cs.ids.casotto.serviziogestione;

import com.unicam.cs.ids.casotto.model.FasciaOraria;
import com.unicam.cs.ids.casotto.serviziobar.ProdottiBar;
import com.unicam.cs.ids.casotto.serviziospiaggia.Ombrellone;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TariffaPrezzi {
    public static final int PREZZO_LETTINO = 2;
    public static final int PREZZO_OMBRELLONE_BASE = 4;
    public static final int PREZZO_OMBRELLONE_PREMIUM = 6;
    public static final int PREZZO_OMBRELLONE_VIP = 8;
    public Ombrellone appartiene;
    public ProdottiBar riferisce;
    private int num_fila_ombrellone;
    private FasciaOraria fasciaOraria;
    private double prezzoLettino;
    private double prezzoOmbrelloneMezzaGiornata;
    private double prezzoOmbrelloneGiornataIntera;
    private int id_prodotto;
    private long num_giorni;

    public TariffaPrezzi() {
        this.num_fila_ombrellone = num_fila_ombrellone;
        this.fasciaOraria = fasciaOraria;
        this.prezzoLettino = prezzoLettino;
        this.prezzoOmbrelloneMezzaGiornata = prezzoOmbrelloneMezzaGiornata;
        this.prezzoOmbrelloneGiornataIntera = prezzoOmbrelloneGiornataIntera;
        this.id_prodotto = id_prodotto;
    }

    public TariffaPrezzi(int num_fila_ombrellone, FasciaOraria fasciaOraria, double prezzoLettino, double prezzoOmbrelloneMezzaGiornata, double prezzoOmbrelloneGiornataIntera, int id_prodotto) {
        this.num_fila_ombrellone = num_fila_ombrellone;
        this.fasciaOraria = fasciaOraria;
        this.prezzoLettino = prezzoLettino;
        this.prezzoOmbrelloneMezzaGiornata = prezzoOmbrelloneMezzaGiornata;
        this.prezzoOmbrelloneGiornataIntera = prezzoOmbrelloneGiornataIntera;
        this.id_prodotto = id_prodotto;
    }

    public void modificaPrezzo() {
        throw new UnsupportedOperationException();
    }

    public double Imposta_Prezzi_Spiaggia(FasciaOraria fasciaOraria, int num_fila_ombrellone, String data_inizio, String data_fine, int lettini) {
        double prezzo_finale = 0;
        double prezzo_tot_om = 0;
        double prezzo_fascia_oraria = 0;
        double prezzo_tipologia = 0;
        if (num_fila_ombrellone >= 1 && num_fila_ombrellone <= 3)
            prezzo_tipologia = prezzo_tipologia + PREZZO_OMBRELLONE_VIP;
        if (num_fila_ombrellone >= 4 && num_fila_ombrellone <= 7)
            prezzo_tipologia = prezzo_tipologia + PREZZO_OMBRELLONE_PREMIUM;
        if (num_fila_ombrellone >= 8 && num_fila_ombrellone <= 15)
            prezzo_tipologia = prezzo_tipologia + PREZZO_OMBRELLONE_BASE;
        if (num_fila_ombrellone > 15 || num_fila_ombrellone <= 0) {
            try {
                throw new Exception("Errore: Seleziona fila da 1 a 15");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String[] dateParts_in = data_inizio.split("-");
        int day_i = Integer.parseInt(dateParts_in[0]);
        int month_i = Integer.parseInt(dateParts_in[1]);
        int year_i = Integer.parseInt(dateParts_in[2]);
        int day_inizio = Integer.parseInt(String.valueOf(day_i));
        int month_inizio = Integer.parseInt(String.valueOf(month_i));
        int year_inizio = Integer.parseInt(String.valueOf(year_i));
        String[] dateParts_f = data_fine.split("-");
        int day_f = Integer.parseInt(dateParts_f[0]);
        int month_f = Integer.parseInt(dateParts_f[1]);
        int year_f = Integer.parseInt(dateParts_f[2]);

        SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
        Date dfrom = null;
        try {
            dfrom = format.parse(data_inizio);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date dto = null;
        try {
            dto = format.parse(data_fine);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long diff = dto.getTime() - dfrom.getTime();
        //System.out.println(diff);
        //  System.out.println("Hours: " + diff / (60 * 60 * 1000) % 24);
        long num_giorni = (diff / (24 * 60 * 60 * 1000)) + 1;

        if (((month_inizio >= 6 && month_inizio <= 8) && (month_f >= 6 && month_f <= 8))
                && (month_inizio <= month_f)) { //manca il controllo sui giorni
            if (month_f == 6 && month_inizio == 6) prezzo_tot_om = (num_giorni) * (prezzo_tipologia + 3);
            // if (month_f == 6 && month_inizio == 7) prezzo
            if (month_f == 7 && month_inizio == 7) prezzo_tot_om = (num_giorni) * (prezzo_tipologia + 4);
            if (month_f == 8 && month_inizio == 8) prezzo_tot_om = (num_giorni) * (prezzo_tipologia + 5);
        }
        if ((month_f >= 1 && month_inizio >= 1) &&
                (month_f <= 5 && month_inizio <= 5) &&
                (month_f >= 9 && month_inizio >= 9) && (month_f <= 12 && month_inizio <= 12))
            throw new RuntimeException("Errore: in questi mesi lo chalet è chiuso.");

        if (fasciaOraria.equals(FasciaOraria.MATTINA)) prezzo_fascia_oraria = 4;
        if (fasciaOraria.equals(FasciaOraria.POMERIGGIO)) prezzo_fascia_oraria = 4;
        if (fasciaOraria.equals(FasciaOraria.GIORNATA_INTERA)) prezzo_fascia_oraria = 6;
        prezzo_finale = (prezzo_tot_om) + (prezzo_fascia_oraria * num_giorni) + (PREZZO_LETTINO * num_giorni * lettini);
        this.num_giorni = num_giorni;
        // System.out.println("Confermi la prenotazione di " + num_giorni + " giorni al prezzo di\n"+ prezzo_finale+ " ?");
        return prezzo_finale;
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

    public long getNum_giorni() {
        return num_giorni;
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