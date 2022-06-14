package com.unicam.cs.ids.casotto.Connectors;

import com.unicam.cs.ids.casotto.serviziospiaggia.PrenotazioneSpiaggia;

import java.sql.*;

public class PrenotazioneSpiaggiaConnector {
    Connection connection;
    private boolean a = true;

    public PrenotazioneSpiaggiaConnector() {
        try {
            connection = DBConnector.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /* public void aggiornaOmbrellone(String email, int id_ombrellone) {
        boolean result = false;
        boolean result2 = false;
        try {
            //CAMBIARE QUESTO: SARA' UN UPDATE MA CON PARSANDOGLI IL NUOVO OMBRELLONE PRENOTATO DALL'UTENTE
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE utente set id_ombrellone ='" + id_ombrellone + "' where email='" + email + "'");
            result = preparedStatement.executeUpdate() > 0;
            //PreparedStatement preparedStatement1 = connection.prepareStatement("UPDATE cliente set id_ombrellone ='" + id_ombrellone + "' where email='" + email + "'");
            //result2 = preparedStatement1.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("E' QUI IL PROBLEMA");
        }
    } */

    public boolean aggiornaOmbrelloniCliente(String email, int id_ombrellone) {
        boolean result = false;
        boolean prima_pren = false;
        if (a) System.exit(0); //esiste già una prenotazione esistente
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM cliente where email='" + email + "'AND id_ombrellone=0");
            while (resultSet.next()) {
                email = resultSet.getString("email");
                prima_pren = true;
            }
            if (prima_pren) {
                PreparedStatement preparedStatement3 = connection.prepareStatement("UPDATE cliente SET id_ombrellone='" + id_ombrellone + "'WHERE email='" + email + "'");
                result = preparedStatement3.executeUpdate() > 0;
                if (result) {
                    System.out.println("Ombrellone aggiornato");
                } else {
                    System.err.println("errore nell'aggiornare l'ombrellone");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        if (!prima_pren) {
            try {
                String nome = "";
                String cognome = "";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM utente where email='" + email + "'");
                int lastprenotazione = 0;
                while (resultSet.next()) {
                    nome = resultSet.getString("nome");
                    cognome = resultSet.getString("cognome");
                    email = resultSet.getString("email");
                }
                PreparedStatement preparedStatement2 = connection.prepareStatement("INSERT INTO cliente VALUES ('" + nome + "','" + cognome + "','" + email + "','" + id_ombrellone + "')");
                result = preparedStatement2.executeUpdate() > 0;
            } catch (Exception e) {
                System.out.println(e);
                System.err.println("errore nell'aggiornare l'ombrellone cliente");
            }
        }
        return result;
    }

    public boolean aggiornaOmbrelloniUtente(String email, int id_ombrellone) {
        boolean result = false;
        try {
            String nome = "";
            String cognome = "";
            String username = "";
            String password = "";
            String ruolo = "";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM utente where email='" + email + "'AND ruolo='cliente'");
            int lastprenotazione = 0;
            while (resultSet.next()) {
                username = resultSet.getString("username");
                password = resultSet.getString("password");
                ruolo = resultSet.getString("ruolo");
                email = resultSet.getString("email");
                nome = resultSet.getString("nome");
                cognome = resultSet.getString("cognome");

            }
            PreparedStatement preparedStatement2 = connection.prepareStatement("INSERT INTO utente VALUES ('" + username + "','" + password +
                    "','" + ruolo + "','" + email + "','" + nome + "','" + cognome + "','" + id_ombrellone + "')");
            result = preparedStatement2.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    public void setIdPrenotazione(int id_prenotazione) {
        PrenotazioneSpiaggia p = null;
        p.setId_prenotazione(id_prenotazione);
    }

    public boolean checkPrenotazioniOmbrellone(String email, int id_prenotazione) {
        boolean result = false;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM prenotazionespiaggia where email='" + email + "' AND id_prenotazione = '" + id_prenotazione + "'");
            if (resultSet.next()) {
                do {
                    result = true;
                } while (resultSet.next());
            } else result = false;
        } catch (Exception e) {
            System.err.println("errore");
            System.out.println(e);
        }
        return result;
    }

    public boolean checkPrenotazioniOmbrellone(String email) {
        boolean result = false;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM prenotazionespiaggia where email='" + email + "'");
            if (resultSet.next()) {
                do {
                    result = true;
                } while (resultSet.next());
            } else result = false;
        } catch (Exception e) {
            System.err.println("errore");
            System.out.println(e);
        }
        return result;
    }

    public boolean changeDate(Date data_inizio, Date data_fine, int id_ombrellone, String tipologia) {
        boolean result = false;
        boolean result2 = false;
        boolean result3 = false;
        boolean result4 = false;

        try {
            if (tipologia.equals("MATTINA")) {

                PreparedStatement preparedStatement1 = connection.prepareStatement("update prenotazionespiaggia set data_inizio_prenotazione = DATE_ADD(data_fine_prenotazione, INTERVAL 8 HOUR),  data_fine_prenotazione = DATE_ADD(data_fine_prenotazione, INTERVAL 14 HOUR) where id_ombrellone='" + id_ombrellone + "' AND data_inizio_prenotazione='" + data_inizio + "'AND data_fine_prenotazione='" + data_fine + "'");
                result2 = preparedStatement1.executeUpdate() > 0;
                // System.out.println(id_ombrellone);
                if (result2) {
                    //System.out.println("Data cambiata");
                    result = true;
                } else System.err.println("errore nel cambiare la data per la mattina.");
            }
            if (tipologia.equals("POMERIGGIO")) {
                PreparedStatement preparedStatement2 = connection.prepareStatement("update prenotazionespiaggia set data_inizio_prenotazione = DATE_ADD(data_fine_prenotazione, INTERVAL 14 HOUR),  data_fine_prenotazione = DATE_ADD(data_fine_prenotazione, INTERVAL 19 HOUR) where id_ombrellone='" + id_ombrellone + "'AND data_inizio_prenotazione='" + data_inizio + "'AND data_fine_prenotazione='" + data_fine + "'");
                result3 = preparedStatement2.executeUpdate() > 0;
                if (result3) {
                    System.out.println("Data cambiata");
                    result = true;
                } else System.err.println("errore nel cambiare la data. per il pomeriggio");
            }
            if (tipologia.equals("GIORNATA_INTERA")) {
                PreparedStatement preparedStatement3 = connection.prepareStatement("update prenotazionespiaggia set data_inizio_prenotazione = DATE_ADD(data_fine_prenotazione, INTERVAL 8 HOUR),  data_fine_prenotazione = DATE_ADD(data_fine_prenotazione, INTERVAL 19 HOUR) where id_ombrellone='" + id_ombrellone + "' AND data_inizio_prenotazione='" + data_inizio + "'AND data_fine_prenotazione='" + data_fine + "'");
                result4 = preparedStatement3.executeUpdate() > 0;
                if (result4) {
                    System.out.println("Data cambiata");
                    result = true;
                } else System.err.println("errore nel cambiare la data. per la giornata intera.");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    public boolean PrenotaSpiaggia(int id_prenotazione, Date data_inizio_prenotazione, Date data_fine_prenotazione, int num_fila_ombrellone, int id_ombrellone, int lettini, String email) {
        boolean result = false;
        boolean result2;
        boolean result3;
        boolean result5 = false;
        try {
            Statement statement = connection.createStatement();
            /* ResultSet resultSet2 = statement.executeQuery("SELECT data_inizio_prenotazione,data_fine_prenotazione,id_ombrellone last_id FROM prenotazionespiaggia WHERE " +
                    "data_inizio_prenotazione='" + data_inizio_prenotazione + "'AND data_fine_prenotazione='" + data_fine_prenotazione +
                    "'AND id_ombrellone='" + id_ombrellone + "'AND'" + data_inizio_prenotazione + "'" +
                    " BETWEEN data_inizio_prenotazione AND data_fine_prenotazione OR '" + data_fine_prenotazione +
                    "'BETWEEN data_inizio_prenotazione AND data_fine_pren"); */
            ResultSet resultSet2 = statement.executeQuery("SELECT data_inizio_prenotazione,data_fine_prenotazione,id_ombrellone as last_id FROM prenotazionespiaggia WHERE (data_inizio_prenotazione='" + data_inizio_prenotazione + "'AND data_fine_prenotazione='" + data_fine_prenotazione + "'AND'" + data_inizio_prenotazione + "' BETWEEN data_inizio_prenotazione AND data_fine_prenotazione OR '" + data_fine_prenotazione + "'BETWEEN data_inizio_prenotazione AND data_fine_prenotazione)AND id_ombrellone='" + id_ombrellone + "'");
            if (resultSet2.next()) {
                do {
                    a = true;
                    System.out.println("Esiste già una prenotazione per la data e/o l'id dell'ombrellone scelto");
                    System.exit(0);
                } while (resultSet2.next());
            } else a = false;
        } catch (Exception e) {
            // System.exit(0);
            // System.err.println("errore check disponbilita");
        }
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX(id_prenotazione) as last_id FROM prenotazionespiaggia;");
            int lastprenotazione = 0;
            while (resultSet.next()) {
                lastprenotazione = resultSet.getInt("last_id");
            }
            id_prenotazione = lastprenotazione + 1;
        } catch (Exception e) {
            System.out.println(e);
        }
        if (!a) try { //se a è false allora non ci sono prenotazioni esistenti

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO prenotazionespiaggia VALUES (?,?,?,?,?,?,?)  ");
            preparedStatement.setInt(1, id_prenotazione);
            preparedStatement.setDate(2, data_inizio_prenotazione);
            preparedStatement.setDate(3, data_fine_prenotazione);
            preparedStatement.setInt(4, num_fila_ombrellone);
            preparedStatement.setInt(5, id_ombrellone);
            preparedStatement.setInt(6, lettini);
            preparedStatement.setString(7, email);

            result5 = preparedStatement.executeUpdate() > 0;

            if (result5) {
                result = true;
                boolean prova = aggiornaOmbrelloniCliente(email, id_ombrellone);
                if (prova) System.out.println("Tabella Clienti aggiornata");
                try {
                    PreparedStatement preparedStatement1 = connection.prepareStatement("UPDATE chalet set quantita_ombrelloni_disponibili = quantita_ombrelloni_disponibili-1 where quantita_ombrelloni_disponibili>0");
                    //preparedStatement.setInt(1,lettini);
                    result2 = preparedStatement1.executeUpdate() > 0;
                    if (result2) {
                        System.out.println("Decrementazione ombrelloni effettuata!");
                        try {
                            PreparedStatement preparedStatement2 = connection.prepareStatement("UPDATE chalet set quantita_lettini_disponibili = quantita_lettini_disponibili-'" + lettini + "' where quantita_lettini_disponibili>0");
                            result3 = preparedStatement2.executeUpdate() > 0;
                            if (result3) {
                                System.out.println("Decrementazione lettini effettuata!");
                            } else System.err.println("errore: Decrementazione lettini NON Riuscita.");
                        } catch (Exception e) {
                            System.out.println(" update lettini");
                            System.out.println(e);
                        }
                    } else System.err.println("errore: Decrementazione ombrelloni NON Riuscita.");
                } catch (Exception e) {
                    System.out.println("update lettini e ombrelloni");
                    System.out.println(e);
                }
                System.out.print(email + ", ");
                System.out.println("hai effettuato la prenotazione con successo! \n");
            } else System.err.println("errore: Prenotazione NON Riuscita.");

        } catch (Exception e) {
            System.out.println(e);
            System.err.println("errore nell'inserire la prenotazione");
            result = false;
        }
        else {
            System.out.println("Esiste già una prenotazione relativa all'ombrellone relativo al periodo dal " + data_inizio_prenotazione + " al "
                    + data_fine_prenotazione + "\n" + "Riprovare con un'altra data o ombrellone.");

        }
        return result;
    }

    public void getOmbrelloniOccupati(Date data_inizio, Date data_fine) {
        boolean result;
        int id_ombrellone = 0;
        Date data_inizio_ = null;
        Date data_fine_ = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT p.id_ombrellone,p.data_inizio_prenotazione,p.data_fine_prenotazione FROM ombrellone o JOIN prenotazionespiaggia p on o.id_ombrellone=p.id_ombrellone where'" + data_inizio + "' BETWEEN p.data_inizio_prenotazione AND p.data_fine_prenotazione OR '" + data_fine + "'BETWEEN p.data_inizio_prenotazione AND p.data_fine_prenotazione");
            int lastordinazione = 0;
            while (resultSet.next()) {
                id_ombrellone = resultSet.getInt("p.id_ombrellone");
                data_inizio_ = resultSet.getDate("p.data_inizio_prenotazione");
                data_fine_ = resultSet.getDate("p.data_fine_prenotazione");
                System.out.print("Id : " + id_ombrellone + ", ");
                System.out.print("Data inizio: " + data_inizio_ + ", ");
                System.out.print("Data fine : " + data_fine_ + "; \t\n");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public int last_prenotazione(int id_ombrellone) {
        int i = 0;
        boolean result;
        int id_ordinazione = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id_prenotazione as last_id FROM prenotazionespiaggia WHERE id_prenotazione= (SELECT MAX(id_prenotazione) FROM prenotazionespiaggia WHERE id_ombrellone='" + id_ombrellone + "')");
            int lastordinazione = 0;
            while (resultSet.next()) {
                lastordinazione = resultSet.getInt("last_id");
            }
            id_ordinazione = lastordinazione;
        } catch (Exception e) {
            System.out.println(e);
        }
        return id_ordinazione;
    }

    public void ListaPrenotazioni() {
        boolean result = false;
        boolean result2 = false;
        boolean result3 = false;
        int id_ombrellone = 0;
        Date data_fine_prenotazione = null;
        int id_prenotazione = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id_prenotazione,id_ombrellone,data_fine_prenotazione FROM prenotazionespiaggia");
            int id = 0;
            int lettini = 0;

            while (resultSet.next()) {
                id_prenotazione = resultSet.getInt("id_prenotazione");
                id_ombrellone = resultSet.getInt("id_ombrellone");
                data_fine_prenotazione = resultSet.getDate("data_fine_prenotazione");
                System.out.print("Id prenotazione: " + id_prenotazione + ",");
                System.out.print("Id ombrellone: " + id_ombrellone + ",");
                System.out.print("Data fine prenotazione: " + data_fine_prenotazione + "; \t\n");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public boolean cancellazionePrenotazioneOmbrelloneAddettoSpiaggia(int id_prenotazione) {
        boolean result = false;
        boolean result2 = false;
        boolean result3 = false;
        int id_ombrellone = 0;
        Date data_fine_prenotazione = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id_prenotazione,id_ombrellone,data_fine_prenotazione FROM prenotazionespiaggia WHERE id_prenotazione='" + id_prenotazione + "'");
            int id = 0;
            int lettini = 0;

            while (resultSet.next()) {
                id_prenotazione = resultSet.getInt("id_prenotazione");
                id_ombrellone = resultSet.getInt("id_ombrellone");
                data_fine_prenotazione = resultSet.getDate("data_fine_prenotazione");
                lettini = resultSet.getInt("lettini");
                //   System.out.println("Id prenotazione: "+id_prenotazione+",\t");
                //    System.out.println("Id ombrellone: " +id_ombrellone+",\t");
                //      System.out.println("Data fine prenotazione: " +data_fine_prenotazione+",\t");
            }
            try {
                PreparedStatement preparedStatement3 = connection.prepareStatement("DELETE FROM prenotazionespiaggia WHERE id_prenotazione= '" + id_prenotazione + "'");
                result2 = preparedStatement3.executeUpdate() > 0;
                if (result2) {
                    PreparedStatement preparedStatement4 = connection.prepareStatement("UPDATE chalet set quantita_ombrelloni_disponibili = quantita_ombrelloni_disponibili +1, quantita_lettini_disponibili= quantita_lettini_disponibili +'" + lettini + "'");
                    result3 = preparedStatement4.executeUpdate() > 0;
                    if (result3) {
                        System.out.println("Lettini e ombrelloni disponibili nello chalet aggiornati");
                        System.out.println("Cancellazione della prenotazione effettuata!");
                        result = true;
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
                result2 = false;
            }

        } catch (Exception e) {
            System.out.println(e);
            result = false;
        }

        return result;
    }

    public boolean cancellazionePrenotazione(int id_prenotazione) {
        boolean result = false;
        boolean result2 = false;
        boolean result3 = false;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id_ombrellone,lettini FROM prenotazionespiaggia WHERE id_prenotazione='" + id_prenotazione + "'");
            int id_ombrellone = 0;
            int lettini = 0;
            while (resultSet.next()) {
                id_ombrellone = resultSet.getInt("id_ombrellone");
                lettini = resultSet.getInt("lettini");
            }
            try {
                PreparedStatement preparedStatement3 = connection.prepareStatement("DELETE FROM prenotazionespiaggia WHERE id_prenotazione= '" + id_prenotazione + "'");
                result2 = preparedStatement3.executeUpdate() > 0;
                if (result2) {
                    PreparedStatement preparedStatement4 = connection.prepareStatement("UPDATE chalet set quantita_ombrelloni_disponibili = quantita_ombrelloni_disponibili +1, quantita_lettini_disponibili= quantita_lettini_disponibili +'" + lettini + "'");
                    result3 = preparedStatement4.executeUpdate() > 0;
                    if (result3) {
                        System.out.println("Lettini e ombrelloni disponibili nello chalet aggiornati");
                        System.out.println("Cancellazione della prenotazione effettuata!");
                        result = true;
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
                result2 = false;
            }

        } catch (Exception e) {
            System.out.println(e);
            result = false;
        }

        return result;
    }

    public boolean listaPrenotazioni(String email) {
        boolean result = false;
        try {
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM prenotazionespiaggia where email='" + email + "'");
            while (resultSet.next()) {
                System.out.println("id prenotazione: " + resultSet.getString("id_prenotazione") + "\t");
                System.out.print("Dal " + resultSet.getDate("data_inizio_prenotazione") + "  al \t");
                System.out.print(resultSet.getDate("data_fine_prenotazione") + "\t\n");
                System.out.println("Lettini: " + resultSet.getInt("lettini"));
                System.out.println("----------------------------------------");
            }
        } catch (Exception e) {
            System.out.println(e);
            result = false;
        }
        return result;
    }
}
