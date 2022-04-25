package com.unicam.cs.ids.casotto;

import java.util.Date;

public class Utente {
	private String username;
	private String password;
	private String email;
	private String ruolo;

	public Utente(String username, String password, String email, String ruolo) {
		this.username = username;
		this.password = password;
		this.email= email;
		this.ruolo = ruolo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
}