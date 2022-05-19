package com.unicam.cs.ids.casotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Gestore extends Utente {
    private String nome;
    private String cognome;
    private String email;
	/*
	public Prodotti_Bar prodotti_bar;
	public Chalet chalet;
    */


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