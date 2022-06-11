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


    public void cambiaRuolo() {

        //get Utenti
        boolean risultato = false;
        boolean risultato2 = false;
        boolean emailesistente = false;
        String email = "";
        String ruolo = "";
        Scanner scanner = new Scanner(System.in);
        UtenteConnector utenteConnector = new UtenteConnector();
        System.out.println("Utenti:");
        utenteConnector.getListaUtenti();
        do {
            System.out.println("Seleziona la mail dell'utente di cui cambiare il ruolo:");
            email = scanner.next();
            if (email.equals("")) {
                System.err.println("Errore: inserire un'email non vuota.");
            }

            do {
                String risultato3 = utenteConnector.getRuolo(email);
                if (risultato3.isEmpty()) {
                    email = scanner.next();
                } else emailesistente = true;
            } while (!emailesistente);

        } while (email.equals(""));
        if (emailesistente) {
            do {
                System.out.println("Seleziona il ruolo da assegnare all'utente scelto: cliente: c, gestore: g, addettoattivita: at, addettospiaggia: as, addettobar: ab");
                ruolo = scanner.next();
                switch (ruolo) {
                    case "c":
                        risultato = utenteConnector.cambiaRuolo(email, "cliente");
                        break;
                    case "g":
                        risultato = utenteConnector.cambiaRuolo(email, "gestore");
                        break;
                    case "at":
                        risultato = utenteConnector.cambiaRuolo(email, "addettoattivita");
                        break;
                    case "as":
                        risultato = utenteConnector.cambiaRuolo(email, "addettospiaggia");
                        break;
                    case "ab":
                        risultato = utenteConnector.cambiaRuolo(email, "addettobar");
                        break;
                }
            } while (!risultato);
        }


    }

    public void aggiornaPolitichePrezzi() throws Exception {
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
        double prezzo_prodotto = 0;
        int id_prodotto = 0;
        ChaletConnector chaletConnector = new ChaletConnector();
        OmbrelloneConnector ombrelloneConnector = new OmbrelloneConnector();
        ProdottiBarConnector prodottiBarConnector = new ProdottiBarConnector();
        TariffaPrezziConnector tariffaPrezziConnector = new TariffaPrezziConnector();
        do {
            Scanner scanner = new Scanner(System.in);
            do {
                System.out.println("Scegli cosa vuoi fare: ");
                System.out.println("1: Cambia il prezzo degli ombrelloni per tutta la fila ");
                System.out.println("2: Cambia il prezzo di un singolo ombrellone ");
                System.out.println("3: Cambia il costo degli ombrelloni per la mezza giornata e la giornata intera");
                System.out.println("4: Cambia il prezzo dei lettini");
                System.out.println("5: Cambia il prezzo dei prodotti del bar");
                System.out.println("0: Esci ");
                scelta = scanner.nextInt();
                if (scelta < 0 || scelta > 5) {
                    System.err.println("Scelta non valida");
                    System.out.println("Reinserici un numero corretto.");
                }
            } while (scelta < 0 || scelta > 5);
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
                    System.out.println("Lista degli id degli ombrelloni:");
                    ombrelloneConnector.getOmbrelloni();
                    do {
                        do {
                            System.out.println("Inserisci l'id dell'ombrellone:");
                            id_ombrellone = scanner.nextInt();
                            if (id_ombrellone < 0) {
                                System.err.println("errore: L'id dell'ombrellone deve essere maggiore di 0");
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
                                System.err.println("errore: Il prezzo dell'ombrellone deve essere maggiore di 0");
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
                                System.err.println("errore: il prezzo dell'ombrellone deve essere maggiore di 0");
                                //(mettere do while finchè non è giusto)
                            }
                        } while (prezzo_ombrellone_mg < 0);
                        do {
                            System.out.println("Inserisci il prezzo degli ombrelloni per la giornata intera:");
                            prezzo_ombrellone_gi = scanner.nextDouble();
                            if (prezzo_ombrellone_gi < 0) {
                                System.err.println("errore: il prezzo dell'ombrellone deve essere maggiore di 0");
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
                                System.err.println("Errore: il prezzo dei lettini deve essere maggiore di 0");
                            }
                        } while (prezzo_lettini <= 0);
                        risultato = tariffaPrezziConnector.cambiaPrezzoLettini(prezzo_lettini);
                    }
                    while (!risultato);
                    break;
                case 5:
                    System.out.println("Prodotti del bar:");
                    List<ProdottiBar> prodotti = prodottiBarConnector.getProducts();
                    System.out.println("--------------------PRODOTTI--------------------");
                    for (ProdottiBar prodotto : prodotti) {
                        System.out.println(prodotto.toString());
                    }
                    do {
                        do {
                            System.out.println("Inserisci l'id del prodotto di cui modificare il prezzo:");
                            id_prodotto = scanner.nextInt();
                            if (id_prodotto < 0) {
                                System.err.println("errore: l'id dell'ombrellone deve essere maggiore o uguale 0");
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
                                System.err.println("errore: il prezzo dell'ombrellone deve essere maggiore di 0");
                            }
                        } while (prezzo_prodotto < 0);
                        risultato2 = prodottiBarConnector.updateProdottiBar(prezzo_prodotto, id_prodotto);
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

    public void updateCaratteristicheStruttura() throws Exception {
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
            Scanner scanner = new Scanner(System.in);
            do {
                System.out.println("Scegli cosa vuoi fare: ");
                System.out.println("1: Cambia il numero degli ombrelloni totali dello chalet ");
                System.out.println("2: Cambia il numero dei lettini totali dello chalet ");
                System.out.println("3: Aggiungi un ombrellone ");
                System.out.println("4: Rimuovi un ombrellone ");
                System.out.println("0: Esci ");
                scelta = scanner.nextInt();
                if (scelta < 0 || scelta > 4) {
                    System.err.println("Scelta non valida");
                    System.out.println("Reinserici un numero corretto.");
                }
            } while (scelta < 0 || scelta > 4);
            switch (scelta) {
                case 1:
                    do {
                        System.out.println("Inserisci il numero di ombrelloni totali dello chalet:");
                        ombrelloni_totali = scanner.nextInt();
                        if (ombrelloni_totali < 0) {
                            System.err.println("Numero ombrelloni inserito non valido");
                            OpenApp o = new OpenApp();
                            o.Open();
                        }
                    } while (ombrelloni_totali < 0);
                    chaletConnector.updateOmbrelloniTotali(ombrelloni_totali);
                    break;
                case 2:
                    do {
                        System.out.println("Inserisci il numero di lettini totali dello chalet:");
                        lettini_totali = scanner.nextInt();
                        if (lettini_totali < 0) {
                            System.err.println("Numero lettini inserito non valido");
                            OpenApp o = new OpenApp();
                            o.Open();
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
                                System.err.println("Errore: l'id dell'ombrellone deve essere maggiore di 0");
                                OpenApp o = new OpenApp();
                                o.Open();
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
                                System.err.println("errore: inserisci una fila compresa tra 1 e 15 ");
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
                                System.err.println("errore: L'id dell'ombrellone deve essere maggiore di 0");
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

    public void modificaProdottibar() throws Exception {
        int id_prodotto = 0;
        double prezzo_prodotto = 0;
        int quantita_prodotto = 0;
        int tempo_preparazione = 0;
        String nome_prodotto = "";
        int scelta = 0;
        boolean risultato = false;
        boolean risultato2 = false;

        ProdottiBarConnector prodottiBarConnector = new ProdottiBarConnector();
        do {
            Scanner scanner = new Scanner(System.in);
            do {
                System.out.println("Scegli cosa vuoi fare: ");
                System.out.println("1: Aggiungi prodotti dal bar ");
                System.out.println("2: Elimina prodotti dal bar ");
                System.out.println("0: Esci ");
                scelta = scanner.nextInt();
                if (scelta < 0 || scelta > 2) {
                    System.err.println("Scelta non valida");
                    System.out.println("Reinserici un numero corretto.");
                }
            } while (scelta < 0 || scelta > 2);
            switch (scelta) {
                case 1:
                    do {
                        do {
                            System.out.println("Inserisci l'id del prodotto da aggiungere:");
                            id_prodotto = scanner.nextInt();
                            if (id_prodotto <= 0) {
                                System.err.println("errore: l'id del prodotto deve essere maggiore o uguale a 0");
                            }
                        } while (id_prodotto <= 0);
                        do {
                            System.out.println("Inserisci il nome del prodotto da aggiungere:");
                            nome_prodotto = scanner.next();
                            if (nome_prodotto.equals("")) {
                                System.err.println("errore: il nome del prodotto non può essere vuoto");
                            }
                        } while (nome_prodotto.equals(""));
                        do {
                            System.out.println("Inserisci la quantità del prodotto da aggiungere:");
                            quantita_prodotto = scanner.nextInt();
                            if (quantita_prodotto < 0) {
                                System.err.println("errore: l'id del prodotto deve essere maggiore di 0");
                            }
                        } while (quantita_prodotto <= 0);
                        do {
                            System.out.println("Inserisci il prezzo del prodotto da aggiungere:");
                            prezzo_prodotto = scanner.nextDouble();
                            if (prezzo_prodotto < 0) {
                                System.err.println("errore: l'id del prodotto deve essere maggiore di 0");
                            }
                        } while (prezzo_prodotto < 0);
                        do {
                            System.out.println("Inserisci il tempo di preparazione del prodotto da aggiungere:");
                            tempo_preparazione = scanner.nextInt();
                            if (tempo_preparazione < 0) {
                                System.err.println("errore: l'id del prodotto deve essere maggiore di 0");
                            }
                        } while (tempo_preparazione < 0);
                        risultato = prodottiBarConnector.aggiungiProdottoBar(id_prodotto, prezzo_prodotto, nome_prodotto, quantita_prodotto, tempo_preparazione);
                    }
                    while (!risultato);
                    break;

                case 2:
                    System.out.println("Prodotti del bar:");
                    List<ProdottiBar> prodotti = prodottiBarConnector.getProducts();
                    System.out.println("--------------------PRODOTTI--------------------");
                    for (ProdottiBar prodotto : prodotti) {
                        System.out.println(prodotto.toString());
                    }
                    do {
                        do {
                            System.out.println("Inserisci l'id del prodotto da rimuovere:");
                            id_prodotto = scanner.nextInt();
                            if (id_prodotto <= 0) {
                                System.err.println("errore: l'id del prodotto deve essere maggiore o uguale a 0");
                            }
                        } while (id_prodotto <= 0);
                        risultato = prodottiBarConnector.rimuoviProdottoBar(id_prodotto);
                    }
                    while (!risultato);
                    break;
                case 0:
                    OpenApp openApp = new OpenApp();
                    openApp.Open();

            }
        }
        while (scelta != 0);

    }

    public void definizioneAttrezzatura() throws Exception {
        String nomeAttrezzatura = "";
        int quantita = 0;
        Scanner scanner = new Scanner(System.in);
        AttrezzaturaConnector at = new AttrezzaturaConnector();
        //  at.addAttrezzatura();
        boolean risultato = false;
        do {
            System.out.println("Inserisci il nome dell'attrezzatura da aggiungere:");
            nomeAttrezzatura = scanner.next();
            String nome_attrezzatura = scanner.next();
            boolean containsDigit2;
            for (char c : nome_attrezzatura.toCharArray())
                if (containsDigit2 = Character.isDigit(c)) {
                    System.err.println("Errore: il nome dell'attrezzatura contiene un numero'");
                    OpenApp o = new OpenApp();
                    o.Open();
                }
            System.out.println("Inserisci la quantità dell'attrezzatura:");
            quantita = scanner.nextInt();
            if (quantita < 0)
                throw new IllegalArgumentException("La quantità inserita non è valida");
            risultato = at.addAttrezzatura(nomeAttrezzatura, quantita);
        }
        while (!risultato);
    }

    public void modificaquantitaAttrezzatura() throws Exception {
        String nomeAttivita = "";
        String nome_attrezzatura = "";
        int quantita_attrezzatura = 0;
        Scanner scanner = new Scanner(System.in);
        boolean risultato = false;
        do {
            AttrezzaturaConnector at = new AttrezzaturaConnector();
            at.getAttrezzatura();
            System.out.println("Inserisci il nome dell'attrezzatura di cui modificare la quantità:");
            boolean containsDigit2;
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
        } while (!risultato);
    }

    public void definizioneAttivita() throws Exception {
        String nomeAttivita = "";
        String nome_attrezzatura = "";
        int quantita_attrezzatura = 0;
        Scanner scanner = new Scanner(System.in);
        boolean risultato = false;
        boolean containsDigit;
        boolean containsDigit2;
        do {
            System.out.println("Inserisci il nome dell'attività da aggiungere:");
            nomeAttivita = scanner.next();
            for (char c : nomeAttivita.toCharArray())
                if (containsDigit = Character.isDigit(c)) {
                    System.err.println("Errore: il nome dell'attività contiene un numero");
                    OpenApp o = new OpenApp();
                    o.Open();
                }
            System.out.println("Inserisci il nome dell'attrezzatura:");
            nome_attrezzatura = scanner.next();
            for (char c : nome_attrezzatura.toCharArray())
                if (containsDigit2 = Character.isDigit(c)) {
                    System.err.println("Errore: il nome dell'attrezzatura contiene un numero'");
                    OpenApp o = new OpenApp();
                    o.Open();
                }
            System.out.println("Inserisci la quantità dell'attrezzatura:");
            quantita_attrezzatura = scanner.nextInt();
            AttivitaConnector ac = new AttivitaConnector();
            risultato = ac.addAttivita(nomeAttivita, nome_attrezzatura, quantita_attrezzatura);
        }
        while (!risultato);
    }


    public Gestore(String username, String password, String ruolo, String nome, String cognome, String email,
                   int id_ombrellone) {
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