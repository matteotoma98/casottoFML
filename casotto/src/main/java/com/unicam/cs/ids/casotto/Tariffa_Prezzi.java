package com.unicam.cs.ids.casotto;

public class Tariffa_Prezzi {
	private int num_fila_ombrellone;
	private FasciaOraria fasciaOraria;
	private double prezzoLettino;
	private double prezzoOmbrelloneMezzaGiornata;
	private double prezzoOmbrelloneGiornataIntera;
	private int id_prodotto;
	public Ombrellone apprartiene;
	public Prodotti_Bar riferisce;

	public void TarifaPrezzi() {
		throw new UnsupportedOperationException();
	}

	public void modificaPrezzo() {
		throw new UnsupportedOperationException();
	}

	public Tariffa_Prezzi(int num_fila_ombrellone, FasciaOraria fasciaOraria, double prezzoLettino, double prezzoOmbrelloneMezzaGiornata, double prezzoOmbrelloneGiornataIntera, int id_prodotto) {
		this.num_fila_ombrellone = num_fila_ombrellone;
		this.fasciaOraria = fasciaOraria;
		this.prezzoLettino = prezzoLettino;
		this.prezzoOmbrelloneMezzaGiornata = prezzoOmbrelloneMezzaGiornata;
		this.prezzoOmbrelloneGiornataIntera = prezzoOmbrelloneGiornataIntera;
		this.id_prodotto = id_prodotto;
	}

	public int getNum_fila_ombrellone() {
		return num_fila_ombrellone;
	}

	public void setNum_fila_ombrellone(int num_fila_ombrellone) {
		this.num_fila_ombrellone = num_fila_ombrellone;
	}

	public FasciaOraria getFasciaOraria() {
		return fasciaOraria;
	}

	public void setFasciaOraria(FasciaOraria fasciaOraria) {
		this.fasciaOraria = fasciaOraria;
	}

	public double getPrezzoLettino() {
		return prezzoLettino;
	}

	public void setPrezzoLettino(double prezzoLettino) {
		this.prezzoLettino = prezzoLettino;
	}

	public double getPrezzoOmbrelloneMezzaGiornata() {
		return prezzoOmbrelloneMezzaGiornata;
	}

	public void setPrezzoOmbrelloneMezzaGiornata(double prezzoOmbrelloneMezzaGiornata) {
		this.prezzoOmbrelloneMezzaGiornata = prezzoOmbrelloneMezzaGiornata;
	}

	public double getPrezzoOmbrelloneGiornataIntera() {
		return prezzoOmbrelloneGiornataIntera;
	}

	public void setPrezzoOmbrelloneGiornataIntera(double prezzoOmbrelloneGiornataIntera) {
		this.prezzoOmbrelloneGiornataIntera = prezzoOmbrelloneGiornataIntera;
	}

	public int getId_prodotto() {
		return id_prodotto;
	}

	public void setId_prodotto(int id_prodotto) {
		this.id_prodotto = id_prodotto;
	}
}