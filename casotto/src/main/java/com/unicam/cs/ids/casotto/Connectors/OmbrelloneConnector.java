package com.unicam.cs.ids.casotto.Connectors;

import java.sql.Connection;

public class OmbrelloneConnector {
    Connection connection;

    public OmbrelloneConnector() {
        try {
            connection = DBConnector.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        } //add exception here
    }

    private boolean updatePolitichePrezzi(int id_fila, int id_ombrellone, double prezzo_ombrellone) {
        return true;
    }

}
