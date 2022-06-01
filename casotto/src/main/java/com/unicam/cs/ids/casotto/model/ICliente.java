package com.unicam.cs.ids.casotto.model;

public interface ICliente {

    void PrenotazioneOmbrellone(String email) throws Exception;

    void ordinazioneBar(String email);

    public void cancellazionePrenotazioneOmbrellone(String email);

    public boolean iscrizione_Attivita(String email);

    public void registrazione(String email, String username, String password);
}
