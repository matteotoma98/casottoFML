package com.unicam.cs.ids.casotto.Connectors;

import java.sql.*;

public class PagamentoOmbrelloneConnector {

    Connection connection;

    public PagamentoOmbrelloneConnector() {
        try {
            connection = DBConnector.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int last_prenotazione() {
        int i = 0;
        boolean result;
        int id_ordinazione = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX(id_prenotazione) as last_id FROM pagamentoombrellone");
            int lastordinazione = 0;
            while (resultSet.next()) {
                lastordinazione = resultSet.getInt("last_id");
            }
            id_ordinazione = lastordinazione + 1;
        } catch (Exception e) {
            System.out.println(e);
        }
        return id_ordinazione;
    }

    public boolean aggiornaListaPagamenti(String tipologia_pagamento, int id_prenotazione, int id_ombrellone, Date data_pagamento) {
        boolean result = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO pagamentoombrellone VALUES (?,?,?,?)");
            preparedStatement.setString(1, tipologia_pagamento);
            preparedStatement.setInt(2, last_prenotazione());
            preparedStatement.setInt(3, id_ombrellone);
            preparedStatement.setDate(4, data_pagamento);
            result = preparedStatement.executeUpdate() > 0;

            if (result) System.out.println("Lista pagamenti aggiornata.");
        } catch (Exception e) {

            System.out.println(e);
            System.out.println(tipologia_pagamento);
            System.out.println(id_prenotazione);
            System.out.println(id_ombrellone);
            System.out.println(data_pagamento);
            result = false;
        }
        return result;
    }

}

