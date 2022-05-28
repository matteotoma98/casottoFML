package com.unicam.cs.ids.casotto.serviziogestione;

import com.unicam.cs.ids.casotto.Connectors.AttivitaConnector;
import com.unicam.cs.ids.casotto.Connectors.AttrezzaturaConnector;
import com.unicam.cs.ids.casotto.Connectors.ChaletConnector;
import com.unicam.cs.ids.casotto.Connectors.OmbrelloneConnector;
import com.unicam.cs.ids.casotto.OpenApp;
import com.unicam.cs.ids.casotto.utenti.Utente;

import java.text.ParseException;
import java.util.Scanner;

public class Gestore extends Utente {
    private String nome;
    private String cognome;
    private String email;

    /*
	public Prodotti_Bar prodotti_bar;
	public Chalet chalet;
    */


    public boolean addAttivitaGiornaliere(String nome_attivita, String nome_attrezzatura, int quantita) {
        return true;
    }

    public boolean addAttrezzatura(int id_attivita, String nome_attrezzatura, int quantita) {
        return true;

    }

    public boolean updatePolitichePrezzi(int id_fila, int id_ombrellone, double prezzo_ombr_mg, double prezzo_ombr_gi, double prezzo_lettino, double prezzo_prodotto, int id_prodotto) {

        return true;
    }

    public boolean aggiornaPrezzoFila(int id_fila, double prezzo) {
        return true;
    }

    public boolean aggiornaPrezzoOmbrellone(int id_ombrellone, double prezzo) {
        return true;
    }

    public boolean aggiornaPrezzoOmbrelloneMGGI(String tipologia) {
        if (tipologia.equals("MG")) {

        }
        if (tipologia.equals("GI")) {

        }
        return true;
    }

    public boolean aggiornaPrezzoProdottobar(int id_prodotto, double prezzo) {
        return true;
    }

    public boolean cambiaRuolo(String email) {
        return true;
    }

    public void definizioneProdotti() {
        throw new UnsupportedOperationException();
    }

    public void definizioneStruttura(int num_ombrelloni, int num_lettini) {
        throw new UnsupportedOperationException();
    }

    public void updateCaratteristicheStruttura() {
        int ombrelloni_totali = 0;
        int lettini_totali = 0;
        int id_ombrellone = 0;
        String tipologia = "";
        int fila = 0;
        int scelta = 0;
        boolean risultato=false;
        ChaletConnector chaletConnector = new ChaletConnector();
        OmbrelloneConnector ombrelloneConnector = new OmbrelloneConnector();
        do {
            System.out.println("Scegli cosa vuoi fare: ");
            System.out.println("1: Cambia il numero degli ombrelloni totali dello chalet ");
            System.out.println("2: Cambia il numero dei lettini totali dello chalet ");
            System.out.println("3: Aggiungi un ombrellone ");
            System.out.println("4: Rimuovi un ombrellone ");
            System.out.println("0: Esci ");
            Scanner scanner = new Scanner(System.in);
            scelta = scanner.nextInt();
            switch (scelta) {
                case 1:
                    System.out.println("Inserisci il numero di ombrelloni totali dello chalet:");
                    ombrelloni_totali = scanner.nextInt();
                    if (lettini_totali < 0) {
                        throw new IllegalArgumentException("la quantità di ombrelloni totali deve essere maggiore di 0");
                    } else chaletConnector.updateOmbrelloniTotali(ombrelloni_totali);
                    break;
                case 2:
                    System.out.println("Inserisci il numero di lettini totali dello chalet:");
                    lettini_totali = scanner.nextInt();
                    if (lettini_totali < 0) {
                        throw new IllegalArgumentException("la quantità di lettini totali deve essere maggiore di 0");
                    } else chaletConnector.updateLettiniTotali(lettini_totali);
                    break;
                case 3:
                    System.out.println("Inserisci l'id dell'ombrellone da aggiungere:");
                    id_ombrellone = scanner.nextInt();
                    System.out.println("Inserisci la fila dell'ombrellone da aggiungere: (dalla 1 alla 3 => vip, dalla 4 alla 7 => premium, dalla 8 alla 15 => base");
                    fila = scanner.nextInt();
                    if (id_ombrellone < 0) {
                        throw new IllegalArgumentException("l'id dell'ombrellone deve essere maggiore di 0");
                        //(mettere do while finchè non è giusto)
                    } /* else if ((!tipologia.equals("vip")) || (!tipologia.equals("premium")) || (!tipologia.equals("base"))) {
                        throw new IllegalArgumentException("inserisci una tipologia che sia base,vip o premium");
                    } */
                    else if (fila < 1 || fila > 15) {
                        throw new IllegalArgumentException("inserisci una fila compresa tra 1 e 15 ");
                    }
                    else ombrelloneConnector.addOmbrellone(id_ombrellone, fila);
                    break;
                case 4:
                    System.out.println("Lista degli ombrelloni disponibili:");
                    ombrelloneConnector.getOmbrelloni();
                    do {
                    System.out.println("Inserisci l'id dell'ombrellone da rimuovere:");
                    if (id_ombrellone < 0) {
                        throw new IllegalArgumentException("l'id dell'ombrellone deve essere maggiore di 0");
                    }
                    id_ombrellone = scanner.nextInt();
                    risultato= ombrelloneConnector.removeOmbrellone(id_ombrellone);
                    }
                    while (!risultato);
                    break;
                case 0:
                    OpenApp openApp = new OpenApp();
                    try {
                        openApp.Open();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
            }
        }
        while (scelta != 0);
    }

    public void definizioneAttrezzatura() {
        String nomeAttrezzatura = "";
        int quantita = 0;
        Scanner scanner = new Scanner(System.in);
        AttrezzaturaConnector at = new AttrezzaturaConnector();
        //  at.addAttrezzatura();
        boolean risultato = false;
        do {
            System.out.println("Inserisci il nome dell'attrezzatura da aggiungere:");
            nomeAttrezzatura = scanner.next();
            System.out.println("Inserisci la quantità dell'attrezzatura:");
            quantita = scanner.nextInt();

            risultato = at.addAttrezzatura(nomeAttrezzatura, quantita);
        }
        while (!risultato);
    }

    public void modificaquantitaAttrezzatura() {
        String nomeAttivita = "";
        String nome_attrezzatura = "";
        int quantita_attrezzatura = 0;
        Scanner scanner = new Scanner(System.in);
        boolean risultato = false;
        do {
            AttrezzaturaConnector at = new AttrezzaturaConnector();
            at.getAttrezzatura();
            System.out.println("Inserisci il nome dell'attrezzatura di cui modificare la quantità");
            nome_attrezzatura = scanner.next();
            System.out.println("Inserisci la quantità dell'attrezzatura:");
            quantita_attrezzatura = scanner.nextInt();
            risultato = at.modificaAttrezzatura(nome_attrezzatura, quantita_attrezzatura);
        }
        while (!risultato);
    }

    public void rimozioneAttivita() {
        String nomeAttivita = "";
        Scanner scanner = new Scanner(System.in);
        AttivitaConnector ac = new AttivitaConnector();
        ac.getAttivita();
        boolean risultato = false;
        do {
            System.out.println("Inserisci il nome dell'attività da rimuovere:");
            nomeAttivita = scanner.next();

            risultato = ac.rimuoviAttivita(nomeAttivita);
        }
        while (!risultato);
    }

    public void definizioneAttivita() {
        String nomeAttivita = "";
        String nome_attrezzatura = "";
        int quantita_attrezzatura = 0;
        Scanner scanner = new Scanner(System.in);
        boolean risultato = false;
        do {
            System.out.println("Inserisci il nome dell'attività da aggiungere:");
            nomeAttivita = scanner.next();
            System.out.println("Inserisci il nome dell'attrezzatura:");
            nome_attrezzatura = scanner.next();
            System.out.println("Inserisci la quantità dell'attrezzatura:");
            quantita_attrezzatura = scanner.nextInt();
            AttivitaConnector ac = new AttivitaConnector();
            risultato = ac.addAttivita(nomeAttivita, nome_attrezzatura, quantita_attrezzatura);
        }
        while (!risultato);
    }


    public void definizionePolitichePrezzi() {


    }

    public Gestore(String username, String password, String ruolo, String nome, String cognome, String email, int id_ombrellone) {
        super(username, password, email, ruolo, nome, cognome);
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
    }

    public Gestore() {

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


}