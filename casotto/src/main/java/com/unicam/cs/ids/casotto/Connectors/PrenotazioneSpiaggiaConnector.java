package com.unicam.cs.ids.casotto.Connectors;

import com.unicam.cs.ids.casotto.Cliente;

import java.sql.*;

public class PrenotazioneSpiaggiaConnector {
    Connection connection;


    public PrenotazioneSpiaggiaConnector() {
        try {
            connection = DBConnector.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        } //a
    }

    public void aggiornaOmbrellone(String email, int id_ombrellone) {
        boolean result = false;
        boolean result2 = false;
        try {

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE utente set id_ombrellone ='" + id_ombrellone + "' where email='" + email + "'");
            result = preparedStatement.executeUpdate() > 0;
            PreparedStatement preparedStatement1 = connection.prepareStatement("UPDATE cliente set id_ombrellone ='" + id_ombrellone + "' where email='" + email + "'");
            result2 = preparedStatement1.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public boolean PrenotaSpiaggia(int id_prenotazione, Date data_inizio_prenotazione, Date data_fine_prenotazione, int num_fila_ombrellone, int id_ombrellone, int lettini, String email) {
        boolean result = false;
        boolean result2 = false;
        boolean result3 = false;
        boolean result4 = false;
        boolean result5 = false;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id_prenotazione as last_id FROM prenotazionespiaggia WHERE id_prenotazione= (SELECT MAX(id_prenotazione) FROM prenotazionespiaggia)");
            int lastprenotazione = 0;
            while (resultSet.next()) {
                lastprenotazione = resultSet.getInt("last_id");
            }
            id_prenotazione = lastprenotazione + 1;
        } catch (Exception e) {
            System.out.println(e);
            result5 = false;
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO prenotazionespiaggia VALUES (?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, id_prenotazione);
            preparedStatement.setDate(2, data_inizio_prenotazione);
            preparedStatement.setDate(3, data_fine_prenotazione);
            preparedStatement.setInt(4, num_fila_ombrellone);
            preparedStatement.setInt(5, id_ombrellone);
            preparedStatement.setInt(6, lettini);
            preparedStatement.setString(7, email);


            result = preparedStatement.executeUpdate() > 0;
            if (result) {
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
                                try {
                                    PreparedStatement preparedStatement3 = connection.prepareStatement("UPDATE ombrellone set disponibilita = 0 where id_ombrellone='" + id_ombrellone + "'");
                                    result4 = preparedStatement3.executeUpdate() > 0;
                                    if (result4)
                                        System.out.println("Disponibilità dell'ombrellone " + id_ombrellone + " cambiata");
                                } catch (Exception e) {
                                    System.out.println(e);
                                    result4 = false;
                                }

                            } else System.out.println("Decrementazione lettini NON Riuscita.");
                        } catch (Exception e) {
                            System.out.println(e);
                            result3 = false;
                        }

                    } else System.out.println("Decrementazione ombrelloni NON Riuscita.");
                } catch (Exception e) {
                    System.out.println(e);
                    result2 = false;
                }
                System.out.print(email + ", ");
                System.out.println("hai effettuato la prenotazione con successo! \n");
            } else System.out.println("Prenotazione NON Riuscita.");
        } catch (Exception e) {
            System.out.println(e);
            result = false;
        }
        return result;
    }

    public int last_prenotazione(int id_ombrellone) {
        int i = 0;
        boolean result;
        int id_ordinazione = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id_prenotazione as last_id FROM prenotazionespiaggia WHERE id_prenotazione= (SELECT MAX(id_prenotazione) FROM ordinazionebar WHERE id_ombrellone='" + id_ombrellone + "')");
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
                PreparedStatement preparedStatement2 = connection.prepareStatement("UPDATE ombrellone set disponibilita = 1 where id_ombrellone='" + id_ombrellone + "'");
                result = preparedStatement2.executeUpdate() > 0;
                if (result) {
                    try {
                        PreparedStatement preparedStatement3 = connection.prepareStatement("DELETE FROM prenotazionespiaggia WHERE id_prenotazione= '" + id_prenotazione + "'");
                        result2 = preparedStatement3.executeUpdate() > 0;
                        if (result2) {
                            //aggiornare posti chalet
                            PreparedStatement preparedStatement4 = connection.prepareStatement("UPDATE chalet set quantita_ombrelloni_disponibili = quantita_ombrelloni_disponibili +1, quantita_lettini_disponibili= quantita_lettini_disponibili +'" + lettini + "'");
                            result3 = preparedStatement4.executeUpdate() > 0;
                            if (result3) System.out.println("Lettini e ombrelloni disponibili nello chalet aggiornati");
                            System.out.println("Cancellazione della prenotazione effettuata!");
                        }
                        System.out.println("Disponibilità dell'ombrellone cambiata!");
                    } catch (Exception e) {
                        System.out.println(e);
                        result2 = false;
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
                result = false;
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
                System.out.print(resultSet.getDate("data_inizio_prenotazione") + "\t");
                System.out.print(resultSet.getDate("data_fine_prenotazione") + "\t\n");
                ;
            }
            //if (result) System.out.println("lista prenotazioni: ");
            // else System.out.println("error");

        } catch (Exception e) {
            System.out.println(e);
            result = false;
        }
        return result;
    }
}
