package com.unicam.cs.ids.casotto.servizioattivita;

import com.unicam.cs.ids.casotto.Connectors.AddettoAttivitaConnector;
import com.unicam.cs.ids.casotto.Connectors.AttivitaConnector;
import com.unicam.cs.ids.casotto.Connectors.PrenotazioneAttivitaConnector;
import com.unicam.cs.ids.casotto.utenti.Utente;
import com.unicam.cs.ids.casotto.utilities.SendEmail;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class AddettoAttivitaLudicoSportive extends Utente {
    public ArrayList<PrenotazioneAttivita> registra = new ArrayList<PrenotazioneAttivita>();
    private int id_addetto_attivita;
    private int id_attivita;
    private String email;
    private String nome;
    private String cognome;

    public AddettoAttivitaLudicoSportive() {

    }


    public AddettoAttivitaLudicoSportive(String username, String password, String ruolo, String email, String nome, String cognome, int id_ombrellone) {
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
        boolean result = false;
        System.out.println("Scegli l'id di un'attività");
        id_attivita = scanner.nextInt();
        setId_attivita(id_attivita);
        try {
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Inserisci la data di inizio dell'attività che vuoi modificare (esempio formato: 2014-10-29 18:10:45) ");
            String date_start = scanner2.nextLine();
            System.out.println("Inserisci la data di fine dell'attività che vuoi modificare");
            String date_end = scanner2.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = sdf.parse(date_start);
            Date date2 = sdf2.parse(date_end);
            long millis = date.getTime();
            long millis2 = date2.getTime();
            Timestamp start_date = new Timestamp(millis);
            Timestamp end_date = new Timestamp(millis2);
            System.out.println("Inserisci il numero di posti per l'attività scelta");
            num_posti = scanner2.nextInt();
            //  System.out.println("SqlTimestamp          : " + start_date);
        /*
        INVIA EMAIL A TUTTI GLI ISCRITTI ALL'ATTIVITA' CAMBIATA
         */
            AddettoAttivitaConnector addettoAttivitaConnector = new AddettoAttivitaConnector();
            addettoAttivitaConnector.setDate(start_date, end_date, num_posti, getId_attivita());
            PrenotazioneAttivitaConnector prenotazioneAttivitaConnector = new PrenotazioneAttivitaConnector();
            prenotazioneAttivitaConnector.email_Iscritti(id_attivita);
            ArrayList<String> email_iscritti = new ArrayList();
            email_iscritti = prenotazioneAttivitaConnector.email_Iscritti(id_attivita);
            System.out.println("Verranno mandate email ai seguenti iscritti all'attività modificata:");
            for (String i : email_iscritti) {
                result = SendEmail.sendMail(i);
                System.out.println(email_iscritti);
            }
            if (result) System.out.println("Email inviate.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}