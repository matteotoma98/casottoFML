package com.unicam.cs.ids.casotto;

import com.unicam.cs.ids.casotto.Connectors.ClienteConnector;
import com.unicam.cs.ids.casotto.Connectors.OrdinazioneBarConnector;
import com.unicam.cs.ids.casotto.Connectors.UtenteConnector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.mail.MessagingException;
import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.io.Console;

@SpringBootApplication
public class CasottoApplication {

    private String email2;

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

    public static void main(String[] args) throws Exception {
 /*
         try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/casotto", "root", "casottofml");
            Statement statement = connection.createStatement();

            // Cliente cliente = new Cliente();
            // utente.menu_cliente("matteotoma98@hotmail.it");
            // cliente.ordinazioneBar();
            //ResultSet resultSet = statement.executeQuery("select * from chalet ");
            //while (resultSet.next()) {
             //   System.out.println(resultSet.getString("quantita_lettini"));
           // }
            Utente utente = new Utente();
            Cliente cliente = new Cliente();
            int scelta;
            do {
                System.out.println("Benvenuto nell'App di casottoFML™.\nSeleziona un'azione: ");
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
                        utente.registrazione(username, password, email, nome, cognome, ruolo, 0);
                        break;
                }
            }
            while (scelta != 0);

            OrdinazioneBarConnector obc = new OrdinazioneBarConnector();
            ClienteConnector clienteConnector = new ClienteConnector();
            UtenteConnector utenteConnector = new UtenteConnector();
            utenteConnector.login("matteo", "matteo");
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
*/
       SendEmail.sendMail("matteotoma98@hotmail.it");
    }
}
