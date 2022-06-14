package com.unicam.cs.ids.casotto.Connectors;

import com.unicam.cs.ids.casotto.OpenApp;
import com.unicam.cs.ids.casotto.utenti.Cliente;

import java.sql.*;
import java.util.Date;
import java.util.Scanner;

public class AttivitaConnector {

    Connection connection;

    public AttivitaConnector() {
        try {
            connection = DBConnector.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        } //add exception here
    }

    public int last_attivita() {
        boolean result;
        int id_attivita = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT  MAX(id_attivita) as last_id FROM attivita");
            int last_attivita = 0;
            while (resultSet.next()) {
                last_attivita = resultSet.getInt("last_id");
            }
            id_attivita = last_attivita + 1;
        } catch (Exception e) {
            System.out.println(e);
        }
        return id_attivita;
    }

    public boolean addAttivita(String nome_attivita, String nome_attrezzatura, int quantita) {
        int id_attivita = last_attivita();
        boolean aggiunta = false;
        boolean risultato = false;
        //error checking
        boolean result = false;
        boolean resultattr = false;
        boolean attresistente = false;
        boolean attivitaesistente = false;
        ResultSet result3;
        ResultSet result2;
        try {
            result3 = connection.createStatement().executeQuery("SELECT nome_attivita FROM attivita WHERE nome_attivita='" + nome_attivita + "'");
            while (result3.next()) {
                nome_attivita = result3.getString("nome_attivita");
                if (nome_attivita.isEmpty()) attivitaesistente = false;
                else {
                    attivitaesistente = true;
                    System.err.println("errore: esiste già quest'attività, inserirne un'altra diversa.");
                }
            }
            try {
                result2 = connection.createStatement().executeQuery("SELECT nome_attrezzatura FROM attrezzatura WHERE nome_attrezzatura='" + nome_attrezzatura + "'");
                while (result2.next()) {
                    String nome_attr = result2.getString("nome_attrezzatura");
                    if (nome_attr.isEmpty()) attresistente = false;
                    else {
                        attresistente = true;
                        if (attresistente)
                            System.err.println("errore: esiste già questa attrezzatura, inserirne un'altra diversa.");
                    }
                }
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
                } else if (!attivitaesistente && attresistente) {
                    try {
                        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO attivita VALUES (?,NULL,?,?,?,NULL,NULL)");
                        preparedStatement.setString(1, nome_attivita);
                        preparedStatement.setInt(2, id_attivita);
                        preparedStatement.setString(3, nome_attrezzatura);
                        preparedStatement.setInt(4, quantita);
                        result = preparedStatement.executeUpdate() > 0;
                        if (result) {
                            System.out.println("non ci sono attività con questo nome, verrà quindi inserita.");
                            System.out.println("Attività aggiunta correttamente");
                            risultato = true;
                            aggiunta = true;
                            //decrementare la quantità dell'attrezzatura disponibile dalla tabella attrezzatura
                            try {
                                boolean result4 = false;
                                PreparedStatement preparedStatement1 = connection.prepareStatement("UPDATE attrezzatura set quantita = quantita-'" + quantita + "' where quantita>0 AND nome_attrezzatura='" + nome_attrezzatura + "'");
                                //preparedStatement.setInt(1,lettini);
                                result4 = preparedStatement1.executeUpdate() > 0;
                                if (result4) System.out.println("Quantità delle attrezzature disponibili aggiornate");
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            if (attresistente && aggiunta) {
                risultato = true;
            } else if (attivitaesistente) {
                // System.out.println("Esiste già questa attività, inserirne un'altra.");
                risultato = false;
            }

            // else System.out.println("Non esiste l'attrezzatura nello chalet per inserire l'attività.");
        } catch (Exception e) {
            System.out.println(e);
            System.err.println("errore nel cercare l'attrezzatura");
        }
        return risultato;
    }

    public int getMax() throws Exception {
        ResultSet result2;
        int max = 0;
        result2 = connection.createStatement().executeQuery("SELECT MAX(id_attivita) FROM attivita");
        if (result2.next()) {
            max = result2.getInt("MAX(id_attivita)");
        }
        return max;
    }

    public ResultSet getAttivita() {
        ResultSet result = null;
        Cliente cliente = new Cliente();
        //Date data= Date.valueOf(java.time.LocalDate.now());
        try {
            result = connection.createStatement().executeQuery("SELECT id_attivita, nome_attivita,data_inizio_attivita, data_fine_attivita,num_posti FROM attivita ORDER BY id_attivita");
            while (result.next()) {
                System.out.print("id attività: ");
                System.out.print(result.getInt("id_attivita") + ", ");
                System.out.print(result.getString("nome_attivita") + ", data inizio attività: ");
                System.out.print(result.getTimestamp("data_inizio_attivita") + ", data fine attività: ");
                System.out.print(result.getTimestamp("data_fine_attivita") + " , numero posti disponibili: ");
                System.out.print(result.getInt("num_posti"));
                System.out.println();
            }
              /*ResultSet resultSet = statement.executeQuery("select * from chalet ");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("quantita_lettini"));
            } */
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }


    public int last_prenotazione(String email) {

        boolean result;
        int id_prenotazione = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id_prenotazione_attivita as last_id FROM prenotazioneattivita WHERE id_prenotazione_attivita= (SELECT MAX(id_prenotazione_attivita) FROM prenotazioneattivita)");
            int last_prenotazione = 0;
            while (resultSet.next()) {
                last_prenotazione = resultSet.getInt("last_id");
            }
            id_prenotazione = last_prenotazione + 1;
        } catch (Exception e) {
            System.out.println(e);
        }
        return id_prenotazione;
    }


    public boolean addPrenotazione(String email, int id, int num_posti) throws IllegalArgumentException {
        ResultSet result;
        ResultSet result4;
        boolean result2 = false;
        boolean result3 = false;
        Date data_inizio_attivita = null;
        Date data_fine_attivita = null;
        try {
            result = connection.createStatement().executeQuery("SELECT id_attivita,data_inizio_attivita,data_fine_attivita FROM attivita WHERE id_attivita='" + id + "'");
            while (result.next()) {
                data_inizio_attivita = result.getTimestamp("data_inizio_attivita");
                data_fine_attivita = result.getTimestamp("data_fine_attivita");
            }
            try {
                result4 = connection.createStatement().executeQuery("SELECT id_attivita, num_posti FROM attivita WHERE num_posti >='" + num_posti + "'AND id_attivita='" + id + "'");
                if (result4.next() == false) {
                    System.out.println("Posti non disponibili per l'attività, provare a diminuire il numero dei posti");
                } else {

                    PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO prenotazioneattivita VALUES (?,?,?,?,?,?)");
                    preparedStatement.setString(1, email);
                    preparedStatement.setTimestamp(2, (Timestamp) data_inizio_attivita);
                    preparedStatement.setTimestamp(3, (Timestamp) data_fine_attivita);
                    preparedStatement.setInt(4, id);
                    preparedStatement.setInt(5, num_posti);
                    preparedStatement.setInt(6, last_prenotazione(email));
                    result2 = preparedStatement.executeUpdate() > 0;
                    if (result2) {
                        PreparedStatement preparedStatement3 = connection.prepareStatement("UPDATE attivita set num_posti= num_posti-'" + num_posti + "'WHERE id_attivita='" + id + "'"); //"'WHERE num_posti>=0 );
                        result3 = preparedStatement3.executeUpdate() > 0;
                        System.out.println("Prenotazione effettuata");
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
                result3 = false;
            }
            // throw new IllegalArgumentException("hai prenotato troppi posti rispetto a quelli disponibili");
        } catch (Exception e) {
            System.out.println(e);
        }
        return result2 = true;
    }

    public boolean rimuoviAttivita(String nomeAttivita) {
        ResultSet result;
        boolean result2 = false;
        boolean result3 = false;
        boolean risultato = false;
        int quantitaAttr = 0;
        String nome_attrezz = "";
        String nomeAttivita2 = "";
        Scanner scanner = new Scanner(System.in);
        try {
            result = connection.createStatement().executeQuery("SELECT quantita,nome_attrezzatura FROM attivita WHERE nome_attivita='" + nomeAttivita + "'");
            while (!result.next()) {
                //if (!result.next()) {
                System.err.println("--- Nome attivita non valido ---\n");
                OpenApp o = new OpenApp();
                o.Open();
                /*System.out.println("Reinserisci il nome dell'attività");
                nomeAttivita2 = scanner.next();
                result = connection.createStatement().executeQuery("SELECT quantita,nome_attrezzatura FROM attivita WHERE nome_attivita='" + nomeAttivita2 + "'");
                if(result.next()){
                    risultato=  true;
                    break;
                }*/
            }
            while (result.next()) {
                quantitaAttr = result.getInt("quantita");
                nome_attrezz = result.getString("nome_attrezzatura");
                try {
                    PreparedStatement preparedStatement3 = connection.prepareStatement("DELETE FROM attivita WHERE nome_attivita= '" + nomeAttivita + "'");
                    result2 = preparedStatement3.executeUpdate() > 0;
                    if (result2) {
                        System.out.println("Attività rimossa.");
                        PreparedStatement preparedStatement4 = connection.prepareStatement("UPDATE attrezzatura set quantita = quantita +'" + quantitaAttr + "'WHERE nome_attrezzatura='" + nome_attrezz + "'");
                        result3 = preparedStatement4.executeUpdate() > 0;
                        if (result3) {
                            System.out.println("Quantità attrezzatura aggiornata");
                            risultato = true;
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e);
                    result2 = false;
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return risultato;
    }
}


