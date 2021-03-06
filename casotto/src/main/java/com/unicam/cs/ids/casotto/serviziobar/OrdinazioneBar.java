package com.unicam.cs.ids.casotto.serviziobar;

import com.unicam.cs.ids.casotto.utenti.Cliente;

import java.sql.Date;
import java.util.Map;


public class OrdinazioneBar {
    private static int id_ordinazione;
    public Cliente c;
    private Date data_ordinazione;
    private int quantita;
    private int id_ombrellone;
    private int id_prodotto;
    private Map<Integer, Integer> lista_prodotti;

    public OrdinazioneBar() {

    }

    public OrdinazioneBar(Date data_ordinazione, int quantita, int id_ordinazione, int id_ombrellone, Map<Integer, Integer> lista_prodotti) {
        this.data_ordinazione = data_ordinazione;
        this.quantita = quantita;
        OrdinazioneBar.id_ordinazione = incremento(id_ordinazione);
        this.id_ombrellone = id_ombrellone;
        this.lista_prodotti = lista_prodotti;
    }

    public void ordinazione_Prodotto(int idProdotto, int quantita) {
    }

    public int incremento(int id_ordinazione) {

        OrdinazioneBar.id_ordinazione = id_ordinazione + 1;
        return OrdinazioneBar.id_ordinazione;
    }

    public int getId_prodotto() {
        return id_prodotto;
    }

    public void setId_prodotto(int id_prodotto) {
        this.id_prodotto = id_prodotto + 1;
    }

    public Date getData_ordinazione() {
        return data_ordinazione;
    }

    public Date setData_ordinazione(Date data_ordinazione) {
        this.data_ordinazione = data_ordinazione;
        return this.data_ordinazione;
    }

    public Map<Integer, Integer> getLista_prodotti() {
        return lista_prodotti;
    }

    public void setLista_prodotti(Map<Integer, Integer> lista_prodotti) {
        this.lista_prodotti = lista_prodotti;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public int getId_ordinazione() {
        return id_ordinazione;
    }

    public int setId_ordinazione(int id_ordinazione) {
        OrdinazioneBar.id_ordinazione = id_ordinazione;
        return id_ordinazione;
    }

    public int getId_ombrellone() {
        return id_ombrellone;
    }

    public void setId_ombrellone(int id_ombrellone) {
        this.id_ombrellone = id_ombrellone;
    }
}