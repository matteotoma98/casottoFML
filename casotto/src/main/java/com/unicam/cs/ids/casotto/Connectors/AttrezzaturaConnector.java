package com.unicam.cs.ids.casotto.Connectors;

import java.sql.Connection;

public class AttrezzaturaConnector {
    Connection connection;

    public AttrezzaturaConnector() {

        try {
            connection = DBConnector.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        } //add exception here
    }

    private boolean addAttrezzatura(int id_attivita, String nome_attrezzatura, int quantita) {
        return true;
    }
}
