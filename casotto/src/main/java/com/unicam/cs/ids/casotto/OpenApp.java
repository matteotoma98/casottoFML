package com.unicam.cs.ids.casotto;

import com.unicam.cs.ids.casotto.Connectors.AddettoSpiaggiaConnector;
import com.unicam.cs.ids.casotto.Connectors.ClienteConnector;
import com.unicam.cs.ids.casotto.Connectors.OrdinazioneBarConnector;
import com.unicam.cs.ids.casotto.Connectors.UtenteConnector;

import java.text.ParseException;
import java.util.Scanner;

public class OpenApp {
    public void Open() throws ParseException {
        AddettoSpiaggiaConnector addettoSpiaggiaConnector = new AddettoSpiaggiaConnector();
        //addettoSpiaggiaConnector.cambiaDisponbilitaOmbrellone();
        Utente utente = new Utente();
        Cliente cliente = new Cliente();
        int scelta;
        do {
            System.out.println("Benvenuto nell'App di casottoFML™\nSeleziona un'azione: ");
            System.out.println("1: Login ");
            System.out.println("2: Registrazione ");
            System.out.println("0: Esci ");
            Scanner scanner = new Scanner(System.in);
            scelta = scanner.nextInt();
            Scanner scanner_value = new Scanner(System.in);
            String username;
            String password;
            String email;
            String nome;
            String cognome;
            int id_ombrellone;
            String ruolo = "cliente";

            switch (scelta) {
                case 1:
                    System.out.println("Inserisci email");
                    email = scanner_value.nextLine();
                    System.out.println("Inserisci Password");
                    password = scanner_value.nextLine(); //TODO hidare password
                    utente.login(email, password);
                    cliente.PrenotazioneOmbrellone(email);
                    break;
                case 2:
                    System.out.println("Inserisci Username");
                    username = scanner_value.nextLine();
                    System.out.println("Inserisci Password");
                    password = scanner_value.nextLine();
                    System.out.println("Inserisci email");
                    email = scanner_value.nextLine();
                    System.out.println("Inserisci nome");
                    nome = scanner_value.nextLine();
                    System.out.println("Inserisci cognome");
                    cognome = scanner_value.nextLine();
                    utente.registrazione(username, password, email, nome, cognome, ruolo);
                    break;
            }
        }
        while (scelta != 0);

        OrdinazioneBarConnector obc = new OrdinazioneBarConnector();
        ClienteConnector clienteConnector = new ClienteConnector();
        UtenteConnector utenteConnector = new UtenteConnector();
        utenteConnector.login("matteo", "matteo");
    }


}
