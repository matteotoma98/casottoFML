package com.unicam.cs.ids.casotto.Connectors;

import java.sql.Connection;

public class ChaletConnector {

    Connection connection;

    public ChaletConnector() {
        try {
            connection = DBConnector.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        } //add exception here
    }

    public boolean updateCaratteristicheStruttura(int ombrelloni_totali, int lettini_totali, int id_ombrellone, String tipologia, int fila) {

        return true;
    }
}
