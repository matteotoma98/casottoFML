package com.unicam.cs.ids.casotto;

import com.unicam.cs.ids.casotto.Connectors.AddettoAttivitaConnector;
import com.unicam.cs.ids.casotto.Connectors.AttivitaConnector;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class Addetto_attivita_Ludico_Sportive extends Utente {
    private int id_addetto_attivita;
    private int id_attivita;
    private String email;
    private String nome;
    private String cognome;
    public ArrayList<Prenotazione_Attivita> registra = new ArrayList<Prenotazione_Attivita>();

    public Addetto_attivita_Ludico_Sportive() {

    }


    public Addetto_attivita_Ludico_Sportive(String username, String password, String ruolo, String email, String nome, String cognome, int id_ombrellone) {
        super(username, password, ruolo, email, nome, cognome);
        //this.id_attivita = id_attivita;
        this.email = email;
        this.nome = nome;
        this.cognome = cognome;
    }

    public int getId_attivita() {
        return id_attivita;
    }

    public void setId_attivita(int id_attivita) {
        this.id_attivita = id_attivita;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public void organizzaAttivita(String email) throws Exception {
        Scanner scanner = new Scanner(System.in);
        AttivitaConnector attivitaConnector = new AttivitaConnector();
        attivitaConnector.getAttivita();
        //inserisci ora fine e inizio
        int num_posti;
        int id_attivita;
        System.out.println("Scegli l'id di un'attività");
        id_attivita = scanner.nextInt();
        setId_attivita(id_attivita);
        System.out.println("Inserisci la data di inizio dell'attività che vuoi modificare");
        String date_start = scanner.next(); // String str="2015-03-31";
        Date start_date = Date.valueOf(date_start);
        System.out.println("Inserisci la data di fine dell'attività che vuoi modificare");
        String date_end = scanner.next(); // String str="2015-03-31";
        Date end_date = Date.valueOf(date_end);
        System.out.println("Inserisci il numero di posti dell'attività:");
        num_posti = scanner.nextInt();
        AddettoAttivitaConnector addettoAttivitaConnector = new AddettoAttivitaConnector();
        addettoAttivitaConnector.setDate(start_date, end_date, num_posti, getId_attivita());

        ResultSet r = addettoAttivitaConnector.sendEmail(id_attivita);
        //for (AddettoAttivitaConnector : r) {}


        // SendEmail sendEmail= new SendEmail();

        // sendEmail.sendMail("matte");
    }
}