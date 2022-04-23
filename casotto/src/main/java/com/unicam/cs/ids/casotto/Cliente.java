package com.unicam.cs.ids.casotto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;
import java.util.GregorianCalendar;

import com.unicam.cs.ids.casotto.Prenotazione_Spiaggia;

public class Cliente extends Utente implements ICliente {
    private String nome;
    private String cognome;
    private String email;
    private int id_ombrellone;
    public ArrayList<Prenotazione_Spiaggia> effettua = new ArrayList<Prenotazione_Spiaggia>();


    public void PrenotazioneOmbrellone(Object aData_inizio) {
        throw new UnsupportedOperationException();
    }

    public void IscrizioneAttivita(String aNome, String aCognome) {
        throw new UnsupportedOperationException();
    }

    public Cliente(String username, String password, String ruolo, String nome, String cognome, String email, int id_ombrellone) {
        super(username, password, ruolo);
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.id_ombrellone = id_ombrellone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId_ombrellone() {
        return id_ombrellone;
    }

    public void setId_ombrellone(int id_ombrellone) {
        this.id_ombrellone = id_ombrellone;
    }

    @Override
    public void PrenotazioneOmbrellone() throws ParseException {
        double prezzo=0;
        Tariffa_Prezzi tariffaPrezzi= new Tariffa_Prezzi();
        Prenotazione_Spiaggia prenotazione_spiaggia = new Prenotazione_Spiaggia();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il giorno d'inizio della prenotazione:\n");
        String date_start = scanner.nextLine();
        Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(date_start);
        prenotazione_spiaggia.setDatainizioPrenotazione(date1);
        //  System.out.println(date1);
        System.out.println("Inserisci il giorno di fine della prenotazione:\n");
        String date_end = scanner.nextLine();
        Date date2 = new SimpleDateFormat("dd-MM-yyyy").parse(date_end);
        prenotazione_spiaggia.setData_finePrenotazione(date2);
        System.out.println("Inserisci il giorno di fine della prenotazione:\n");
        int scelta_fascia_oraria;
        do {
            System.out.println("Scegli in quale fascia oraria vuoi prenotare: ");
            System.out.println("1: Mattina ");
            System.out.println("2: Pomeriggio ");
            System.out.println("3: Giornata Intera ");

            scelta_fascia_oraria = scanner.nextInt();

            switch (scelta_fascia_oraria) {
                case 1:
                    String fasciaOraria = "";
                    fasciaOraria = String.valueOf(FasciaOraria.MATTINA);

                    break;
                case 2:
                    fasciaOraria = String.valueOf(FasciaOraria.POMERIGGIO);
                    break;
                case 3:
                    fasciaOraria = String.valueOf(FasciaOraria.GIORNATA_INTERA);
                    break;
            }
        }
        while (scelta_fascia_oraria != 0);

        int scelta_tipologia;
        do {
            System.out.println("Scegli in quale fascia oraria vuoi prenotare: ");
            System.out.println("1: VIP ");
            System.out.println("2: PREMIUM ");
            System.out.println("3: BASE");
            scelta_tipologia = scanner.nextInt();
            switch (scelta_tipologia) {
                case 1:
                    String tipologia = "";
                    tipologia = String.valueOf(Tipologia.VIP);
                    break;
                case 2:
                    tipologia = String.valueOf(Tipologia.PREMIUM);
                    break;
                case 3:
                    tipologia = String.valueOf(Tipologia.BASE);
                    break;
            }
        }
        while (scelta_tipologia != 0);


        System.out.println("Inserisci la fila dell'ombrellone:\n");
        //querychemostra la lista delle file
        int fila=0;
        fila=  scanner.nextInt();
        Ombrellone om= new Ombrellone();
        om.setNum_fila_ombrellone(fila);

        System.out.println("Inserisci l'id dell'ombrellone che vuoi prenotare");
        //querychemostra la lista degli ombrelloni
        int id = scanner.nextInt();
        om.setId_ombrellone(id);

        prenotazione_spiaggia.(om.getId_ombrellone(),om.getNum_fila_ombrellone(),om.getData, data_fine);
        prezzo= prezzo + tariffaPrezzi.Imposta_Prezzi_Spiaggia(fasciaOraria,"","","");
        //connettore.setOmbrelloneOccupato(id);
        List<Ombrellone> ombrelloni = co.getAvailableOmbrelloni(numero_ospiti);
        for (Ombrellone ombrellone : ombrelloni) {
            System.out.println(ombrellone.toString());
        }
        System.out.println("Digita l'id dell'ombrellone che vuoi prenotare");
        String id = scanner.nextLine();
        co.setOmbrelloneOccupato(id);
        double prezzo = co.getPrezzo(id);
        boolean ris = Cc.AssegnaOmbrellone(this.email, id);
        double totale = prezzo * durata;
        if (ris == true) {
            System.out.println("Prenotazione effettuata con successo - dirigiti alla cassa per pagare");
            System.out.println("Totale : " + totale);
        } else
            System.out.println("Prenotazione non effettuata, riprova");


    }
}