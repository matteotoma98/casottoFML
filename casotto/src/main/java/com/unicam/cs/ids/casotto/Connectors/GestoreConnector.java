package com.unicam.cs.ids.casotto.Connectors;

import java.sql.Connection;
import java.sql.ResultSet;

public class GestoreConnector {


    Connection connection;

    public GestoreConnector() {

        try {
            connection = DBConnector.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        } //add exception here
    }

    public ResultSet listaGestori() {
        ResultSet result = null;
        return result;
    }


}
