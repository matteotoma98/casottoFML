package com.unicam.cs.ids.casotto.Connectors;

import com.unicam.cs.ids.casotto.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
            result = connection.createStatement().executeQuery("SELECT * FROM clienti WHERE email = '" + email + "'");
            while (result.next()) {

                cliente = convertiRisultatoInCliente(result);
            }
        } catch (Exception e) {
            System.out.println(e);
        } //add exception here

        return cliente;

    }

    private Cliente convertiRisultatoInCliente(ResultSet result) throws SQLException {

        String email = result.getString("email");
        String nome = result.getString("nome");
        String cognome = result.getString("cognome");
        int id_ombrellone = result.getInt("id_ombrellone");

//public Cliente(String username, String password, String ruolo, String nome, String cognome, String email, int id_ombrellone) {
        return new Cliente(null, null, "", nome, cognome, email, id_ombrellone);

        //  }
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
        } catch (Exception e) {
            result = false;
        }
        return result;
    }


}