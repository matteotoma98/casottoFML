package com.unicam.cs.ids.casotto;

import java.util.ArrayList;
import java.util.Date;

public class Prenotazione_Attivita {
	private Date dataInizio;
	private Date dataFine;
	private String nome_attivita;
	private String email;
	public ArrayList<Cliente> effettua = new ArrayList<Cliente>();
	public ArrayList<Addetto_attivita_Ludico_Sportive> registra = new ArrayList<Addetto_attivita_Ludico_Sportive>();
	public ArrayList<Attivita> coinvolge = new ArrayList<Attivita>();

	public void Attivita(Date aDataInizio, Date aDataFine) {
		throw new UnsupportedOperationException();
	}

	public void decrementoPosti(int aNum_posti) {
		throw new UnsupportedOperationException();
	}

	public void decrementoCampettiDisponibili(int aCampettiDisonibili) {
		throw new UnsupportedOperationException();
	}

	public Prenotazione_Attivita(Date dataInizio, Date dataFine, String nome_attivita, String email) {
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.nome_attivita = nome_attivita;
		this.email = email;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public String getNome_attivita() {
		return nome_attivita;
	}

	public void setNome_attivita(String nome_attivita) {
		this.nome_attivita = nome_attivita;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}