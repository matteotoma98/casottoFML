package com.unicam.cs.ids.casotto.serviziogestione;

import com.unicam.cs.ids.casotto.Connectors.AttivitaConnector;
import com.unicam.cs.ids.casotto.Connectors.AttrezzaturaConnector;
import com.unicam.cs.ids.casotto.Connectors.ChaletConnector;
import com.unicam.cs.ids.casotto.utenti.Utente;

import java.util.Scanner;

public class Gestore extends Utente {
    private String nome;
    private String cognome;
    private String email;

    /*
	public Prodotti_Bar prodotti_bar;
	public Chalet chalet;
    */
    public void updateCaratteristicheStruttura(int ombrelloni_totali, int lettini_totali, int id_ombrellone, String tipologia, int fila) {
        ChaletConnector cc = new ChaletConnector();
        cc.updateCaratteristicheStruttura(ombrelloni_totali, lettini_totali, id_ombrellone, tipologia, fila);
    }

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