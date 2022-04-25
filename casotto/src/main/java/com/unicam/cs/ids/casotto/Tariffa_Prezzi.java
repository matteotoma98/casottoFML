package com.unicam.cs.ids.casotto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
    private GregorianCalendar gregorianCalendar;

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

    public double Imposta_Prezzi_Spiaggia(FasciaOraria fasciaOraria, int num_fila_ombrellone, String data_inizio, String data_fine) {
        double prezzo = 0;
        if (num_fila_ombrellone >= 1 && num_fila_ombrellone <= 3) prezzo = PREZZO_OMBRELLONE_VIP;
        if (num_fila_ombrellone >= 4 && num_fila_ombrellone <= 7) prezzo = PREZZO_OMBRELLONE_PREMIUM;
        if (num_fila_ombrellone >= 8 && num_fila_ombrellone <= 15) prezzo = PREZZO_OMBRELLONE_BASE;
        if (num_fila_ombrellone > 15 || num_fila_ombrellone <= 0) {
            try {
                throw new Exception("Errore: Seleziona fila da 1 a 15");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



        //gregorianCalendar.set(data_inizio);
       // data_inizio.set(GregorianCalendar.YEAR, 2015);
       // data_inizio.set(GregorianCalendar.MONTH, 4);
      //  data_inizio.set(GregorianCalendar.DATE, 20);
        int month[] = {1,2,3,4,5,6,7,8,9,10,11,12};
        String data_in = data_inizio.toString();
      /*  System.out.print("Date: "
                +data_inizio.set(GregorianCalendar.MONTH, 4) + " "
                +  data_inizio.set(GregorianCalendar.DATE, 20)"" + " "
                +  data_inizio.set(GregorianCalendar.YEAR, 2015) + "\n"); */
        String[] dateParts_in = data_in.split("-");
        int month_i = Integer.parseInt(dateParts_in[0]);
        int day_i = Integer.parseInt(dateParts_in[1]) ;
        int year_i =  Integer.parseInt(dateParts_in[2]) ;
        int day_inizio = Integer.parseInt(String.valueOf(day_i));
        int month_inizio = Integer.parseInt(String.valueOf(month_i));
        int year_inizio = Integer.parseInt(String.valueOf(year_i));
        String data_f = data_fine.toString();
        String[] dateParts_f = data_f.split("-");
        int month_f =Integer.parseInt(dateParts_f[0]) ;
        int day_f = Integer.parseInt(dateParts_f[0]);
        int year_f = Integer.parseInt(dateParts_f[0]);


        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date dfrom = null;
        try {
            dfrom = format.parse(data_inizio.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date dto = null;
        try {
            dto = format.parse(data_fine.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long diff = dto.getTime() - dfrom.getTime();
        System.out.println(diff);
        //  System.out.println("Hours: " + diff / (60 * 60 * 1000) % 24);
        long num_giorni = (diff / (24 * 60 * 60 * 1000)) + 1;

        if (((month_inizio >= 6 && month_inizio <= 8) && (month_f >= 6 && month_f <= 8))
                && (month_inizio <= month_f)) { //controllo sui giorni
            if (month_f == 6 && month_inizio == 6) prezzo = (num_giorni) * (prezzo + 3);
            // if (month_f == 6 && month_inizio == 7) prezzo
            if (month_f == 7 && month_inizio == 7) prezzo = (num_giorni) * (prezzo + 4);
            if (month_f == 8 && month_inizio == 8) prezzo = (num_giorni) * (prezzo + 5);
        }
        if ((month_f >= 1 && month_inizio >= 1) ||
                (month_f <= 5 && month_inizio <= 5) ||
                (month_f >= 9 && month_inizio >= 9) && (month_f <= 12 && month_inizio <= 12))
            throw new RuntimeException("Errore: in questi mesi lo chalet è chiuso.");
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