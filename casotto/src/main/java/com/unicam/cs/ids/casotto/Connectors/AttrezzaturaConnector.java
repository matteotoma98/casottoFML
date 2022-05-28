package com.unicam.cs.ids.casotto.Connectors;

import com.unicam.cs.ids.casotto.utenti.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AttrezzaturaConnector {
    Connection connection;

    public AttrezzaturaConnector() {

        try {
            connection = DBConnector.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        } //add exception here
    }

    public boolean addAttrezzatura(String nome_attrezzatura, int quantita) {
        boolean result = false;
        ResultSet result2;
        boolean resultattr = false;
        boolean attresistente = false;
        boolean risultato = false;
        try {
            result2 = connection.createStatement().executeQuery("SELECT nome_attrezzatura FROM attrezzatura WHERE nome_attrezzatura='" + nome_attrezzatura + "'");
            while (result2.next()) {
                String nome_attr = result2.getString("nome_attrezzatura");
                if (nome_attr.isEmpty()) attresistente = false;
                else {
                    attresistente = true;
                    if (attresistente)
                        System.out.println("esiste già questa attrezzatura, inserirne un'altra diversa.");
                }
            }
            try {
                if (!attresistente) {
                    System.out.println("Non c'è un'attrezzatura per questo nome con questo nome, verrà quindi inserita.");
                    try {
                        PreparedStatement preparedStatement2 = connection.prepareStatement("INSERT INTO attrezzatura VALUES (?,?,NULL)");
                        preparedStatement2.setString(1, nome_attrezzatura);
                        preparedStatement2.setInt(2, quantita);
                        resultattr = preparedStatement2.executeUpdate() > 0;
                        if (resultattr) {
                            System.out.println("Attrezzatura aggiunta correttamente");
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

    public ResultSet getAttrezzatura() {
        ResultSet result = null;
        Cliente cliente = new Cliente();
        try {
            result = connection.createStatement().executeQuery("SELECT nome_attrezzatura,quantita FROM attrezzatura");
            while (result.next()) {
                System.out.print(result.getString("nome_attrezzatura"));
                System.out.print(",quantita: ");
                System.out.print(result.getInt("quantita") + "\n");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;

    }

    public boolean modificaAttrezzatura(String nome_attrezzatura, int quantita_attrezzatura) {
        boolean result = false;
        ResultSet result2;
        boolean risultato = false;
        boolean attr_trovata = false;
        String nome_attr = "";
        try {
            result2 = connection.createStatement().executeQuery("SELECT nome_attrezzatura FROM attrezzatura WHERE nome_attrezzatura='" + nome_attrezzatura + "'");

            if (result2.next() == false) {
                System.out.println("Il nome dell'attrezzatura da modificare non esiste, inserirne una dalla lista.");
                attr_trovata=false;
            } else {
                do {
                    result2.getString("nome_attrezzatura");
                    attr_trovata = true;
                } while (result2.next());
            }


            try {
                if (attr_trovata) {
                    try {
                        PreparedStatement preparedStatement3 = connection.prepareStatement("UPDATE attrezzatura set quantita='" + quantita_attrezzatura + "'WHERE nome_attrezzatura='" + nome_attrezzatura + "'"); //"'WHERE num_posti>=0 );
                        result = preparedStatement3.executeUpdate() > 0;
                        if (result) {
                            System.out.println("Quantità relativa all'attrezzatura " + nome_attrezzatura + " aggiornata.");
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
}
