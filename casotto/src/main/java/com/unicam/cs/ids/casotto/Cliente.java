package com.unicam.cs.ids.casotto;

import java.util.*;
import java.util.GregorianCalendar;

import com.unicam.cs.ids.casotto.Connectors.OrdinazioneBarConnector;
import com.unicam.cs.ids.casotto.Connectors.Prodotti_BarConnector;

import javax.xml.crypto.Data;

public class Cliente extends Utente implements ICliente {
    private String nome;
    private String cognome;
    private String email;
    private int id_ombrellone;
    private Prodotti_BarConnector cp = new Prodotti_BarConnector();
    private OrdinazioneBarConnector obc= new OrdinazioneBarConnector(obc.getDate(), quantita, ob.incremento(id_ordinazione), scelta);
    private Ordinazione_Bar ob= new Ordinazione_Bar(obc.getDate(), quantita, ob.incremento(id_ordinazione), scelta);
    public ArrayList<Prenotazione_Spiaggia> effettua = new ArrayList<Prenotazione_Spiaggia>();


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
        super(email, username, password, ruolo);
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
    public void registrazione(String email, String username, String password) {

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

    @Override
    public void PrenotazioneOmbrellone() {
        double prezzo = 0;
        Tariffa_Prezzi tariffaPrezzi = new Tariffa_Prezzi();
        Prenotazione_Spiaggia prenotazione_spiaggia = new Prenotazione_Spiaggia();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il giorno d'inizio della prenotazione:");
        String date_start = scanner.nextLine();
        GregorianCalendar date1 = new GregorianCalendar();
        //System.out.println(date_start);
        prenotazione_spiaggia.setDatainizioPrenotazione(date1);
        //  System.out.println(date1);
        System.out.println("Inserisci il giorno di fine della prenotazione:");
        String date_end = scanner.nextLine();
        GregorianCalendar date2 = new GregorianCalendar();
        prenotazione_spiaggia.setData_finePrenotazione(date2);
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


        int scelta_tipologia;

        System.out.println("Scegli quale tipologia di ombrellone vuoi prenotare: ");
        System.out.println("1: VIP ");
        System.out.println("2: PREMIUM ");
        System.out.println("3: BASE");
        scelta_tipologia = scanner.nextInt();
        switch (scelta_tipologia) {
            case 1:
                String tipologia = "";
                tipologia = String.valueOf(Tipologia.VIP);
                break;
            case 2:
                tipologia = String.valueOf(Tipologia.PREMIUM);
                break;
            case 3:
                tipologia = String.valueOf(Tipologia.BASE);
                break;
        }


        System.out.println("Inserisci la fila dell'ombrellone:");
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

        //   prenotazione_spiaggia.(om.(),om.getNum_fila_ombrellone(),om.getData, data_fine);
        prezzo = prezzo + tariffaPrezzi.Imposta_Prezzi_Spiaggia(FasciaOraria.valueOf(fasciaOraria), fila, date_start, date_end, lettini);

        System.out.println("Confermi la prenotazione per " + tariffaPrezzi.getNum_giorni() + " giorni al prezzo di " + prezzo + "€ ?\n");
        System.out.println("1=Si/2=No");
        int scelta = scanner.nextInt();
        if (scelta == 1) {
            chalet.decrementaQuantitaLettiniDisponibili(lettini);
            //chalet.decrementaQuantitaOmbrelloniDisponibili(num_ombrelloni);
            prenotazione_spiaggia.addPrenotazione(date_start, date_end);
            System.out.println("Prenotazione effettuata!");
        } else {
            //ritorna al menù;
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


    @Override
    public void ordinazioneBar() {
        List<Prodotti_Bar> prodotti = cp.getProducts();
        for (Prodotti_Bar prodotto : prodotti) {
            System.out.println(prodotto.toString());
        }
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        String scelta;
        double totale;
        int continuaAcquisti;
        int id_ordinazione=0;
        do {
            System.out.println("Inserisci l'id del prodotto che vuoi acquistare");
            scelta = scanner.nextLine();
            System.out.println("Inserisci la quantità che vuoi acquistare");
            int quantita = scanner2.nextInt();
            obc.addOrdine(new Ordinazione_Bar(obc.getDate(), quantita, ob.incremento(id_ordinazione) , scelta)); //bis
          //  (ob.getDate(), quantita, int id_ordinazione, int id_ombrellone, int id_prodotto) {// ognerebbe prendere il valore dell'ultima riga della tabella, e aggiungerci + 1
            totale = +cp.getPrezzoOrdine(scelta, quantita);
            System.out.println("vuoi aggiungere altri prodotti all'ordine ancora? 1-si 0-no");
            continuaAcquisti = scanner2.nextInt();
        } while (continuaAcquisti != 0);
        System.out.println("Totale:" + totale);
        System.out.println("Confermi il pagamento? Si/No");
        scelta = scanner.nextLine();
        if (scelta.equals("Si")) {
            System.out.println("Inserisci QRCode:");
            scelta = scanner.nextLine();
        }


        Ordinazione_Bar ordinazione_bar = new Ordinazione_Bar(obc.getDate(), quantita, ob.incremento(id_ordinazione), scelta);
        ordinazione_bar.ordinazione_Prodotto(id_prodotto, quantita);
    }


    public void cancellazioneOmbrellone() {
    }
}