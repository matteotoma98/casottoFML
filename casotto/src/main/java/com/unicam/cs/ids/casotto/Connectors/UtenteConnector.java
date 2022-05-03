package com.unicam.cs.ids.casotto.Connectors;

import com.unicam.cs.ids.casotto.Cliente;
import com.unicam.cs.ids.casotto.Utente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtenteConnector {

    Connection connection;

    public UtenteConnector() {
        try {
            connection = DBConnector.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        } //add exception here
    }

    public boolean registrazione(String username, String password, String ruolo, String nome, String cognome, String email, int id_ombrellone) {
        {
            boolean result;

            try {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO utente VALUES ( ?,?,?,?,?,?,?)");
                preparedStatement.setString(1, username.trim());
                preparedStatement.setString(2, password.trim());
                preparedStatement.setString(3, ruolo.trim());
                preparedStatement.setString(4, nome.trim());
                preparedStatement.setString(5, cognome.trim());
                preparedStatement.setString(6, email.trim());
                preparedStatement.setInt(7, id_ombrellone);
                result = preparedStatement.executeUpdate() > 0;
                // ClienteConnector clienteConnector = new ClienteConnector();
                //  Cliente cliente = new Cliente(nome, cognome, email, id_ombrellone);
                //  clienteConnector.addCliente(cliente);
                System.out.println("prova registrazione ad utente connector");
                System.out.println("Utente " + username + " creato correttamente");
            } catch (Exception e) {
                result = false;
                System.out.println(e);
                System.out.println(result);
            }

            System.out.println(username + " " + password + " " + ruolo + " " + nome + " " + cognome + " " + email + " " + id_ombrellone);
            return result;
        }
    }


    public Utente login(String email, String password) {
        ResultSet result;
        Utente utente = new Utente();
        try {
            result = connection.createStatement().executeQuery("SELECT * FROM utente WHERE email ='" + email + "' AND password = '" + password + "'");

            while (result.next()) {
                utente = UtenteConverter(result);
                System.out.println("Sei loggato correttamente");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return utente;

    }


    private Utente UtenteConverter(ResultSet result) throws SQLException {
        String username = result.getString("username");
        String password = result.getString("password");
        String ruolo = result.getString("ruolo");
        String email = result.getString("email");
        String nome = result.getString("nome");
        String cognome = result.getString("cognome");
        int id_ombrellone = result.getInt("id_ombrellone");

        return new Utente(username, password, ruolo, email, nome, cognome, id_ombrellone);
    }

}
