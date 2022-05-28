package com.unicam.cs.ids.casotto.Connectors;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ChaletConnector {

    Connection connection;

    public ChaletConnector() {
        try {
            connection = DBConnector.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        } //add exception here
    }

    public boolean updateOmbrelloniTotali(int ombrelloni_totali) {
        boolean result = false;
        boolean risultato = false;

        try {
            PreparedStatement preparedStatement3 = connection.prepareStatement("UPDATE chalet set quantita_ombrelloni='" + ombrelloni_totali + "'"); //"'WHERE num_posti>=0 );
            result = preparedStatement3.executeUpdate() > 0;
            if (result) {
                //add Ombrelloni a quelli totali! in base a quanti ne sono stati passati.
                System.out.println("Quantità degli ombrelloni totali dello chalet cambiata.");
                risultato = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return risultato;
    }

    public boolean updateLettiniTotali(int lettini_totali) {
        boolean result = false;
        boolean risultato = false;

        try {
            PreparedStatement preparedStatement3 = connection.prepareStatement("UPDATE chalet set quantita_lettini='" + lettini_totali + "'"); //"'WHERE num_posti>=0 );
            result = preparedStatement3.executeUpdate() > 0;
            if (result) {
                System.out.println("Quantità dei lettini totali dello chalet cambiata.");
                risultato = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return risultato;


    }


}
