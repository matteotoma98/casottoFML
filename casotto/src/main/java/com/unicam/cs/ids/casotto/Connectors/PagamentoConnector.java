package com.unicam.cs.ids.casotto.Connectors;

import java.sql.*;

public class PagamentoConnector {

    Connection connection;

    public PagamentoConnector() {
        try {
            connection = DBConnector.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean aggiornaListaPagamenti(String tipologia_pagamento, int id_prenotazione, int id_ordinazione , int id_ombrellone, Date data_pagamento) {
        boolean result = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO pagamento VALUES (?,?,?,?,?)");
            preparedStatement.setString(1, tipologia_pagamento);
            preparedStatement.setInt(2, id_prenotazione);
            preparedStatement.setInt(3, id_ordinazione);
            preparedStatement.setInt(4, id_ombrellone);
            preparedStatement.setDate(5, data_pagamento);
            result = preparedStatement.executeUpdate() > 0;
            if(result) System.out.println("Lista pagamenti aggiornata.");
        } catch (Exception e) {
            System.out.println(e);
            result = false;
        }
        return result;
    }

}
