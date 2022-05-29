package com.unicam.cs.ids.casotto.serviziogestione;

import com.unicam.cs.ids.casotto.Connectors.*;
import com.unicam.cs.ids.casotto.OpenApp;
import com.unicam.cs.ids.casotto.serviziobar.ProdottiBar;
import com.unicam.cs.ids.casotto.utenti.Utente;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class Gestore extends Utente {
    private String nome;
    private String cognome;
    private String email;

    /*
	public Prodotti_Bar prodotti_bar;
	public Chalet chalet;
    */


    public boolean addAttivitaGiornaliere(String nome_attivita, String nome_attrezzatura, int quantita) {
        return true;
    }

    public boolean addAttrezzatura(int id_attivita, String nome_attrezzatura, int quantita) {
        return true;

    }

    public boolean updatePolitichePrezzi(int id_fila, int id_ombrellone, double prezzo_ombr_mg, double prezzo_ombr_gi, double prezzo_lettino, double prezzo_prodotto, int id_prodotto) {

        return true;
    }

    public boolean aggiornaPrezzoFila(int id_fila, double prezzo) {
        return true;
    }

    public boolean aggiornaPrezzoOmbrellone(int id_ombrellone, double prezzo) {
        return true;
    }

    public boolean aggiornaPrezzoOmbrelloneMGGI(String tipologia) {
        if (tipologia.equals("MG")) {

        }
        if (tipologia.equals("GI")) {

        }
        return true;
    }

    public boolean aggiornaPrezzoProdottobar(int id_prodotto, double prezzo) {
        return true;
    }

    public boolean cambiaRuolo(String email) {
        return true;
    }

    public void definizioneProdotti() {
        throw new UnsupportedOperationException();
    }

    public void definizioneStruttura(int num_ombrelloni, int num_lettini) {
        throw new UnsupportedOperationException();
    }


    public void aggiornaPolitichePrezzi() {
        int ombrelloni_totali = 0;
        int lettini_totali = 0;
        int id_ombrellone = 0;
        String tipologia = "";
        int fila = 0;
        int scelta = 0;
        boolean risultato = false;
        boolean risultato2 = false;
        double prezzo_ombrellone = 0;
        double prezzo_ombrellone_mg = 0;
        double prezzo_ombrellone_gi = 0;
        double prezzo_lettini = 0;
        double prezzo_prodotto=0;
        int id_prodotto=0;
        ChaletConnector chaletConnector = new ChaletConnector();
        OmbrelloneConnector ombrelloneConnector = new OmbrelloneConnector();
        ProdottiBarConnector prodottiBarConnector = new ProdottiBarConnector();
        TariffaPrezziConnector tariffaPrezziConnector = new TariffaPrezziConnector();
        do {
            System.out.println("Scegli cosa vuoi fare: ");
            System.out.println("1: Cambia il prezzo degli ombrelloni per tutta la fila ");
            System.out.println("2: Cambia il prezzo di un singolo ombrellone ");
            System.out.println("3: Cambia il costo degli ombrelloni per la mezza giornata e la giornata intera");
            System.out.println("4: Cambia il prezzo dei lettini");
            System.out.println("5: Cambia il prezzo dei prodotti del bar");
            System.out.println("0: Esci ");
            Scanner scanner = new Scanner(System.in);
            scelta = scanner.nextInt();
            switch (scelta) {
                case 1:
                    do {
                        System.out.println("Inserisci la fila dell'ombrellone da aggiungere: (dalla 1 alla 3 => vip, dalla 4 alla 7 => premium, dalla 8 alla 15 => base");
                        fila = scanner.nextInt();
                       /* else if ((!tipologia.equals("vip")) || (!tipologia.equals("premium")) || (!tipologia.equals("base"))) {
                        throw new IllegalArgumentException("inserisci una tipologia che sia base,vip o premium");
                    } */
                        if (fila < 1 || fila > 15) {
                            System.out.println("inserisci una fila compresa tra 1 e 15 ");
                        }
                    } while (fila < 1 || fila > 15);
                    do {
                        System.out.println("Inserisci il prezzo degli ombrelloni");
                        prezzo_ombrellone = scanner.nextDouble();
                        if (prezzo_ombrellone < 0) {
                            System.out.println("il prezzo degli ombrelloni per la fila scelta deve essere maggiore di 0");
                            //(mettere do while finchè non è giusto)
                        }
                    } while (prezzo_ombrellone <= 0);
                    ombrelloneConnector.cambiaPrezzoFila(fila, prezzo_ombrellone);
                    break;
                case 2:
                    System.out.println("lista degli id degli ombrelloni:");
                    ombrelloneConnector.getOmbrelloni();
                    do {
                        do {
                            System.out.println("Inserisci l'id dell'ombrellone:");
                            id_ombrellone = scanner.nextInt();
                            if (id_ombrellone < 0) {
                                System.out.println("l'id dell'ombrellone deve essere maggiore di 0");
                                //(mettere do while finchè non è giusto)
                            }
                        } while (id_ombrellone < 0);
                        do {
                            System.out.println("Inserisci il prezzo dell'ombrellone:");
                            prezzo_ombrellone = scanner.nextDouble();
                       /* else if ((!tipologia.equals("vip")) || (!tipologia.equals("premium")) || (!tipologia.equals("base"))) {
                        throw new IllegalArgumentException("inserisci una tipologia che sia base,vip o premium");
                    } */
                            if (prezzo_ombrellone <= 0) {
                                System.out.println("il prezzo dell'ombrellone deve essere maggiore di 0");
                            }
                        } while (prezzo_ombrellone < 0);
                        risultato2 = ombrelloneConnector.cambiaPrezzoOmbrellone(id_ombrellone, prezzo_ombrellone);
                    } while (!risultato2);
                    break;
                case 3:
                    do {
                        do {
                            System.out.println("Inserisci la fila dell'ombrellone da aggiungere: (dalla 1 alla 3 => vip, dalla 4 alla 7 => premium, dalla 8 alla 15 => base");
                            fila = scanner.nextInt();
                       /* else if ((!tipologia.equals("vip")) || (!tipologia.equals("premium")) || (!tipologia.equals("base"))) {
                        throw new IllegalArgumentException("inserisci una tipologia che sia base,vip o premium");
                    } */
                            if (fila < 1 || fila > 15) {
                                System.out.println("inserisci una fila compresa tra 1 e 15 ");
                            }
                        } while (fila < 1 || fila > 15);
                        do {
                            System.out.println("Inserisci il prezzo degli ombrelloni per la mezza giornata:");
                            prezzo_ombrellone_mg = scanner.nextDouble();
                            if (prezzo_ombrellone_mg < 0) {
                                System.out.println("il prezzo dell'ombrellone deve essere maggiore di 0");
                                //(mettere do while finchè non è giusto)
                            }
                        } while (prezzo_ombrellone_mg < 0);
                        do {
                            System.out.println("Inserisci il prezzo degli ombrelloni per la giornata intera:");
                            prezzo_ombrellone_gi = scanner.nextDouble();
                            if (prezzo_ombrellone_gi < 0) {
                                System.out.println("il prezzo dell'ombrellone deve essere maggiore di 0");
                                //(mettere do while finchè non è giusto)
                            }
                        } while (prezzo_ombrellone_gi < 0);

                        risultato2 = tariffaPrezziConnector.updatePolitichePrezzi(fila, prezzo_ombrellone_mg, prezzo_ombrellone_gi);
                    } while (!risultato2);
                    break;
                case 4:
                    do {
                        do {
                            System.out.println("Inserisci il prezzo dei lettini:");
                            prezzo_lettini = scanner.nextDouble();
                            if (prezzo_lettini < 0) {
                                System.out.println("il prezzo dei lettini deve essere maggiore di 0");
                            }
                        } while (prezzo_lettini <= 0);
                        risultato = tariffaPrezziConnector.cambiaPrezzoLettini(prezzo_lettini);
                    }
                    while (!risultato);
                    break;
                case 5:
                    System.out.println("Prodotti del bar:");
                    List<ProdottiBar> prodotti =   prodottiBarConnector.getProducts();
                    System.out.println("--------------------PRODOTTI--------------------");
                    for (ProdottiBar prodotto : prodotti) {
                        System.out.println(prodotto.toString());
                    }
                    do {
                        do {
                            System.out.println("Inserisci l'id del prodotto di cui modificare il prezzo:");
                            id_prodotto = scanner.nextInt();
                            if (id_prodotto < 0) {
                                System.out.println("l'id dell'ombrellone deve essere maggiore o uguale 0");
                                //(mettere do while finchè non è giusto)
                            }
                        } while (id_prodotto < 0);
                        do {
                            System.out.println("Inserisci il prezzo del prodotto:");
                            prezzo_prodotto = scanner.nextDouble();
                       /* else if ((!tipologia.equals("vip")) || (!tipologia.equals("premium")) || (!tipologia.equals("base"))) {
                        throw new IllegalArgumentException("inserisci una tipologia che sia base,vip o premium");
                    } */
                            if (prezzo_prodotto <= 0) {
                                System.out.println("il prezzo dell'ombrellone deve essere maggiore di 0");
                            }
                        } while (prezzo_prodotto < 0);
                        risultato2 = prodottiBarConnector.updateProdottiBar(prezzo_prodotto,id_prodotto);
                    } while (!risultato2);

                    break;
                case 0:
                    OpenApp openApp = new OpenApp();
                    try {
                        openApp.Open();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
            }
        }
        while (scelta != 0);
    }

    public void updateCaratteristicheStruttura() {
        int ombrelloni_totali = 0;
        int lettini_totali = 0;
        int id_ombrellone = 0;
        String tipologia = "";
        int fila = 0;
        int scelta = 0;
        boolean risultato = false;
        boolean risultato2 = false;
        ChaletConnector chaletConnector = new ChaletConnector();
        OmbrelloneConnector ombrelloneConnector = new OmbrelloneConnector();
        do {
            System.out.println("Scegli cosa vuoi fare: ");
            System.out.println("1: Cambia il numero degli ombrelloni totali dello chalet ");
            System.out.println("2: Cambia il numero dei lettini totali dello chalet ");
            System.out.println("3: Aggiungi un ombrellone ");
            System.out.println("4: Rimuovi un ombrellone ");
            System.out.println("0: Esci ");
            Scanner scanner = new Scanner(System.in);
            scelta = scanner.nextInt();
            switch (scelta) {
                case 1:
                    do {
                        System.out.println("Inserisci il numero di ombrelloni totali dello chalet:");
                        ombrelloni_totali = scanner.nextInt();

                        if (ombrelloni_totali < 0) {
                            System.out.println("la quantità di ombrelloni totali deve essere maggiore di 0");
                        }
                    } while (ombrelloni_totali < 0);
                    chaletConnector.updateOmbrelloniTotali(ombrelloni_totali);
                    break;
                case 2:
                    do {
                        System.out.println("Inserisci il numero di lettini totali dello chalet:");
                        lettini_totali = scanner.nextInt();
                        if (lettini_totali < 0) {
                            System.out.println("la quantità di lettini totali deve essere maggiore di 0");
                        }
                    } while (lettini_totali < 0);
                    chaletConnector.updateLettiniTotali(lettini_totali);
                    break;
                case 3:
                    do {
                        do {
                            System.out.println("Inserisci l'id dell'ombrellone da aggiungere:");
                            id_ombrellone = scanner.nextInt();
                            if (id_ombrellone < 0) {
                                System.out.println("l'id dell'ombrellone deve essere maggiore di 0");
                                //(mettere do while finchè non è giusto)
                            }
                        } while (id_ombrellone < 0);
                        do {
                            System.out.println("Inserisci la fila dell'ombrellone da aggiungere: (dalla 1 alla 3 => vip, dalla 4 alla 7 => premium, dalla 8 alla 15 => base");
                            fila = scanner.nextInt();
                       /* else if ((!tipologia.equals("vip")) || (!tipologia.equals("premium")) || (!tipologia.equals("base"))) {
                        throw new IllegalArgumentException("inserisci una tipologia che sia base,vip o premium");
                    } */
                            if (fila < 1 || fila > 15) {
                                System.out.println("inserisci una fila compresa tra 1 e 15 ");
                            }
                        } while (fila < 1 || fila > 15);
                        ombrelloneConnector.addOmbrellone(id_ombrellone, fila);
                    } while (!risultato2);
                    break;
                case 4:
                    System.out.println("Lista degli ombrelloni disponibili:");
                    ombrelloneConnector.getOmbrelloni();
                    do {
                        do {
                            System.out.println("Inserisci l'id dell'ombrellone da rimuovere:");

                            if (id_ombrellone < 0) {
                                System.out.println("l'id dell'ombrellone deve essere maggiore di 0");
                            }
                            id_ombrellone = scanner.nextInt();
                        } while (id_ombrellone < 0);
                        risultato = ombrelloneConnector.removeOmbrellone(id_ombrellone);
                    }
                    while (!risultato);
                    break;
                case 0:
                    OpenApp openApp = new OpenApp();
                    try {
                        openApp.Open();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
            }
        }
        while (scelta != 0);
    }

    public void definizioneAttrezzatura() {
        String nomeAttrezzatura = "";
        int quantita = 0;
        Scanner scanner = new Scanner(System.in);
        AttrezzaturaConnector at = new AttrezzaturaConnector();
        //  at.addAttrezzatura();
        boolean risultato = false;
        do {
            System.out.println("Inserisci il nome dell'attrezzatura da aggiungere:");
            nomeAttrezzatura = scanner.next();
            System.out.println("Inserisci la quantità dell'attrezzatura:");
            quantita = scanner.nextInt();

            risultato = at.addAttrezzatura(nomeAttrezzatura, quantita);
        }
        while (!risultato);
    }

    public void modificaquantitaAttrezzatura() {
        String nomeAttivita = "";
        String nome_attrezzatura = "";
        int quantita_attrezzatura = 0;
        Scanner scanner = new Scanner(System.in);
        boolean risultato = false;
        do {
            AttrezzaturaConnector at = new AttrezzaturaConnector();
            at.getAttrezzatura();
            System.out.println("Inserisci il nome dell'attrezzatura di cui modificare la quantità");
            nome_attrezzatura = scanner.next();
            System.out.println("Inserisci la quantità dell'attrezzatura:");
            quantita_attrezzatura = scanner.nextInt();
            risultato = at.modificaAttrezzatura(nome_attrezzatura, quantita_attrezzatura);
        }
        while (!risultato);
    }

    public void rimozioneAttivita() {
        String nomeAttivita = "";
        Scanner scanner = new Scanner(System.in);
        AttivitaConnector ac = new AttivitaConnector();
        ac.getAttivita();
        boolean risultato = false;
        do {
            System.out.println("Inserisci il nome dell'attività da rimuovere:");
            nomeAttivita = scanner.next();

            risultato = ac.rimuoviAttivita(nomeAttivita);
        }
        while (!risultato);
    }

    public void definizioneAttivita() {
        String nomeAttivita = "";
        String nome_attrezzatura = "";
        int quantita_attrezzatura = 0;
        Scanner scanner = new Scanner(System.in);
        boolean risultato = false;
        do {
            System.out.println("Inserisci il nome dell'attività da aggiungere:");
            nomeAttivita = scanner.next();
            System.out.println("Inserisci il nome dell'attrezzatura:");
            nome_attrezzatura = scanner.next();
            System.out.println("Inserisci la quantità dell'attrezzatura:");
            quantita_attrezzatura = scanner.nextInt();
            AttivitaConnector ac = new AttivitaConnector();
            risultato = ac.addAttivita(nomeAttivita, nome_attrezzatura, quantita_attrezzatura);
        }
        while (!risultato);
    }


    public Gestore(String username, String password, String ruolo, String nome, String cognome, String email, int id_ombrellone) {
        super(username, password, email, ruolo, nome, cognome);
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
    }

    public Gestore() {

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


}