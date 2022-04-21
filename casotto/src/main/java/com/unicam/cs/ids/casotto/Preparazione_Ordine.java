package com.unicam.cs.ids.casotto;

import java.util.ArrayList;

public class Preparazione_Ordine {
	private boolean ordinePronto;
	private ArrayList<Scontrino> scontrini;
	private int id_ordinazione;
	public ArrayList<Prodotti_Bar> utilizza = new ArrayList<Prodotti_Bar>();
	public Addetto_Bar prepara;
	public ArrayList<Addetto_Spiaggia> consegna = new ArrayList<Addetto_Spiaggia>();

	public boolean StampaScontrino() {
		throw new UnsupportedOperationException();
	}

	public void AddProdotto(String aNomeProdotto, int aQuantita, Object aId_Preparazione) {
		throw new UnsupportedOperationException();
	}

	public boolean checkDisponibilta() {
		throw new UnsupportedOperationException();
	}

	public void aggiornaTotale() {
		throw new UnsupportedOperationException();
	}

	public Preparazione_Ordine(boolean ordinePronto, ArrayList<Scontrino> scontrini, int id_ordinazione) {
		this.ordinePronto = ordinePronto;
		this.scontrini = scontrini;
		this.id_ordinazione = id_ordinazione;
	}

	public boolean isOrdinePronto() {
		return ordinePronto;
	}

	public void setOrdinePronto(boolean ordinePronto) {
		this.ordinePronto = ordinePronto;
	}

	public ArrayList<Scontrino> getScontrini() {
		return scontrini;
	}

	public void setScontrini(ArrayList<Scontrino> scontrini) {
		this.scontrini = scontrini;
	}

	public int getId_ordinazione() {
		return id_ordinazione;
	}

	public void setId_ordinazione(int id_ordinazione) {
		this.id_ordinazione = id_ordinazione;
	}
}