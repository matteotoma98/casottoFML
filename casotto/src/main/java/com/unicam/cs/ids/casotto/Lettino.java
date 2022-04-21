package com.unicam.cs.ids.casotto;

public class Lettino {
	private int id_lettino;
	private Tariffa_Prezzi tariffaPrezzi;
	private boolean disponibilita;
	public Prenotazione_Spiaggia riserva;
	public Tariffa_Prezzi appartiene;

	public Lettino() {
		throw new UnsupportedOperationException();
	}

	public void getTariffaPrezzi(Object aPrezzoLettino) {
		throw new UnsupportedOperationException();
	}

	public Lettino(int id_lettino, Tariffa_Prezzi tariffaPrezzi, boolean disponibilita) {
		this.id_lettino = id_lettino;
		this.tariffaPrezzi = tariffaPrezzi;
		this.disponibilita = disponibilita;
	}

	public int getId_lettino() {
		return id_lettino;
	}

	public void setId_lettino(int id_lettino) {
		this.id_lettino = id_lettino;
	}

	public Tariffa_Prezzi getTariffaPrezzi() {
		return tariffaPrezzi;
	}

	public void setTariffaPrezzi(Tariffa_Prezzi tariffaPrezzi) {
		this.tariffaPrezzi = tariffaPrezzi;
	}

	public boolean isDisponibilita() {
		return disponibilita;
	}

	public void setDisponibilita(boolean disponibilita) {
		this.disponibilita = disponibilita;
	}
}