package com.unicam.cs.ids.casotto.serviziogestione;

import com.unicam.cs.ids.casotto.Connectors.ChaletConnector;
import com.unicam.cs.ids.casotto.servizioattivita.Attivita;
import com.unicam.cs.ids.casotto.servizioattivita.Attrezzatura;
import com.unicam.cs.ids.casotto.utenti.Utente;

import java.util.List;

public class Gestore extends Utente {
    private String nome;
    private String cognome;
    private String email;

    /*
	public Prodotti_Bar prodotti_bar;
	public Chalet chalet;
    */
    public void updateCaratteristicheStruttura(int ombrelloni_totali, int lettini_totali, int id_ombrellone, String tipologia, int fila) {
        ChaletConnector cc = new ChaletConnector();
        cc.updateCaratteristicheStruttura(ombrelloni_totali, lettini_totali, id_ombrellone, tipologia, fila);
    }

    private boolean addAttivitaGiornaliere(String nome_attivita, String nome_attrezzatura, int quantita) {
        return true;
    }

    private boolean addAttrezzatura(int id_attivita, String nome_attrezzatura, int quantita) {
        return true;

    }

    private boolean updatePolitichePrezzi(int id_fila, int id_ombrellone, double prezzo_ombr_mg, double prezzo_ombr_gi, double prezzo_lettino, double prezzo_prodotto, int id_prodotto) {

        return true;
    }

    private boolean aggiornaPrezzoFila(int id_fila, double prezzo) {
        return true;
    }

    private boolean aggiornaPrezzoOmbrellone(int id_ombrellone, double prezzo) {
        return true;
    }

    private boolean aggiornaPrezzoOmbrelloneMGGI(String tipologia) {
        if (tipologia.equals("MG")) {

        }
        if (tipologia.equals("GI")) {

        }
        return true;
    }

    private boolean aggiornaPrezzoProdottobar(int id_prodotto, double prezzo) {
        return true;
    }

    private boolean cambiaRuolo(String email) {
        return true;
    }

    public void definizioneProdotti() {
        throw new UnsupportedOperationException();
    }

    public void definizioneStruttura(int num_ombrelloni, int num_lettini) {
        throw new UnsupportedOperationException();
    }

    public void definizioneAttrezzatura(List<Attrezzatura> attrezzatura) {
        String nome_attrezzatura = "";
        int qta = 0;
        Attrezzatura a = new Attrezzatura(nome_attrezzatura, qta);
        attrezzatura.add(a);
        throw new UnsupportedOperationException();
    }

    public void definizioneAttivita(Attivita attivita, String nome_attrezzatura, int quantita_attrezzatura) {
        throw new UnsupportedOperationException();
    }

    public void definizionePolitichePrezzi() {
        throw new UnsupportedOperationException();
    }

    public Gestore(String username, String password, String ruolo, String nome, String cognome, String email, int id_ombrellone) {
        super(username, password, email, ruolo, nome, cognome);
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
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