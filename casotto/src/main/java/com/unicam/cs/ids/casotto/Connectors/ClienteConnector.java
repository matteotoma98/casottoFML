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

    public ResultSet getCliente(String email) {
        ResultSet result= null;
        Cliente cliente = new Cliente();
        try {
            result = connection.createStatement().executeQuery("SELECT * FROM cliente WHERE email = '" + email + "'");
            while (result.next()) {
                System.out.println(result.getString("email"));
                System.out.print(result.getString(" nome"));
                System.out.print(result.getString(" cognome"));
                System.out.print(result.getInt(" id_ombrellone"));
               // System.out.println(result.getString("email"+"nome"+"cognome"+"id_ombrellone"));

                cliente = convertiRisultatoInCliente(result);
            }
              /*ResultSet resultSet = statement.executeQuery("select * from chalet ");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("quantita_lettini"));
            } */

        } catch (Exception e) {
            System.out.println(e);
        } //add exception here
        //return cliente;
        return result;

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
            System.out.println(e);
            System.out.println("Errore Add Cliente");
        }
        return result;
    }


}