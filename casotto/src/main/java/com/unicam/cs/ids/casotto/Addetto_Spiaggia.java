package com.unicam.cs.ids.casotto;

import com.unicam.cs.ids.casotto.Connectors.AddettoSpiaggiaConnector;

import java.util.ArrayList;

public class Addetto_Spiaggia extends Utente {
    private int id_addspiaggia;
    private String email;
    private String nome;
    private String cognome;
    public ArrayList<Preparazione_Ordine> consegna = new ArrayList<Preparazione_Ordine>();

    public Addetto_Spiaggia(String username, String password, String ruolo, int id_addspiaggia, String email, String nome, String cognome, int id_ombrellone) {
        super(username, password, ruolo, email, nome, cognome);
        this.id_addspiaggia = id_addspiaggia;
        this.email = email;
        this.nome = nome;
        this.cognome = cognome;
    }

    public void consegnaProdottoBar() {

    }

    Ombrellone ombrellone = new Ombrellone();

    public void liberaOmbrellone(Ombrellone ombrellone) {
        ombrellone.getId_ombrellone();
        AddettoSpiaggiaConnector addettoSpiaggiaConnector = new AddettoSpiaggiaConnector();
        //addettoSpiaggiaConnector.cambiaDisponbilitaOmbrellone();
        //ombrellone.isDisponibilita();
    }

    public int getId_addspiaggia() {
        return id_addspiaggia;
    }

    public void setId_addspiaggia(int id_addspiaggia) {
        this.id_addspiaggia = id_addspiaggia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
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
}