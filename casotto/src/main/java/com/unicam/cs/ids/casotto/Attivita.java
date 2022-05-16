package com.unicam.cs.ids.casotto;

import com.unicam.cs.ids.casotto.Connectors.AttivitaConnector;
import org.w3c.dom.Attr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Attivita {
    private String nome_attivita;
    private int num_posti;
    private Attrezzatura attrezzatura;

    public int getId_attivita() {
        return id_attivita;
    }

    public void setId_attivita(int id_attivita) {
        this.id_attivita = id_attivita;
    }

    public int id_attivita;
    private Date data_inizio_attivita;
    private Date data_fine_attivita;
    public ArrayList<Prenotazione_Attivita> coinvolge = new ArrayList<Prenotazione_Attivita>();

    public void Attrezzatura(String Nome, int Quantita) {
        throw new UnsupportedOperationException();
    }

    public List<String> getListaAttivita(String nome_attivita, int id_attivita, Date data_inizio_attivita, Date data_fine_attivita, int num_posti) {
        String a = "a";
        List<String> lista_attivita = new ArrayList<>();
        lista_attivita.add(a);
        return Collections.singletonList(a);
    }

    public void getAttivita() {
        AttivitaConnector attivitaConnector = new AttivitaConnector();
        attivitaConnector.getAttivita();
    }

    public Attivita() {

    }

    public boolean addPrenotazioneAttivita(String email, int id, int num_posti) {

        AttivitaConnector attivitaConnector = new AttivitaConnector();
        attivitaConnector.addPrenotazione(email, id, num_posti);

        return false;
    }

    public Attivita(String nome_attivita, int num_posti, Attrezzatura attrezzatura) {
        this.nome_attivita = nome_attivita;
        this.num_posti = num_posti;
        this.attrezzatura = attrezzatura;
        attrezzatura.getNomeAttrezzatura();
        attrezzatura.getQuantita();
        //return nome_attivita;
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

	/*public String getNome_attrezzatira() {
		return nome_attrezzatura;
	}

	public void setNome_attrezzatira(String nome_attrezzatira) {
		this.nome_attrezzatura = nome_attrezzatura;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}*/
}