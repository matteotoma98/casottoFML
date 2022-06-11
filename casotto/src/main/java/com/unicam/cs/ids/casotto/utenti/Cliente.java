package com.unicam.cs.ids.casotto.utenti;

import com.unicam.cs.ids.casotto.Connectors.*;
import com.unicam.cs.ids.casotto.OpenApp;
import com.unicam.cs.ids.casotto.model.FasciaOraria;
import com.unicam.cs.ids.casotto.model.ICliente;
import com.unicam.cs.ids.casotto.model.IObserver;
import com.unicam.cs.ids.casotto.servizioattivita.Attivita;
import com.unicam.cs.ids.casotto.serviziobar.OrdinazioneBar;
import com.unicam.cs.ids.casotto.serviziobar.PagamentoBar;
import com.unicam.cs.ids.casotto.serviziobar.ProdottiBar;
import com.unicam.cs.ids.casotto.serviziogestione.TariffaPrezzi;
import com.unicam.cs.ids.casotto.serviziospiaggia.Ombrellone;
import com.unicam.cs.ids.casotto.serviziospiaggia.PagamentoOmbrellone;
import com.unicam.cs.ids.casotto.serviziospiaggia.PrenotazioneSpiaggia;
import com.unicam.cs.ids.casotto.utilities.NotifyOrder;
import com.unicam.cs.ids.casotto.utilities.Scontrino;
import com.unicam.cs.ids.casotto.utilities.SendEmail;

import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;

public class Cliente extends Utente implements ICliente {
    private String nome;
    private String cognome;
    private String email;
    private int id_ombrellone = 0;
    private final String prodotti_ordinati = "";

    public List<String> getNomiprodotti() {
        return nomiprodotti;
    }

    public void setNomiprodotti(List<String> nomiprodotti) {
        this.nomiprodotti = nomiprodotti;
    }

    List<String> nomiprodotti = new ArrayList<>();

    public String getQuantita_prodotti() {
        return quantita_prodotti;
    }

    public void setQuantita_prodotti(String quantita_prodotti) {
        this.quantita_prodotti = quantita_prodotti;
    }

    private String quantita_prodotti = " ";

    public int getId_ordinazione() {
        return id_ordinazione;
    }

    public void setId_ordinazione(int id_ordinazione) {
        this.id_ordinazione = id_ordinazione;
    }

    private int id_ordinazione = 0;


    private final ProdottiBarConnector cp = new ProdottiBarConnector();
    private final OrdinazioneBarConnector obc = new OrdinazioneBarConnector();
    private final PrenotazioneSpiaggiaConnector prenotazioneSpiaggiaConnector = new PrenotazioneSpiaggiaConnector();
    Date data_pagamento = Date.valueOf(LocalDate.now());

    private int a_number;

    public int getNumber() {
        return a_number;
    }

    public void setNumber(int a_number) {
        this.a_number = a_number;
    }

    public Cliente(String nome, String cognome, String email, int id_ombrellone) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.id_ombrellone = id_ombrellone;
    }

    public Cliente(String nome, String cognome, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
    }


    public boolean iscrizione_Attivita(String email) throws Exception {
        int id_attività = 0;
        int num_posti = 0;
        Attivita attivita = new Attivita();
        attivita.getAttivita();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Scegli l'id di un'attività");
        id_attività = scanner.nextInt();
        AttivitaConnector a = new AttivitaConnector();
        int max = a.getMax();
        if (id_attività <= 0 || id_attività > max) {
            System.err.println("Id attività immesso non valido");
            OpenApp o = new OpenApp();
            o.Open();
        }
        System.out.println("Inserisci il numero di persone che parteciperanno all'attività");
        num_posti = scanner.nextInt();
        attivita.addPrenotazioneAttivita(email, id_attività, num_posti);
        return true;

    }

    public Cliente() {
    }

    public Cliente(String username, String password, String ruolo, String nome, String cognome, String email, int id_ombrellone) {
        super(email, username, password, ruolo, nome, cognome);

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


    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void registrazione(String username, String password, String ruolo, String nome, String cognome, String email) {

    }


    public int getId_ombrellone() {
        return id_ombrellone;
    }

    public int getId_ombrellone(String email) {
        ClienteConnector cliente = new ClienteConnector();
        Cliente cliente2;
        cliente2 = cliente.getCliente(email);
        System.out.println("Cliente: " + cliente2.getEmail() + " " + cliente2.getId_ombrellone());
        return cliente2.getId_ombrellone();
    }

    public void setId_ombrellone(int id_ombrellone) {
        this.id_ombrellone = id_ombrellone;
    }


    public void PrenotazioneOmbrellone(String email) throws Exception {
        this.id_ombrellone = cc.getOmbrellone(email);
        String scelta;
        String tipologia;
        int id_scontrino = 0;
        double prezzo = 0;
        int lettini=0;
        TariffaPrezzi tariffaPrezzi = new TariffaPrezzi();
        PrenotazioneSpiaggia prenotazione_spiaggia = new PrenotazioneSpiaggia();
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Inserisci il giorno d'inizio della prenotazione:");
        String date_start = scanner.nextLine(); // String str="2015-03-31";
        Date start_date = Date.valueOf(date_start);//converting string into sql date

        if (date_start.startsWith("2022-06-") || date_start.startsWith("2022-07-") || date_start.startsWith("2022-08-") || date_start.startsWith("2022-09-")) {
            prenotazione_spiaggia.setDatainizioPrenotazione(start_date);
        } else {
            System.err.println("In questi mesi lo chalet rimane chiuso");
            OpenApp o = new OpenApp();
            o.Open();
        }

        System.out.println("Inserisci il giorno di fine della prenotazione:");
        String date_end = scanner.nextLine();// String str="2015-03-31";
        Date end_date = Date.valueOf(date_end);//converting string into sql date
        if (date_end.startsWith("2022-06-") || date_end.startsWith("2022-07-") || date_end.startsWith("2022-08-") || date_end.startsWith("2022-09-")) {
            if (date_end.startsWith("2022-06-"))
                //TODO
                date_end.endsWith("");
            prenotazione_spiaggia.setData_finePrenotazione(end_date);
        } else {
            System.err.println("Data inserita non valida");
            OpenApp o = new OpenApp();
            o.Open();
        }

        int scelta_fascia_oraria;
        String fasciaOraria = null;
        System.out.println("Scegli in quale fascia oraria vuoi prenotare:");
        System.out.println("1: Mattina ");
        System.out.println("2: Pomeriggio ");
        System.out.println("3: Giornata Intera ");
        scelta_fascia_oraria = scanner.nextInt();
        if (scelta_fascia_oraria <= 0 || scelta_fascia_oraria > 3) {
            System.err.println("Errore scelta non valida");
            OpenApp o = new OpenApp();
            o.Open();
        }
        switch (scelta_fascia_oraria) {
            case 1:
                fasciaOraria = String.valueOf(FasciaOraria.MATTINA);
                break;
            case 2:
                fasciaOraria = String.valueOf(FasciaOraria.POMERIGGIO);
                break;
            case 3:
                fasciaOraria = String.valueOf(FasciaOraria.GIORNATA_INTERA);
                break;
        }


        System.out.println("Inserisci la fila dell'ombrellone:(FILA 1-3: VIP, FILA 4-7: PREMIUM, FILA 8-15: BASE)");
        int fila;
        fila = scanner.nextInt();
        Ombrellone om = new Ombrellone();
        om.setNum_fila_ombrellone(fila);
        System.out.println((char) 27 + "[31m" + "Lista ombrelloni occupati relativi alle date scelte");
        prenotazioneSpiaggiaConnector.getOmbrelloniOccupati(start_date, end_date); //query che mostra gli ombrelloni occupati nelle date scelte
        System.out.print((char) 27 + "[39m");
        System.out.println("Inserisci l'id dell'ombrellone che vuoi prenotare:");
        int id = scanner.nextInt();
        //vedi ombrelloneconnector
        OmbrelloneConnector om2 = new OmbrelloneConnector();
        boolean result = om2.checkOmbrellone(fila, id);
        if (result)
            om.setId_ombrellone(id);
        do {
            System.out.println("Inserisci la quantità di lettini che vuoi prenotare:");
            lettini = scanner.nextInt();
            if (lettini > 4 || lettini < 0)
                System.err.println("Errore! Hai immesso un numero di lettini non valido");
        } while (lettini > 4 || lettini < 0);
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
                    System.err.println("Errore! Reinserisci il numero della carta");
            } while (carta.length() != 16);
            System.out.println("Confermi il pagamento? Si/No");
            scelta = scanner2.nextLine();
            if (scelta.equals("Si")) {
                boolean risultato;
                boolean prenotato = false;
                prenotato = prenotazione_spiaggia.addPrenotazione(start_date, end_date, fila, om.getId_ombrellone(), lettini, email);
                if (prenotato) {
                    PagamentoOmbrellone po = new PagamentoOmbrellone();
                    po.sceltaMetodo(tipologia, prenotazioneSpiaggiaConnector.last_prenotazione(id_ombrellone), id, data_pagamento);
                    prenotazioneSpiaggiaConnector.changeDate(start_date, end_date, id_ombrellone, fasciaOraria);
                } else {
                    System.err.println("errore nel prenotare");
                    OpenApp openApp = new OpenApp();
                    openApp.Open();
                }

                Scontrino scontrino = new Scontrino(id_scontrino, data_pagamento, om.getId_ombrellone(), prezzo);
                scontrino.CalcolaPrezzo(id_scontrino, data_pagamento, om.getId_ombrellone(), prezzo, "ombrellone");
                IObserver notifyOrder4 = new NotifyOrder("Cliente Ombrellone");
                notifyOrder4.register(notifyOrder4);
                notifyOrder4.notifyObservers();
                IObserver notifyOrder5 = new NotifyOrder("Addetto SpiaggiaOmbrellone");
                notifyOrder5.register(notifyOrder5);
                //notifyOrder5.notifyObservers();
                notifyOrder5.notifyAddettoSpiaggiaOmbrellone(email, "francesco.chiocchi@divini.org", id_ombrellone);
                //notifyOrder.unregister(notifyOrder4);
            } else {
                try {
                    menu_cliente(email);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }

        if (tipologia.equals("arrivo")) {
            System.out.println("Confermi il pagamento? Si/No");
            scelta = scanner2.nextLine();
            if (scelta.equals("Si")) {
                boolean risultato = false;
                //connector tabella tipologia_pg
                boolean prenotato = false;
                prenotato = prenotazione_spiaggia.addPrenotazione(start_date, end_date, fila, om.getId_ombrellone(), lettini, email);
                if (prenotato) {
                    PagamentoOmbrellone po = new PagamentoOmbrellone();
                    po.sceltaMetodo(tipologia, prenotazioneSpiaggiaConnector.last_prenotazione(id_ombrellone), id, data_pagamento);
                    prenotazioneSpiaggiaConnector.changeDate(start_date, end_date, id_ombrellone, fasciaOraria);
                } else
                    System.out.println("Errore: già una prenotazione relativa all'ombrellone relativo al periodo dal " + date_start + " al " + date_end +
                            "\n" + "Riprovare con un'altra data o ombrellone.");
                Scontrino scontrino = new Scontrino(id_scontrino, data_pagamento, om.getId_ombrellone(), prezzo);
                scontrino.CalcolaPrezzo(id_scontrino, data_pagamento, om.getId_ombrellone(), prezzo, "arrivo");
                IObserver notifyOrder4 = new NotifyOrder("Cliente Ombrellone");
                notifyOrder4.register(notifyOrder4);
                notifyOrder4.notifyObservers();
                IObserver notifyOrder5 = new NotifyOrder("Addetto SpiaggiaOmbrellone");
                notifyOrder5.register(notifyOrder5);
                //notifyOrder5.notifyObservers();
                notifyOrder5.notifyAddettoSpiaggiaOmbrellone(email, "francesco.chiocchi@divini.org", id_ombrellone);
            } else {
                try {
                    menu_cliente(email);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void ordinazioneBar(String email) throws Exception {
        setId_ombrellone(cc.getOmbrellone(email));
        List<ProdottiBar> prodotti = cp.getProducts();

        System.out.println("--------------------MENU--------------------");
        for (ProdottiBar prodotto : prodotti) {
            System.out.println(prodotto.toString());
        }
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        String scelta;
        String tipologia;
        double totale;
        int continuaAcquisti;
        int id_prodotto = 0;
        int quantita = 0;
        int id_ombrellone;
        double prezzo_totale = 0;
        int id_scontrino = 0;
        int minuti = 0;
        int cont = 0;
        OrdinazioneBarConnector ordinazioneBarConnector = new OrdinazioneBarConnector();
        PreparazioneOrdineConnector preparazioneOrdineConnector = new PreparazioneOrdineConnector();
        Map<Integer, Integer> mprodotti = new HashMap<>();

        System.out.println("\n");

        System.out.println("A quale id dell'ombrellone vuoi far consegnare l'ordine?");
        obc.getIdOmbrelloni(email);
        id_ombrellone = obc.getId();
        if (id_ombrellone == 0)
            throw new InputMismatchException("Non esiste nessun id ombrellone");
        do {
            System.out.println("Inserisci l'id del prodotto che vuoi acquistare:");
            id_prodotto = scanner2.nextInt();
            if (id_prodotto < 0 || id_prodotto > cp.getMax()) {
                System.err.println("Errore! Hai immesso un id del prodotto non valido.");
                OpenApp o = new OpenApp();
                o.Open();
            }

            System.out.println("Inserisci la quantità che vuoi acquistare:");
            int quantita2 = scanner2.nextInt();

            //mprodotti.put(cont, id_prodotto);
            //mprodotti.put(id_prodotto,quantita2);

            if (mprodotti.containsKey(id_prodotto)) {
                int quantita3 = quantita2;
                int quantita4 = mprodotti.get(id_prodotto);
                int quantita5 = quantita3 + quantita4;
                mprodotti.replace(id_prodotto, quantita5);
                // System.out.println(entry.getKey() + ", Value: : " + entry.getValue());
                //  mprodotti.merge(quantita2, entry.getValue(), Integer::sum);//quantita2+mprodotti.get(quantita2));
            } else {
                mprodotti.put(id_prodotto, quantita2);
            }
          /*  for (Map.Entry<Integer, Integer> entry : mprodotti.entrySet()) {
                System.out.println(entry.getKey() + ", Value nuovo inserito: : " + entry.getValue());
            } */

            do {
                System.out.println("vuoi aggiungere altri prodotti all'ordine ancora? 1-si 0-no");
                continuaAcquisti = scanner2.nextInt();
                if (continuaAcquisti < 0 || continuaAcquisti > 1)
                    System.out.println("Errore: inserisci un numero che sia 0 o 1:");
            } while (continuaAcquisti < 0 || continuaAcquisti > 1);
            if (continuaAcquisti == 0) {
                int size = mprodotti.keySet().size();
                Iterator<Integer> iterator = mprodotti.keySet().iterator();
                while (iterator.hasNext()) {
                    Integer key = iterator.next();
                    //System.out.println(key + ":" + mprodotti.get(key));
                    cp.getQuantitaProdotto(key, mprodotti.get(key));
                    if (!nomiprodotti.contains(ordinazioneBarConnector.getNomeProdotti(key))) {
                        nomiprodotti.add(ordinazioneBarConnector.getNomeProdotti(key));
                    }
                }
                minuti = ordinazioneBarConnector.getTempoProdotti(mprodotti);

            }
        } while (continuaAcquisti != 0);

        System.out.println("Scegli la tipologia di pagamento:app -tramite app, consegna -pagamento alla consegna");
        tipologia = scanner.nextLine();

        if (tipologia.equals("app")) {
            System.out.println("Inserisci i dati della carta per il pagamento:");
            String carta;
            do {
                carta = scanner.nextLine();
                if (carta.length() != 16)
                    System.err.println("Errore! Reinserisci il numero della carta");
            } while (carta.length() != 16);
            System.out.println("Confermi il pagamento? Si/No");
            scelta = scanner.nextLine();
            if (scelta.equals("Si")) {
                Date data = obc.getDate();
                boolean risultato = false;
                risultato = obc.addOrdine(new OrdinazioneBar(data, quantita, id_ordinazione, id_ombrellone, mprodotti));
                prezzo_totale = obc.calcolaPrezzoOrdine(id_prodotto, quantita);
                Scontrino scontrino = new Scontrino(id_scontrino, data, id_ombrellone, prezzo_totale);
                //connector tabella tipologia_pg
                scontrino.CalcolaPrezzo(id_scontrino, data_pagamento, id_ombrellone, prezzo_totale, "bar");
                PagamentoBar p = new PagamentoBar();
                OrdinazioneBar ordinazione_bar = new OrdinazioneBar();
                ordinazione_bar.setLista_prodotti(mprodotti);

                if (!risultato) System.err.println("errore nell'aggiunta dell'ordine");
                boolean risultato2 = p.sceltaMetodo(tipologia, ordinazioneBarConnector.last_ordinazione(id_ombrellone), id_ombrellone, data_pagamento);
                // String tipologia_pagamento, int id_prenotazione, int id_ombrellone, Date data_pagamento
                if (risultato2) {
                    //parte preparazione ordine!
                    id_ordinazione = ordinazioneBarConnector.last_ordinazione(id_ombrellone);
                    setId_ordinazione(id_ordinazione);
                    preparazioneOrdineConnector.addOrdine(id_ordinazione);
                    //dopo i minuti necessari: preparazioneOrdineConnector.OrdinePronto(id_ordinazione);
                    // minuti = cp.TempoTotale(id_prodotto, quantita); //prendere tutti gli id dei prodotti scelti, non solo il primo
                    setEmail(email);

                    //prodotti_ordinati = ordinazioneBarConnector.getListaProdotti(id_ordinazione);
                    quantita_prodotti = ordinazioneBarConnector.getQuantitaProdotti(id_ordinazione);
                    setQuantita_prodotti(quantita_prodotti);
                    setNomiprodotti(nomiprodotti);
                    // a_number = minuti;
                    //  setNumber(a_number);
                    //Helper helper = new Helper(a_number);
                    SendEmail.sendEmailBarCliente(email, getNomiprodotti(), getId_ordinazione(), getId_ombrellone(), quantita_prodotti, minuti);
                    SendEmail.sendMailBar("fchiocchi@libero.it", getNomiprodotti(), getId_ordinazione(), getId_ombrellone(), quantita_prodotti);
                    Timer t = new java.util.Timer();
                    t.schedule(
                            new java.util.TimerTask() {
                                @Override
                                public void run() {
                                    // int finalId_ordinazione = id_ordinazione;
                                    if (preparazioneOrdineConnector.OrdinePronto(getId_ordinazione()))
                                        System.out.println("Il tuo ordine è pronto.");
                                    //else System.out.println("Ordine non ancora pronto");
                                    try {
                                        SendEmail.sendMailAddettoSpiaggiaOrdine("francesco.chiocchi@divini.org", getId_ordinazione(), getId_ombrellone());
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        System.err.println("Errore nell'inviare l'email dell'ordine all'addetto spiaggia");
                                    }
                                    // close the thread
                                    t.cancel();
                                }
                            },
                            minuti * 60000L //invia il messaggio all'addetto spiaggia dopo che è passato il tempo totale per preparare l'ordine
                    );
                    // helper.sendMailBar(email, ordinazioneBarConnector.getListaProdotti(id_ordinazione), ordinazioneBarConnector.last_ordinazione(id_ombrellone), id_ombrellone);

                    System.out.println("Il tuo ordine arriverà tra " + minuti + " minuti");
                    System.out.println("Ordinazione aggiunta, attendi la preparazione!");
                    IObserver notifyOrder4 = new NotifyOrder("Addetto Bar");
                    notifyOrder4.register(notifyOrder4);
                    //notifyOrder4.notifyObservers();
                    // notifyOrder4.notifyAddettobar(email,ordinazione_bar.getLista_prodotti().toString(),ordinazioneBarConnector.last_ordinazione(id_ombrellone),id_ombrellone);
                       /* try {
                            SendEmail.sendMailBar(email, ordinazione_bar.getLista_prodotti().toString(), ordinazioneBarConnector.last_ordinazione(id_ombrellone), id_ombrellone);
                        } catch (Exception e) {
                            e.printStackTrace();
                        } */
                }
            }
        }
        if (tipologia.equals("consegna")) {
            System.out.println("Confermi il pagamento? Si/No");
            scelta = scanner.nextLine();
            if (scelta.equals("Si")) {
                Date data = obc.getDate();
                boolean risultato = false;
                risultato = obc.addOrdine(new OrdinazioneBar(data, quantita, id_ordinazione, id_ombrellone, mprodotti));
                prezzo_totale = obc.calcolaPrezzoOrdine(id_prodotto, quantita);
                Scontrino scontrino = new Scontrino(id_scontrino, data, id_ombrellone, prezzo_totale);
                //connector tabella tipologia_pg
                scontrino.CalcolaPrezzo(id_scontrino, data_pagamento, id_ombrellone, prezzo_totale, "bar");
                PagamentoBar p = new PagamentoBar();
                OrdinazioneBar ordinazione_bar = new OrdinazioneBar();
                ordinazione_bar.setLista_prodotti(mprodotti);
                System.out.println(tipologia);
                System.out.println(ordinazioneBarConnector.last_ordinazione(id_ombrellone));
                System.out.println(id_ombrellone);
                System.out.println(data_pagamento);
                if (!risultato) System.err.println("errore nell'aggiunta dell'ordine");
                boolean risultato2 = p.sceltaMetodo(tipologia, ordinazioneBarConnector.last_ordinazione(id_ombrellone), id_ombrellone, data_pagamento);

                if (risultato) {
                    //parte preparazione ordine!
                    id_ordinazione = ordinazioneBarConnector.last_ordinazione(id_ombrellone);
                    setId_ordinazione(id_ordinazione);
                    preparazioneOrdineConnector.addOrdine(id_ordinazione);
                    //dopo i minuti necessari: preparazioneOrdineConnector.OrdinePronto(id_ordinazione);
                    // minuti = cp.TempoTotale(id_prodotto, quantita); //prendere tutti gli id dei prodotti scelti, non solo il primo
                    setEmail(email);
                    //  prodotti_ordinati = ordinazioneBarConnector.getListaProdotti(id_ordinazione);
                    quantita_prodotti = ordinazioneBarConnector.getQuantitaProdotti(id_ordinazione);
                    setQuantita_prodotti(quantita_prodotti);
                    setNomiprodotti(nomiprodotti);
                    // a_number = minuti;
                    //setNumber(a_number);
                    SendEmail.sendEmailBarCliente(email, getNomiprodotti(), getId_ordinazione(), getId_ombrellone(), quantita_prodotti, minuti);
                    SendEmail.sendMailBar("fchiocchi@libero.it", getNomiprodotti(), getId_ordinazione(), getId_ombrellone(), quantita_prodotti);
                    Timer t = new java.util.Timer();
                    t.schedule(
                            new java.util.TimerTask() {
                                @Override
                                public void run() {
                                    // int finalId_ordinazione = id_ordinazione;
                                    if (preparazioneOrdineConnector.OrdinePronto(getId_ordinazione()))
                                        System.out.println("Il tuo ordine è pronto.");
                                    //else System.out.println("Ordine non ancora pronto");
                                    try {
                                        SendEmail.sendMailAddettoSpiaggiaOrdine("francesco.chiocchi@divini.org", getId_ordinazione(), getId_ombrellone());
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        System.err.println("Errore nell'inviare l'email dell'ordine all'addetto spiaggia");
                                    }
                                    // close the thread
                                    t.cancel();
                                }
                            },
                            minuti * 60000L //invia il messaggio all'addetto spiaggia dopo che è passato il tempo totale per preparare l'ordine
                    );

                    System.out.println("Ordinazione aggiunta, attendi la preparazione!");
                    System.out.println("Il tuo ordine arriverà tra " + minuti + " minuti");

                    NotifyOrder notifyOrder3 = new NotifyOrder("Addetto Bar");
                    IObserver notifyOrder4 = new NotifyOrder("Addetto Bar");
                    notifyOrder3.register(notifyOrder4);
                    notifyOrder3.notifyObservers();
                    NotifyOrder notifyOrder5 = new NotifyOrder("Addetto Spiaggia");
                    IObserver notifyOrder6 = new NotifyOrder("Addetto Spiaggia");
                    notifyOrder5.notifyAddettoSpiaggiaOmbrellone(email, "francesco.chiocchi@divini.org", id_ombrellone);
                    notifyOrder5.notifyObservers();
                    //notifyOrder5.unregister(notifyOrder6);
                    NotifyOrder notifyOrder7 = new NotifyOrder("Cliente Spiaggia");
                    IObserver notifyOrder8 = new NotifyOrder("Cliente Spiaggia");
                    notifyOrder7.register(notifyOrder8);
                    notifyOrder7.notifyObservers();
                }
            }
        }
        if (!tipologia.equals("consegna") && !tipologia.equals("app")) {
            System.err.println("Errore! Hai immesso una tipologia del pagamento non prevista.");
            OpenApp o = new OpenApp();
            o.Open();
        }
    }

    public void cancellazionePrenotazioneOmbrellone(String email) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int id_prenotazione;
        PrenotazioneSpiaggia prenotazione_spiaggia = new PrenotazioneSpiaggia();
        prenotazione_spiaggia.listaPrenotazioni(email);
        System.out.println("seleziona l'id della prenotazione");
        id_prenotazione = scanner.nextInt();
        if (prenotazioneSpiaggiaConnector.checkPrenotazioniOmbrellone(email, id_prenotazione)) {
            prenotazione_spiaggia.cancellaPrenotazione(id_prenotazione);
        } else {
            System.err.println("Errore! Id prenotazione inserito non corrisponde alla tua email\n");
            OpenApp o = new OpenApp();
            o.Open();
        }
    }
}
