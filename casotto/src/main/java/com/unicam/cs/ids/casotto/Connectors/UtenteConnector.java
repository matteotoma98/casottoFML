package com.unicam.cs.ids.casotto.Connectors;

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

    public boolean registrazione(String nome, String cognome, String email, String username, String password, String ruolo) {
        {
            boolean result;

            try {

                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO utenti VALUES ( ?,?,?,?,?)");
                preparedStatement.setString(1, nome.trim());
                preparedStatement.setString(2, cognome.trim());
                preparedStatement.setString(3, email.trim());
                preparedStatement.setString(4, username.trim());
                preparedStatement.setString(5, password.trim());

                result = preparedStatement.executeUpdate() > 0;

            } catch (Exception e) {
                result = false;
            }
            return result;
        }
    }


    public Utente login(String email, String password) {
        ResultSet result;
        Utente utente = new Utente();
        try {
            result = connection.createStatement().executeQuery("SELECT * FROM utenti WHERE email ='" + email + "' AND password = '" + password + "'");

            while (result.next()) {
                utente = UtenteConverter(result);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return utente;

    }


    private Utente UtenteConverter(ResultSet result) throws SQLException {
        String email = result.getString("email");
        String password = result.getString("password");
        String ruolo  = result.getString("ruolo");


        return new Utente(email, password, ruolo);
    }

}
