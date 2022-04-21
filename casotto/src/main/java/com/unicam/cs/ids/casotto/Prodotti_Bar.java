package com.unicam.cs.ids.casotto;

import java.util.ArrayList;
import java.util.Map;

public class Prodotti_Bar {
	private Map<Integer, String> bevande;
	private Map<Integer, String> drink;
	private Map<Integer, String> gelati;
	private Map<Integer, String> snack;
	private double prezzo;
	private int id_prodotto;
	public Preparazione_Ordine utilizza;
	public ArrayList<Gestore> gestisce = new ArrayList<Gestore>();

	public Prodotti_Bar() {
		throw new UnsupportedOperationException();
	}

	public void Menu(Object aLista_prodotti) {
		throw new UnsupportedOperationException();
	}

	public Prodotti_Bar(Map<Integer, String> bevande, Map<Integer, String> drink, Map<Integer, String> gelati, Map<Integer, String> snack, double prezzo, int id_prodotto) {
		this.bevande = bevande;
		this.drink = drink;
		this.gelati = gelati;
		this.snack = snack;
		this.prezzo = prezzo;
		this.id_prodotto = id_prodotto;
	}

	public Map<Integer, String> getBevande() {
		return bevande;
	}

	public void setBevande(Map<Integer, String> bevande) {
		this.bevande = bevande;
	}

	public Map<Integer, String> getDrink() {
		return drink;
	}

	public void setDrink(Map<Integer, String> drink) {
		this.drink = drink;
	}

	public Map<Integer, String> getGelati() {
		return gelati;
	}

	public void setGelati(Map<Integer, String> gelati) {
		this.gelati = gelati;
	}

	public Map<Integer, String> getSnack() {
		return snack;
	}

	public void setSnack(Map<Integer, String> snack) {
		this.snack = snack;
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
}