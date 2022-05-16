package com.unicam.cs.ids.casotto.Connectors;

import com.unicam.cs.ids.casotto.Cliente;

import java.sql.*;

public class AddettoSpiaggiaConnector {
    Connection connection;

    public AddettoSpiaggiaConnector() {
        try {
            connection = DBConnector.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        } //add exception here
    }


    public void cambiaDisponbilitaOmbrellone() {
        Date data = Date.valueOf(java.time.LocalDate.now());
        boolean result = false;
        try {
            PreparedStatement preparedStatement3 = connection.prepareStatement("UPDATE ombrellone SET disponibilita=1 WHERE disponibilita=0 AND id_ombrellone= ANY (SELECT id_ombrellone FROM prenotazionespiaggia WHERE data_fine_prenotazione <'" + data + "')");
            result = preparedStatement3.executeUpdate() > 0;
            if (result) {
                System.out.println("Disponibilità degli ombrelloni con prenotazione inferiore a " + data + " cambiata");
            }
        } catch (Exception e) {
            System.out.println(e);
            result = false;
        }
    }
}
