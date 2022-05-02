package com.unicam.cs.ids.casotto;

import java.util.ArrayList;
import java.util.Date;

public class Ombrellone {
	public int id_ombrellone;
	private double prezzo;
	private boolean disponibilita;
	private Tariffa_Prezzi tariffaPrezzi;
	private Tipologia tipologia;
	private int num_fila_ombrellone;
	public Prenotazione_Spiaggia riserva;
	public ArrayList<Tariffa_Prezzi> apprartiene = new ArrayList<Tariffa_Prezzi>();

	public Ombrellone(Object aId_ombrellone) {
		throw new UnsupportedOperationException();
	}

	public void getTariffaPrezzi(Object aData_InizioPrenotazione, Object aData_finePrenotazione) {
		throw new UnsupportedOperationException();
	}

	public Ombrellone() {
		this.id_ombrellone = id_ombrellone;
		this.prezzo = prezzo;
		this.disponibilita = disponibilita;
		this.tariffaPrezzi = tariffaPrezzi;
		this.tipologia = tipologia;
		this.num_fila_ombrellone = num_fila_ombrellone;
	}

	public int getId_ombrellone() {
		return id_ombrellone;
	}

	public void setId_ombrellone(int id_ombrellone) {
		this.id_ombrellone = id_ombrellone;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public boolean isDisponibilita() {
		return disponibilita;
	}

	public void setDisponibilita(boolean disponibilita) {
		this.disponibilita = disponibilita;
	}

	public Tariffa_Prezzi getTariffaPrezzi(Date data_inizio_prenotazione, Date data_fine_prenotazione) {
		return tariffaPrezzi;
	}

	public void setTariffaPrezzi(Tariffa_Prezzi tariffaPrezzi) {
		this.tariffaPrezzi = tariffaPrezzi;
	}

	public Tipologia getTipologia() {
		return tipologia;
	}

	public void setTipologia(Tipologia tipologia) {
		this.tipologia = tipologia;
	}

	public int getNum_fila_ombrellone() {
		return num_fila_ombrellone;
	}

	public void setNum_fila_ombrellone(int num_fila_ombrellone) {
		this.num_fila_ombrellone = num_fila_ombrellone;
	}
}