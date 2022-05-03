package com.unicam.cs.ids.casotto;

import com.unicam.cs.ids.casotto.Connectors.ClienteConnector;
import com.unicam.cs.ids.casotto.Connectors.OrdinazioneBarConnector;
import com.unicam.cs.ids.casotto.Connectors.UtenteConnector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@SpringBootApplication
public class CasottoApplication {

    public CasottoApplication() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static void main(String[] args) throws ParseException {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/casotto", "root", "casottofml");
            Statement statement = connection.createStatement();

            // Cliente cliente = new Cliente();
            // utente.menu_cliente("matteotoma98@hotmail.it");
            // cliente.ordinazioneBar();

            /*ResultSet resultSet = statement.executeQuery("select * from chalet ");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("quantita_lettini"));
            } */
            OrdinazioneBarConnector obc = new OrdinazioneBarConnector();

          /*  Ordinazione_Bar ob= new Ordinazione_Bar(null,10, 1 , 1, 1);
            Ordinazione_Bar ordinazione_bar= new Ordinazione_Bar(obc.getDate(), 0, ob.incremento(1), 1,10);
            System.out.println();
            //DateTimeFormatter data_ordinazione, int quantita, int id_ordinazione, int id_ombrellone, int id_prodotto
            //DECREMENTA QUANTITA , ECC
            obc.addOrdine(ordinazione_bar);
            System.out.println(obc.addOrdine(ordinazione_bar)); */
            ClienteConnector clienteConnector = new ClienteConnector();
            // clienteConnector.getCliente("matteotoma98@hotmail.it");
            // Utente utente= new Utente("lorecapo","loreacapo","cliente","Lorenzo","caporossi", "lorenzo@caporossi.com");
            // clienteConnector.addCliente(cliente);
            UtenteConnector utenteConnector = new UtenteConnector();
            //utenteConnector.registrazione("matteo", "matteo", "cliente", "matteo", "toma", "matteo@toma.com", 3);
           // Utente utente = new Utente();
            //Cliente cliente= new Cliente("matteottt","tt","matteo@toma.com",1);
            // clienteConnector.addCliente(cliente);
            //utenteConnector.registrazione("matteo", "matteo", "cliente", "matteo", "toma", "matteo@toma.com", 3);
            utenteConnector.login("matteo","matteo");
            //utenteConnector.getListaUtenti("gestore");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Probabilmente non sei riuscito a connetterti al database. Assicurati di avere mysql installato e che tu sia collegato al database.");
        }


        //SpringApplication.run(CasottoApplication.class, args);
        String username = "prova";
        String password = "dd";
        String ruolo = "boh";
        String nome = "matteo";
        String cognome = "rossi";
        String email = "matteorossi@gma.il";
        int id_ombrellone = 10;
        Cliente cliente = new Cliente(username, password, ruolo, nome, cognome, email, id_ombrellone);
        //cliente.PrenotazioneOmbrellone();
        /*Utente utente = new Utente();
        int scelta;
        do{
            System.out.println("Scegli cosa vuoi fare: ");
            System.out.println("1: Login ");
            System.out.println("2: Registrazione ");
            System.out.println("0: Esci ");
            Scanner scanner = new Scanner(System.in);
            scelta = scanner.nextInt();
            Scanner scanner2 = new Scanner(System.in);
            String username;
            String password;
            switch(scelta) {
                case 1:
                    System.out.println("Digita Username");
                    username = scanner2.nextLine();
                    System.out.println("Digita Password");
                    password = scanner2.nextLine();
                    utente.login(username, password);
                    break;
                case 2:
                    System.out.println("Digita Username");
                    username = scanner2.nextLine();
                    System.out.println("Digita Password");
                    password = scanner2.nextLine();
                    utente.registrazione(username, password);
                    break;
            }
        }
        while(scelta != 0);
        */


    }
}
