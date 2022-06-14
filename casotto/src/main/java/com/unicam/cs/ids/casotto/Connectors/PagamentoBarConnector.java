package com.unicam.cs.ids.casotto.Connectors;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

public class PagamentoBarConnector {

    Connection connection;

    public PagamentoBarConnector() {
        try {
            connection = DBConnector.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean aggiornaListaPagamenti(String tipologia_pagamento, int id_ordinazione, int id_ombrellone, Date data_pagamento) {
        boolean result = false;
        java.util.Date date = new java.util.Date();
        Timestamp ts = new Timestamp(date.getTime());
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO pagamentobar VALUES (?,?,?,?)");
            preparedStatement.setString(1, tipologia_pagamento);
            preparedStatement.setInt(2, id_ordinazione);
            preparedStatement.setInt(3, id_ombrellone);
            preparedStatement.setTimestamp(4, ts);
            result = preparedStatement.executeUpdate() > 0;
            //    if (result) System.out.println("Lista pagamenti aggiornata.");
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

}
