package com.unicam.cs.ids.casotto;

import java.text.ParseException;

public interface ICliente {

    void PrenotazioneOmbrellone(String email);

    void ordinazioneBar(String email);

    public void cancellazionePrenotazioneOmbrellone(String email);

    public boolean iscrizione_Attivita(String email);

    public void registrazione(String email, String username, String password, int id_ombrellone);
}
