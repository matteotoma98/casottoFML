package com.unicam.cs.ids.casotto.serviziobar;

import com.unicam.cs.ids.casotto.utenti.Utente;

import java.util.ArrayList;

public class AddettoBar extends Utente {
    public ArrayList<PreparazioneOrdine> prepara = new ArrayList<PreparazioneOrdine>();
    private int id_addbar;
    private String email;
    private String nome;
    private String cognome;


    public AddettoBar(String username, String password, String ruolo, int id_addbar, String email, String nome, String cognome) {
        super(username, password, ruolo, email, nome, cognome);
        this.id_addbar = id_addbar;
        this.email = email;
        this.nome = nome;
        this.cognome = cognome;
    }

    public boolean PreparaOrdine(int id_prenotazione) {
        return false;
    }

    public int getId_addbar() {
        return id_addbar;
    }

    public void setId_addbar(int id_addbar) {
        this.id_addbar = id_addbar;
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