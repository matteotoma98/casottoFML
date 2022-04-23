package com.unicam.cs.ids.casotto;

public class Chalet {
	private int quantita_ombrelloni;
	private int quantita_lettini;
	private int quantita_ombrelloni_disponibili;
	private int quantita_lettini_disponibili;
	public Prenotazione_Spiaggia unnamed_Prenotazione_Spiaggia_;

	public void decrementaQuantitaLettiniDisponibili() {
		throw new UnsupportedOperationException();
	}

	public void decrementaQuantitaOmbrelloniDisponibili() {
		throw new UnsupportedOperationException();
	}

	public void incrementaQuantitaLettiniDisponibili() {
		throw new UnsupportedOperationException();
	}

	public void incrementaQuantitaOmbrelloniDisponibili() {
		throw new UnsupportedOperationException();
	}

	public Chalet(int quantita_ombrelloni, int quantita_lettini, int quantita_ombrelloni_disponibili, int quantita_lettini_disponibili) {
		this.quantita_ombrelloni = quantita_ombrelloni;
		this.quantita_lettini = quantita_lettini;
		this.quantita_ombrelloni_disponibili = quantita_ombrelloni_disponibili;
		this.quantita_lettini_disponibili = quantita_lettini_disponibili;
	}

	public Chalet() {
		this.quantita_ombrelloni = quantita_ombrelloni;
		this.quantita_lettini = quantita_lettini;
		this.quantita_ombrelloni_disponibili = quantita_ombrelloni_disponibili;
		this.quantita_lettini_disponibili = quantita_lettini_disponibili;
	}

	public int getQuantita_ombrelloni() {
		return quantita_ombrelloni;
	}

	public void setQuantita_ombrelloni(int quantita_ombrelloni) {
		this.quantita_ombrelloni = quantita_ombrelloni;
	}

	public int getQuantita_lettini() {
		return quantita_lettini;
	}

	public void setQuantita_lettini(int quantita_lettini) {
		this.quantita_lettini = quantita_lettini;
	}

	public int getQuantita_ombrelloni_disponibili() {
		return quantita_ombrelloni_disponibili;
	}

	public void setQuantita_ombrelloni_disponibili(int quantita_ombrelloni_disponibili) {
		this.quantita_ombrelloni_disponibili = quantita_ombrelloni_disponibili;
	}

	public int getQuantita_lettini_disponibili() {
		return quantita_lettini_disponibili;
	}

	public void setQuantita_lettini_disponibili(int quantita_lettini_disponibili) {
		this.quantita_lettini_disponibili = quantita_lettini_disponibili;
	}
}