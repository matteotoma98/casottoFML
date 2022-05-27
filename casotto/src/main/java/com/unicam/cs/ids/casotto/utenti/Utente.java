package com.unicam.cs.ids.casotto.utenti;

import com.unicam.cs.ids.casotto.Connectors.ClienteConnector;
import com.unicam.cs.ids.casotto.Connectors.PrenotazioneSpiaggiaConnector;
import com.unicam.cs.ids.casotto.Connectors.UtenteConnector;
import com.unicam.cs.ids.casotto.OpenApp;
import com.unicam.cs.ids.casotto.model.IUtente;
import com.unicam.cs.ids.casotto.servizioattivita.AddettoAttivitaLudicoSportive;
import com.unicam.cs.ids.casotto.serviziogestione.Gestore;
import com.unicam.cs.ids.casotto.serviziospiaggia.AddettoSpiaggia;

import java.text.ParseException;
import java.util.Scanner;

public class Utente implements IUtente {
    private String username;
    private String password;
    private String email;
    private String ruolo;
    private String nome;
    private String cognome;
    ClienteConnector cc = new ClienteConnector();
    UtenteConnector uc = new UtenteConnector();
    //Ordinazione_Bar ob= new Ordinazione_Bar();
    // OrdinazioneBarConnector obc = new OrdinazioneBarConnector();

    public Utente(String username, String password, String ruolo, String email, String nome, String cognome) {
        this.username = username;
        this.password = password;
        this.ruolo = ruolo;
        this.email = email;
        this.nome = nome;
        this.cognome = cognome;
    }

    public Utente() {
    }

    public Utente(String email, String password, String ruolo) {
        this.username = username;
        this.password = password;
        this.ruolo = ruolo;
    }

    public boolean Login(String email, String password) {
        return false;
    }
	/*public boolean Registrati(String email, String password){
		return false;
	}*/

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

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }


    public void registrazione(String username, String password, String nome, String cognome, String email, String ruolo) {
        setUsername(username);
        setPassword(password);
        setRuolo(ruolo);
        setEmail(email);
        setNome(nome);
        setCognome(cognome);
        uc.registrazione(username, password, ruolo, email, nome, cognome);
        Cliente cliente = new Cliente(nome, cognome, email, 0);
        cc.addCliente(cliente);

    }


    @Override
    public void registrazione(String email, String username, String password) {

    }

    @Override
    public void login(String email, String password) throws ParseException {

        Utente utente = uc.login(email, password);
        String _email = utente.getEmail();
        Cliente cliente = new Cliente();
        cliente.setEmail(_email);
        System.out.println("Email in login di Utente.java è " + _email);
        // System.out.println("Email in login di Utente.java è " + email);
        switch (utente.getRuolo()) {
            case "cliente":
                try {
                    menu_cliente(email);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "addetto_spiaggia":
                menu_addettoSpiaggia();
                break;
            case "addetto_bar":
                // menu_addetto_bar();
                break;
            case "addetto_attivita":
                try {
                    menu_addettoAttivita(email);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "gestore":
                menu_gestore(email);
                break;
        }

    }


    private void menu_addettoAttivita(String email) throws Exception {
        AddettoAttivitaLudicoSportive add = new AddettoAttivitaLudicoSportive();
        int scelta;
        do {
            System.out.println("Scegli cosa vuoi fare: ");
            System.out.println("1: Modifica orari attività e posti disponibili");
            System.out.println("0: Esci ");
            Scanner scanner = new Scanner(System.in);
            scelta = scanner.nextInt();
            if (scelta != 1 && scelta != 0)
                throw new IllegalArgumentException("Scelta non valida");
            switch (scelta) {
                case 1:
                    add.organizzaAttivita(email);
                    break;
                case 0:
                    OpenApp openApp = new OpenApp();
                    openApp.Open();
            }
        }
        while (scelta != 0);
    }

    private void menu_gestore(String email) {
        Gestore gestore = new Gestore();
        int scelta;
        do {
            System.out.println("Scegli cosa vuoi fare: ");
            System.out.println("1: Aggiungi attività giornaliere ");
            System.out.println("2: Aggiungi attrezzature ludico sportive ");
            System.out.println("3: Aggiorna caratteristiche struttura ");
            System.out.println("4: Aggiorna politiche dei prezzi ");
            System.out.println("5: Aggiungi prodotti al bar ");
            System.out.println("6: Aggiorna/Definisci ruoli utente");
            System.out.println("0: Esci ");
            Scanner scanner = new Scanner(System.in);
            scelta = scanner.nextInt();
            switch (scelta) {
                case 1:
                    gestore.definizioneAttivita();
                    break;
                case 2:
                    //	gestore.definizioneAttrezzatura();
                    break;
                case 3:
                    //gestore.updateCaratteristicheStruttura();
                    break;
                case 4:
                    //	gestore.definizionePolitichePrezzi();
                    break;
                case 5:
                    //   gestore.updatePolitichePrezzi();
                    break;
                case 6:
                    //      gestore.cambiaRuolo();
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


    private void menu_addettoSpiaggia() {
        AddettoSpiaggia as = new AddettoSpiaggia();
        int scelta;
        do {
            System.out.println("Scegli cosa vuoi fare: ");
            System.out.println("1: Libera Ombrellone ");
            System.out.println("0: Esci ");
            Scanner scanner = new Scanner(System.in);
            scelta = scanner.nextInt();
            switch (scelta) {
                case 1:
                    // as.liberaOmbrellone();
                    break;
            }
        }
        while (scelta != 0);
    }


    public void menu_cliente(String email) throws ParseException {
        //Cliente cliente = cc.getCliente(email);
        // Ordinazione_Bar ordinazione_bar = new Ordinazione_Bar(obc.getDate(), quantita, ob.incremento(id_ordinazione) , scelta);
        // OrdinazioneBarConnector ob = ordinazione_bar.ordinazione_Prodotto("jn", 5);
        //  Attivita attivita= new Attivita();
        int scelta;
        Cliente cliente = new Cliente();
        do {
            System.out.println("Scegli cosa vuoi fare: ");
            System.out.println("1: Prenota ombrellone ");
            System.out.println("2: Cancella prenotazione ombrellone ");
            PrenotazioneSpiaggiaConnector prenotazioneSpiaggiaConnector = new PrenotazioneSpiaggiaConnector();
            if (prenotazioneSpiaggiaConnector.checkPrenotazioniOmbrellone(email)) {
                System.out.println("3: Ordinazione bar ");
            }
            ;
            System.out.println("4: Iscrizione attività ");
            System.out.println("0: Effettua il logout ");
            Scanner scanner = new Scanner(System.in);
            scelta = scanner.nextInt();
            switch (scelta) {
                case 1:
                    cliente.PrenotazioneOmbrellone(email);
                    break;
                case 2:
                    cliente.cancellazionePrenotazioneOmbrellone(email);
                    break;
                case 3:
                    if (prenotazioneSpiaggiaConnector.checkPrenotazioniOmbrellone(email)) {
                        cliente.ordinazioneBar(email);
                    }
                    break;
                case 4:
                    cliente.iscrizione_Attivita(email);
                    break;
            }
        }
        while (scelta != 0);
    }


}