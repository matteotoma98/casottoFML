package com.unicam.cs.ids.casotto.Connectors;

import com.unicam.cs.ids.casotto.serviziobar.OrdinazioneBar;

import java.sql.Date;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class OrdinazioneBarConnector {

    Connection connection;
    private int id_ombrellone;

    public OrdinazioneBarConnector() {
        try {
            connection = DBConnector.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public Date getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
        Date date = new Date(System.currentTimeMillis());
        // System.out.println(formatter.format(date));
        // System.out.println(date);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        // System.out.println("yyyy/MM/dd HH:mm:ss-> "+dtf.format(LocalDateTime.now()));
        return date;
    }

    public int getId() {
        return this.id_ombrellone;
    }

    public ResultSet getIdOmbrelloni(String email) {
        boolean result = false;
        Scanner scanner2 = new Scanner(System.in);
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT id_ombrellone, id_prenotazione, timediff(data_fine_prenotazione,data_inizio_prenotazione) as diff FROM prenotazionespiaggia WHERE email='"+email+"'AND data_fine_prenotazione>=now() AND data_inizio_prenotazione<=now() GROUP BY id_ombrellone,id_prenotazione");
            List<Integer> l = new ArrayList<>();
            while (resultSet.next()) {
                System.out.println("Lista dei tuoi ombrelloni:\n" + resultSet.getInt("id_ombrellone"));
                l.add(resultSet.getInt("id_ombrellone"));
            }
            //LocalDate.now();
            do {
                int id_ombrellone = scanner2.nextInt();
                this.id_ombrellone = id_ombrellone;
                if (!l.contains(id_ombrellone)) {
                    System.err.println("Errore: Hai immesso un id dell'ombrellone errato.");
                    System.out.println("Reinserisci il tuo id dell'ombrellone");
                }
            } while (!l.contains(id_ombrellone));

        } catch (Exception e) {
            System.out.println(e);
        }
        return resultSet;
    }

    public int last_ordinazione(int id_ombrellone) {
        int i = 0;
        boolean result;
        int id_ordinazione = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id_ordinazione as last_id FROM ordinazionebar WHERE id_ordinazione= (SELECT MAX(id_ordinazione) FROM ordinazionebar WHERE id_ombrellone='" + id_ombrellone + "')");
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

    public boolean addOrdine(OrdinazioneBar ordinazione_bar) {
        //  int i = 0;
        boolean result;
        boolean result2;
        int id_ordinazione = 0;
        String lista_prodotti;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id_ordinazione as last_id FROM ordinazionebar WHERE id_ordinazione= (SELECT MAX(id_ordinazione) FROM ordinazionebar)");
            int lastordinazione = 0;
            while (resultSet.next()) {
                lastordinazione = resultSet.getInt("last_id");
            }
            id_ordinazione = lastordinazione + 1;
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            /*for(Integer i: ordinazione_bar.getLista_prodotti()){
                lista_prodotti= "lista_prodotti"+i+", ";

                System.out.println(i);
            }*/
            int last_element = ordinazione_bar.getLista_prodotti().size() + 2;
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();

            for (Map.Entry<Integer, Integer> entry : ordinazione_bar.getLista_prodotti().entrySet()) {
                if (entry.getKey() != last_element)
                    sb.append(entry.getKey() != null ? entry.getKey() + "," : "");

                else
                    sb.append(entry.getKey() != null ? entry.getKey().toString() : "");
            }
            for (Map.Entry<Integer, Integer> entry : ordinazione_bar.getLista_prodotti().entrySet()) {
                if (entry.getKey() != last_element)
                    sb2.append(entry.getValue() != null ? entry.getValue() + "," : "");
                else
                    sb2.append(entry.getValue() != null ? entry.getValue().toString() : "");
            }
            // System.out.println("The number string = " + sb.substring(0, sb.length() - 1));
            // System.out.println("The number string = " + sb2.substring(0, sb2.length() - 1));
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ordinazionebar VALUES ( ?,?,?,?,?)");
            preparedStatement.setDate(1, ordinazione_bar.setData_ordinazione(getDate()));
            //System.out.println("L'ombrellone su cui hai richiesto è "+ordinazione_bar.getId_ombrellone());
            preparedStatement.setInt(2, ordinazione_bar.getId_ombrellone());
            preparedStatement.setInt(3, ordinazione_bar.setId_ordinazione(id_ordinazione));
            preparedStatement.setString(4, String.valueOf(sb2.substring(0, sb.length() - 1)));
            //  preparedSatementt.setInt(5, ordinazione_bar.getId_prodotto());
            preparedStatement.setString(5, String.valueOf(sb.substring(0, sb.length() - 1)));
            calcolaPrezzoOrdine(ordinazione_bar.getId_prodotto(), ordinazione_bar.getQuantita());
            // INSERT INTO ordinazionebar VALUES ('2022/05/05',1,1,1,1);
            result = preparedStatement.executeUpdate() > 0;
            if (result) decrementaProdotto(ordinazione_bar.getLista_prodotti());
        } catch (Exception e) {
            System.out.println(e);
            result = false;
            System.err.println("errore: Ordinazione non riuscita");
        }
        return result;
    }

    public void decrementaProdotto(Map<Integer, Integer> lista_prodotti) {
        boolean result = false;
        boolean controllo = false;
        try {

            Iterator<Map.Entry<Integer, Integer>> it = lista_prodotti.entrySet().iterator();

            while (it.hasNext()) {
                Map.Entry<Integer, Integer> pairs = it.next();
                //System.out.println("Pairs get key: "+pairs.getKey().toString());
                //System.out.println("Pairs get value: "+pairs.getValue().toString());
                it.remove(); // avoids a ConcurrentModificationException
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE prodottibar SET" +
                        " quantita= quantita-'" + pairs.getValue() + "' WHERE id_prodotto=" + pairs.getKey());
                if (preparedStatement.executeUpdate() > 0) controllo = true;
            }
            if (controllo) System.out.println("Prodotti decrementati");
            //   if (result) System.out.println("Quantità del prodotto " + id + " diminuita.");
        } catch (Exception e) {
            System.out.println(e);
            System.err.println("errore: problema nel decremento");
        }
    }

    public double calcolaPrezzoOrdine(int id, int quantita) {
        ResultSet result;
        double prezzo_totale = 0.0;
        try {
            result = connection.createStatement().executeQuery("SELECT '" + quantita + "'*prezzo as totale FROM prodottibar WHERE id_prodotto = " + id);
            while (result.next()) {
                prezzo_totale = result.getDouble("totale");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        //add exception here
        return prezzo_totale;
    }

    public String getQuantitaProdotti(int id_ordinazione) {
        boolean result = false;
        boolean controllo = false;
        String quantita = "";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT quantita FROM ordinazionebar WHERE id_ordinazione='" + id_ordinazione + "'");
            while (resultSet.next()) {
                quantita = resultSet.getString("quantita");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return quantita;
    }

    public String getNomeProdotti(int id_prodotto) {
        boolean result = false;
        boolean controllo = false;
        String prodotti = "";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT nome_prodotto FROM prodottibar WHERE id_prodotto='" + id_prodotto + "'");
            while (resultSet.next()) {
                prodotti = resultSet.getString("nome_prodotto");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return prodotti;
    }

    public int getTempoProdotti(Map<Integer, Integer> prodotti) {
        boolean result = false;
        boolean controllo = false;
        int tempo = 0;
        Set<Integer> id_prodotti = prodotti.keySet();
        Collection<Integer> quantita = prodotti.values();
        for (Integer id : id_prodotti) {
            for (Integer qta : quantita) {
                try {
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT tempo_preparazione FROM prodottibar WHERE id_prodotto='" + id + "'");
                    while (resultSet.next()) {

                        tempo = tempo + (qta * resultSet.getInt("tempo_preparazione"));
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }

        return tempo / id_prodotti.size();
    }

    public String getListaProdotti(int id_ordinazione) {
        boolean result = false;
        boolean controllo = false;
        String prodotti = "";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT lista_prodotti FROM ordinazionebar WHERE id_ordinazione='" + id_ordinazione + "'");
            while (resultSet.next()) {
                prodotti = resultSet.getString("lista_prodotti");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return prodotti;
    }
/*
    public List<Ordinazione_Bar> getOrdini() {
        ResultSet result;
        List<Ordinazione_Bar> resultList = new ArrayList<Ordinazione_Bar>();
        try {
            result = connection.createStatement().executeQuery("SELECT * FROM ordinazionebar");

            while (result.next()) {
                resultList.add(convertiRisultatoInOrdine(result));
            }
        } catch (Exception e)
        { System.out.println(e); } //add exception here

        //error checking
        if (resultList.isEmpty())
            System.out.println("Empty result");

        return resultList;
    }

 */


}
