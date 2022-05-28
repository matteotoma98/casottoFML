package com.unicam.cs.ids.casotto.Connectors;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OmbrelloneConnector {
    Connection connection;

    public OmbrelloneConnector() {
        try {
            connection = DBConnector.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        } //add exception here
    }


    public boolean getOmbrelloni() {
        ResultSet resultSet;
        boolean risultato = false;
        try {
            resultSet = connection.createStatement().executeQuery("SELECT id_ombrellone,prezzo,tipologia,num_fila_ombrellone FROM ombrellone");
            while (resultSet.next()) {
                System.out.println("id: " + resultSet.getInt("id_ombrellone") + ", ");
                System.out.println("prezzo: " + resultSet.getInt("prezzo") + ", ");
                System.out.println("tipologia:" + resultSet.getString("tipologia") + ", ");
                System.out.println("fila:" + resultSet.getInt("num_fila_ombrellone"));
                System.out.println("\t");
                //if risultato vuoto print
                risultato = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return risultato;
    }

    public boolean addOmbrellone(int id_ombrellone, int fila) {
        boolean result = false;
        ResultSet result2;
        boolean resultattr = false;
        boolean ombr_esistente = false;
        int id_ombr = 0;
        boolean risultato = false;
        String tipologia = "";
        int prezzo = 0;
        try {
            result2 = connection.createStatement().executeQuery("SELECT id_ombrellone FROM ombrellone WHERE id_ombrellone='" + id_ombrellone + "'");
            while (result2.next()) {
                id_ombr = result2.getInt("id_ombrellone");
                if (id_ombr == 0) ombr_esistente = false;
                else {
                    ombr_esistente = true;
                    if (ombr_esistente)
                        System.out.println("esiste già questo id di ombrellone, inserirne un id diverso.");
                }
            }

            try {
                if (!ombr_esistente) {
                    System.out.println("Non c'è un'ombrellone con questo id, verrà quindi inserito.");
                    try {
                        if (fila >= 1 && fila <= 3) {
                            tipologia = "vip";
                            prezzo = 8;
                        } else if (fila >= 4 && fila <= 7) {
                            tipologia = "premium";
                            prezzo = 6;
                        } else if (fila >= 8 && fila <= 15) {
                            tipologia = "base";
                            prezzo = 4;
                        } else
                            System.out.println("errore, dalla fila 1  alla 3 devi mettere vip, dalla 4 alla 7 premium e dalla 8 alla 15 base.");

                        PreparedStatement preparedStatement2 = connection.prepareStatement("INSERT INTO ombrellone VALUES (?,?,?,?)");
                        preparedStatement2.setInt(1, id_ombrellone);
                        preparedStatement2.setInt(2, prezzo);
                        preparedStatement2.setString(3, tipologia);
                        preparedStatement2.setInt(4, fila);
                        resultattr = preparedStatement2.executeUpdate() > 0;
                        if (resultattr) {
                            System.out.println("Ombrellone aggiunto correttamente");
                            risultato = true;
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return risultato;
    }

    public boolean removeOmbrellone(int id_ombrellone) {
        boolean result = false;
        ResultSet result2;
        boolean resultattr = false;
        boolean ombr_esistente = false;
        int id_ombr = 0;
        boolean risultato = false;
        boolean result3 = false;
        String tipologia = "";
        int prezzo = 0;
        try {
            result2 = connection.createStatement().executeQuery("SELECT id_ombrellone FROM ombrellone WHERE id_ombrellone='" + id_ombrellone + "'");

            if (result2.next() == false) {
                System.out.println("L'id dell'ombrellone non esiste, inserirne uno della lista.");
                ombr_esistente = false;
            } else {
                do {
                    id_ombr = result2.getInt("id_ombrellone");
                    ombr_esistente = true;
                } while (result2.next());
            }
            if (ombr_esistente) {
                try {
                    PreparedStatement preparedStatement3 = connection.prepareStatement("DELETE FROM ombrellone WHERE id_ombrellone= '" + id_ombrellone + "'");
                    result3 = preparedStatement3.executeUpdate() > 0;
                    if (result3) {
                        System.out.println("Ombrellone rimosso correttamente");
                        risultato = true;
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }


        } catch (
                Exception e) {
            System.out.println(e);
        }
        return risultato;
    }
}
