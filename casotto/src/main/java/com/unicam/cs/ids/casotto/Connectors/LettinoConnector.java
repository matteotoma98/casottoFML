package com.unicam.cs.ids.casotto.Connectors;

import java.sql.Connection;

public class LettinoConnector {
    Connection connection;

    public LettinoConnector() {
        try {
            connection = DBConnector.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        } //add exception here
    }

    private boolean updatePrezzo(double prezzo) {
        return true;
    }

}
