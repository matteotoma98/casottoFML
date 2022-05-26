package com.unicam.cs.ids.casotto.serviziobar;

import com.unicam.cs.ids.casotto.Connectors.ProdottiBarConnector;
import com.unicam.cs.ids.casotto.serviziogestione.Gestore;

import java.util.ArrayList;
import java.util.List;

public class ProdottiBar {
    private double prezzo;
    private int id_prodotto;
    private int quantita;
    private String nome_prodotto;
    public PreparazioneOrdine utilizza;
    public ArrayList<Gestore> gestisce = new ArrayList<Gestore>();

    public ProdottiBar() {
        throw new UnsupportedOperationException();
    }

    public List<ProdottiBar> Menu(List<ProdottiBar> lista_prodotti) {

        throw new UnsupportedOperationException();
    }

    public ProdottiBar(double prezzo, int id_prodotto, int quantita, String nome_prodotto) {
        this.prezzo = prezzo;
        this.id_prodotto = id_prodotto;
        this.quantita = quantita;
        this.nome_prodotto = nome_prodotto;
    }

    public void listaProdottiBar() {
        ProdottiBarConnector pb = new ProdottiBarConnector();
        pb.getProducts();
    }

    public String getNome_prodotto() {
        return nome_prodotto;
    }

    public void setNome_prodotto(String nome_prodotto) {
        this.nome_prodotto = nome_prodotto;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public int getId_prodotto() {
        return id_prodotto;
    }

    public void setId_prodotto(int id_prodotto) {
        this.id_prodotto = id_prodotto;
    }

    @Override
    public String toString() {
        return id_prodotto + ": " + nome_prodotto + ", prezzo: " + prezzo + " €, disponibilità: " + quantita;
    }
}