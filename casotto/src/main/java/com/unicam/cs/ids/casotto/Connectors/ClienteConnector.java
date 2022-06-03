package com.unicam.cs.ids.casotto.Connectors;

import com.unicam.cs.ids.casotto.utenti.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ClienteConnector {

    Connection connection;

    public ClienteConnector() {
        try {
            connection = DBConnector.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        } //add exception here
    }

    public Cliente getCliente(String email) {
        ResultSet result;
        Cliente cliente = new Cliente();
        try {
            result = connection.createStatement().executeQuery("SELECT * FROM cliente WHERE email = '" + email + "'");
            while (result.next()) {
                cliente.setEmail(result.getString("email"));
                cliente.setNome(result.getString("nome"));
                cliente.setCognome(result.getString("cognome"));
                cliente.setId_ombrellone(result.getInt("id_ombrellone"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return cliente;

    }
/*
    private Cliente convertiRisultatoInCliente(ResultSet result) throws SQLException {
        result.getString("email");
        String nome = result.getString("nome");
        String cognome = result.getString("cognome");
        int id_ombrellone = result.getInt("id_ombrellone");



//public Cliente(String username, String password, String ruolo, String nome, String cognome, String email, int id_ombrellone) {
        return new Cliente(null, null, "", nome, cognome, email, id_ombrellone);

        //  }
    }*/

    public void aggiornaOmbrellone(String email, int id_ombrellone) {
        boolean result = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE cliente set id_ombrellone ='" + id_ombrellone + "' where email='" + email + "'");
            result = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public int getOmbrellone(String email) {
        ResultSet result;
        int id_ombrellone = 0;
        try {
            result = connection.createStatement().executeQuery("SELECT id_ombrellone FROM cliente WHERE email = '" + email + "'");
            while (result.next()) {
                id_ombrellone = result.getInt("id_ombrellone");
            }
              /*ResultSet resultSet = statement.executeQuery("select * from chalet ");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("quantita_lettini"));
            } */

        } catch (Exception e) {
            System.out.println(e);
        }
        return id_ombrellone;
    }

    public boolean addCliente(Cliente cliente) {
        boolean result;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO cliente VALUES ( ?,?,?,?)");
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getCognome());
            preparedStatement.setString(3, cliente.getEmail());
            preparedStatement.setInt(4, cliente.getId_ombrellone());

            result = preparedStatement.executeUpdate() > 0;

            System.out.println("Email: " + cliente.getEmail());
            System.out.println("Ombrellone:" + cliente.getId_ombrellone());
        } catch (Exception e) {
            result = false;
            System.out.println(e);
            System.out.println("Errore Add Cliente");
        }
        return result;
    }

    public boolean aggiornaClienti() {
        boolean result = false;
        ResultSet resultSet;
        String nome = "", cognome = "", email = "";
        int id_ombrellone = 0;
        try {
            Statement statement = connection.createStatement();
            resultSet = connection.createStatement().executeQuery("SELECT nome,cognome,email,id_ombrellone FROM utente WHERE ruolo = 'cliente'");
            while (resultSet.next()) {

                nome = resultSet.getString("nome");
                cognome = resultSet.getString("cognome");
                email = resultSet.getString("email");
                id_ombrellone = resultSet.getInt("id_ombrellone");
                // System.out.println(result.getString("email"+"nome"+"cognome"+"id_ombrellone"));
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO cliente VALUES ( ?,?,?,?)");
                preparedStatement.setString(1, nome);
                preparedStatement.setString(2, cognome);
                preparedStatement.setString(3, email);
                preparedStatement.setInt(4, id_ombrellone);
                result = preparedStatement.executeUpdate() > 0;
            }
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

}