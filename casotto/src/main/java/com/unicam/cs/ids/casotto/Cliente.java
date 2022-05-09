package com.unicam.cs.ids.casotto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.sql.Date;

import com.unicam.cs.ids.casotto.Connectors.OrdinazioneBarConnector;
import com.unicam.cs.ids.casotto.Connectors.PrenotazioneSpiaggiaConnector;
import com.unicam.cs.ids.casotto.Connectors.Prodotti_BarConnector;

import javax.xml.crypto.Data;

public class Cliente extends Utente implements ICliente {
    private String nome;
    String scelta;
    private String cognome;
    private String email;
    private int id_ombrellone = 0;
    private Prodotti_BarConnector cp = new Prodotti_BarConnector();
    private OrdinazioneBarConnector obc = new OrdinazioneBarConnector();
    private PrenotazioneSpiaggiaConnector prenotazioneSpiaggiaConnector = new PrenotazioneSpiaggiaConnector();
    DateTimeFormatter data_ordinazione;
    private int quantita;
    private int id_ordinazione;
    private int id_prodotto;
    Date data_pagamento = Date.valueOf(LocalDate.now());
    public static final DateTimeFormatter date_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    // private Ordinazione_Bar ob= new Ordinazione_Bar(obc.getDate(), quantita, , id_ombrellone, id_prodotto);
    public ArrayList<Prenotazione_Spiaggia> effettua = new ArrayList<Prenotazione_Spiaggia>();

    public Cliente(String nome, String cognome, String email, int id_ombrellone) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.id_ombrellone = id_ombrellone;
    }


    public void PrenotazioneOmbrellone(Data aData_inizio, Data aData_fine) {
        throw new UnsupportedOperationException();
    }

    public void iscrizione_Attivita(Attivita attivita) {

        attivita.getId_attivita();
        throw new UnsupportedOperationException();
    }

    public Cliente() {
    }

    public Cliente(String username, String password, String ruolo, String nome, String cognome, String email, int id_ombrellone) {
        super(email, username, password, ruolo, nome, cognome, id_ombrellone);

        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.id_ombrellone = id_ombrellone;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public void registrazione(String email, String username, String password, int id_ombrellone) {

    }

    public void setEmail(String email) {
        this.email = email;
    }


    public int getId_ombrellone() {
        return id_ombrellone;
    }

    public void setId_ombrellone(int id_ombrellone) {
        this.id_ombrellone = id_ombrellone;
    }


    public void PrenotazioneOmbrellone(String email) {
        this.id_ombrellone = cc.getOmbrellone(email);
        String scelta;
        String tipologia;
        double totale;
        int continuaAcquisti;
        int id_ordinazione = 0;
        int id_prodotto = 0;
        int quantita = 0;

        double prezzo_totale = 0;
        int id_scontrino = 0;
        int id_prenotazione = 0;

        double prezzo = 0;
        Tariffa_Prezzi tariffaPrezzi = new Tariffa_Prezzi();
        Prenotazione_Spiaggia prenotazione_spiaggia = new Prenotazione_Spiaggia();
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Inserisci il giorno d'inizio della prenotazione:");
        String date_start = scanner.nextLine(); // String str="2015-03-31";
        Date start_date = Date.valueOf(date_start);//converting string into sql date
        //  System.out.println(start_date);
        prenotazione_spiaggia.setDatainizioPrenotazione(start_date);
        System.out.println("Inserisci il giorno di fine della prenotazione:");
        String date_end = scanner.nextLine();// String str="2015-03-31";
        Date end_date = Date.valueOf(date_end);//converting string into sql date
        //  System.out.println(start_date);
        prenotazione_spiaggia.setData_finePrenotazione(end_date);
        System.out.println("Inserisci il giorno di fine della prenotazione:");
        int scelta_fascia_oraria;
        String fasciaOraria = null;

        System.out.println("Scegli in quale fascia oraria vuoi prenotare:");
        System.out.println("1: Mattina ");
        System.out.println("2: Pomeriggio ");
        System.out.println("3: Giornata Intera ");

        scelta_fascia_oraria = scanner.nextInt();

        switch (scelta_fascia_oraria) {
            case 1:
                fasciaOraria = "";
                fasciaOraria = String.valueOf(FasciaOraria.MATTINA);
                break;
            case 2:
                fasciaOraria = String.valueOf(FasciaOraria.POMERIGGIO);
                break;
            case 3:
                fasciaOraria = String.valueOf(FasciaOraria.GIORNATA_INTERA);
                break;
        }

        /* int scelta_tipologia;
        System.out.println("Scegli quale tipologia di ombrellone vuoi prenotare: ");
        System.out.println("1: VIP ");
        System.out.println("2: PREMIUM ");
        System.out.println("3: BASE");
        scelta_tipologia = scanner.nextInt();
        switch (scelta_tipologia) {
            case 1:
                String tipologia_ombr = "";
                tipologia_ombr = String.valueOf(Tipologia.VIP);
                break;
            case 2:
                tipologia_ombr= String.valueOf(Tipologia.PREMIUM);
                break;
            case 3:
                tipologia_ombr = String.valueOf(Tipologia.BASE);
                break;
        } */


        System.out.println("Inserisci la fila dell'ombrellone:(FILA 1-3: VIP, FILA 4-7: PREMIUM, FILA 8-15: BASE)");
        //querychemostra la lista delle file
        int fila = 0;
        fila = scanner.nextInt();
        Ombrellone om = new Ombrellone();
        om.setNum_fila_ombrellone(fila);

        System.out.println("Inserisci l'id dell'ombrellone che vuoi prenotare");
        //querychemostra la lista degli ombrelloni
        int id = scanner.nextInt();
        om.setId_ombrellone(id);

        System.out.println("Inserisci la quantità di lettini che vuoi prenotare");
        //querychemostra la lista degli ombrelloni
        int lettini = scanner.nextInt();
        Chalet chalet = new Chalet();

        prezzo = prezzo + tariffaPrezzi.Imposta_Prezzi_Spiaggia(FasciaOraria.valueOf(fasciaOraria), fila, date_start, date_end, lettini);

        //  System.out.println("Totale:" + totale);
        System.out.println("Scegli la tipologia di pagamento:app -tramite app, arrivo -pagamento all'arrivo");
        tipologia = scanner2.nextLine();

        if (tipologia.equals("app")) {
            System.out.println("Inserisci i dati della carta per il pagamento");
            String carta;
            do {
                carta = scanner2.nextLine();
                if (carta.length() != 16)
                    System.out.println("Errore! Reinserisci il numero della carta");
            } while (carta.length() != 16);
            System.out.println("Confermi il pagamento? Si/No");
            scelta = scanner2.nextLine();
            if (scelta.equals("Si")) {
                boolean risultato = false;
                //connector tabella tipologia_pg
                prenotazione_spiaggia.addPrenotazione(start_date, end_date, fila, om.getId_ombrellone(), lettini, email);
                PagamentoOmbrellone po = new PagamentoOmbrellone();
                po.sceltaMetodo(tipologia, prenotazioneSpiaggiaConnector.last_prenotazione(id_ombrellone), this.id_ombrellone, data_pagamento);
                // String tipologia_pagamento, int id_prenotazione, int id_ombrellone, Date data_pagamento
                //System.out.println("Confermi la prenotazione per " + tariffaPrezzi.getNum_giorni() + " giorni al prezzo di " + prezzo + "€ ?\n");
                // System.out.println("1=Si/2=No");
                Scontrino scontrino = new Scontrino(id_scontrino, data_pagamento, om.getId_ombrellone(), prezzo);
                scontrino.CalcolaPrezzo(id_scontrino, data_pagamento, om.getId_ombrellone(), prezzo);
            }
            System.out.println("Prenotazione aggiunta");
        }

        if (tipologia.equals("arrivo")) {
            System.out.println("Confermi il pagamento? Si/No");
            scelta = scanner2.nextLine();
            if (scelta.equals("Si")) {
                Date data = obc.getDate();
                boolean risultato = false;
                // Date data_inizioPrenotazione, Date data_finePrenotazione, int num_fila_ombrellone, int id_ombrellone, int lettini, String email
                prenotazione_spiaggia.addPrenotazione(start_date, end_date, fila, this.id_ombrellone, lettini, email);
                Scontrino scontrino = new Scontrino(id_scontrino, data_pagamento, this.id_ombrellone, prezzo);
                scontrino.CalcolaPrezzo(id_scontrino, data_pagamento, this.id_ombrellone, prezzo);
                System.out.println("Confermi la prenotazione per " + tariffaPrezzi.getNum_giorni() + " giorni al prezzo di " + prezzo + "€ ?\n");
                System.out.println("1=Si/2=No");
                int scelta2 = scanner2.nextInt();
                if (scelta2 == 1) {
                    prenotazione_spiaggia.addPrenotazione(start_date, end_date, fila, id, lettini, email);
                } else {
                    //ritorna al menù;
                }
                System.out.println("Prenotazione aggiunta");

            }
        }


        //ALLA FINE DELLA PRENOTAZIONE, AGGIORNARE I LETTINI DISPONIBILI E ANCHE CHE GLI OMBRELLONI DEVONO DIVENTARE OCCUPATI
        // chalet.setQuantita_lettini(chalet.getQuantita_lettini_disponibili()-lettini);
        //connettore.setOmbrelloneOccupato(id);
      /*   List<Ombrellone> ombrelloni = co.getAvailableOmbrelloni(numero_ospiti);
        for (Ombrellone ombrellone : ombrelloni) {
            System.out.println(ombrellone.toString());
        }
        System.out.println("Digita l'id dell'ombrellone che vuoi prenotare");

        String id = scanner.nextLine();
        co.setOmbrelloneOccupato(id);
        double prezzo = co.getPrezzo(id);
        boolean ris = Cc.AssegnaOmbrellone(this.email, id);
        double totale = prezzo * durata;
        if (ris == true) {
            System.out.println("Prenotazione effettuata con successo - dirigiti alla cassa per pagare");
            System.out.println("Totale : " + totale);
        } else
            System.out.println("Prenotazione non effettuata, riprova");
          */
    }

    public void ordinazioneBar(String email) {
        List<Prodotti_Bar> prodotti = cp.getProducts();
        for (Prodotti_Bar prodotto : prodotti) {
            System.out.println(prodotto.toString());
        }
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        String scelta;
        String tipologia;
        double totale;
        int continuaAcquisti;
        int id_ordinazione = 0;
        int id_prodotto = 0;
        int quantita = 0;
        int id_ombrellone;
        double prezzo_totale = 0;
        int id_scontrino = 0;
        int id_prenotazione = 0;

        //Ordinazione_Bar ob = new Ordinazione_Bar(obc.getDate(), quantita, 0, id_ombrellone, id_prodotto);

        do {

            System.out.println("Inserisci l'id del prodotto che vuoi acquistare:");
            id_prodotto = Integer.parseInt(scanner.nextLine());
            System.out.println("Inserisci la quantità che vuoi acquistare:");
            quantita = scanner2.nextInt();
            System.out.println("A quale id dell'ombrellone vuoi far consegnare l'ordine?");
            obc.getIdOmbrelloni(email);
            id_ombrellone = scanner2.nextInt();

            //  (ob.getDate(), quantita, int id_ordinazione, int id_ombrellone, int id_prodotto) {// bisognerebbe prendere il valore dell'ultima riga della tabella, e aggiungerci + 1
            //  totale = +cp.getTotaleOrdine(scelta, quantita);
            System.out.println("vuoi aggiungere altri prodotti all'ordine ancora? 1-si 0-no");
            continuaAcquisti = scanner2.nextInt();
        } while (continuaAcquisti != 0);
        //  System.out.println("Totale:" + totale);
        System.out.println("Scegli la tipologia di pagamento:app -tramite app, consegna -pagamento alla consegna");
        tipologia = scanner.nextLine();
        if (tipologia.equals("app")) {
            System.out.println("Inserisci i dati della carta per il pagamento:");
            String carta;
            do {
                carta = scanner.nextLine();
                if (carta.length() != 16)
                    System.out.println("Errore! Reinserisci il numero della carta");
            } while (carta.length() != 16);
            System.out.println("Confermi il pagamento? Si/No");
            scelta = scanner.nextLine();
            if (scelta.equals("Si")) {
                Date data = obc.getDate();
                boolean risultato = false;
                risultato = obc.addOrdine(new Ordinazione_Bar(data, quantita, id_ordinazione, id_ombrellone, id_prodotto));
                prezzo_totale = obc.calcolaPrezzoOrdine(id_prodotto, quantita);
                Scontrino scontrino = new Scontrino(id_scontrino, data, id_ombrellone, prezzo_totale);
                //connector tabella tipologia_pg
                PagamentoBar p = new PagamentoBar();
                Ordinazione_Bar ordinazione_bar = new Ordinazione_Bar();
                OrdinazioneBarConnector ordinazioneBarConnector = new OrdinazioneBarConnector();
                System.out.println(tipologia);
                System.out.println(ordinazioneBarConnector.last_ordinazione(id_ombrellone));
                System.out.println(id_ombrellone);
                System.out.println(data_pagamento);

                p.sceltaMetodo(tipologia, ordinazioneBarConnector.last_ordinazione(id_ombrellone), id_ombrellone, data_pagamento);
                // String tipologia_pagamento, int id_prenotazione, int id_ombrellone, Date data_pagamento
                if (risultato) {
                    System.out.println("Prenotazione aggiunta");

                }
            }
        }
        if (tipologia.equals("consegna")) {
            System.out.println("Confermi il pagamento? Si/No");
            scelta = scanner.nextLine();
            if (scelta.equals("Si")) {
                Date data = obc.getDate();
                boolean risultato = false;
                //connector tabella tipologia_pg
                PagamentoBar p = new PagamentoBar();
                Ordinazione_Bar ordinazione_bar = new Ordinazione_Bar();
                OrdinazioneBarConnector ordinazioneBarConnector = new OrdinazioneBarConnector();
                risultato = obc.addOrdine(new Ordinazione_Bar(data, quantita, id_ordinazione, id_ombrellone, id_prodotto));
                prezzo_totale = obc.calcolaPrezzoOrdine(id_prodotto, quantita);
                Scontrino scontrino = new Scontrino(id_scontrino, data, id_ombrellone, prezzo_totale);

                p.sceltaMetodo(tipologia, ordinazioneBarConnector.last_ordinazione(id_ombrellone), id_ombrellone, data_pagamento);
                if (risultato) System.out.println("Ordinazione aggiunta");
            }
        }

    }

    public void cancellazionePrenotazioneOmbrellone(String email) {
        Scanner scanner = new Scanner(System.in);
        int id_prenotazione = 0;
        Prenotazione_Spiaggia prenotazione_spiaggia = new Prenotazione_Spiaggia();
        prenotazione_spiaggia.listaPrenotazioni(email);
        System.out.println("seleziona l'id della prenotazione");
        id_prenotazione = scanner.nextInt();
        prenotazione_spiaggia.cancellaPrenotazione(id_prenotazione);
        // this.id_ordinazione = id

    }
}