package com.unicam.cs.ids.casotto;

import java.util.ArrayList;

public class Attivita {
	private String nome_attivita;
	private int num_posti;
	private String nome_attrezzatira;
	private int quantita;
	public ArrayList<Prenotazione_Attivita> coinvolge = new ArrayList<Prenotazione_Attivita>();

	public Attivita() {
		throw new UnsupportedOperationException();
	}

	public void Attrezzatura(Object aNome, Object aQuantita) {
		throw new UnsupportedOperationException();
	}

	public Attivita(String nome_attivita, int num_posti, String nome_attrezzatira, int quantita) {
		this.nome_attivita = nome_attivita;
		this.num_posti = num_posti;
		this.nome_attrezzatira = nome_attrezzatira;
		this.quantita = quantita;
	}

	public String getNome_attivita() {
		return nome_attivita;
	}

	public void setNome_attivita(String nome_attivita) {
		this.nome_attivita = nome_attivita;
	}

	public int getNum_posti() {
		return num_posti;
	}

	public void setNum_posti(int num_posti) {
		this.num_posti = num_posti;
	}

	public String getNome_attrezzatira() {
		return nome_attrezzatira;
	}

	public void setNome_attrezzatira(String nome_attrezzatira) {
		this.nome_attrezzatira = nome_attrezzatira;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
}