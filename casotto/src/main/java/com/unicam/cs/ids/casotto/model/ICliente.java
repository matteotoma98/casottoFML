package com.unicam.cs.ids.casotto.model;

public interface ICliente {

    void PrenotazioneOmbrellone(String email) throws Exception;

    void ordinazioneBar(String email) throws Exception;

    void cancellazionePrenotazioneOmbrellone(String email) throws Exception;

    boolean iscrizione_Attivita(String email) throws Exception;

    void registrazione(String email, String username, String password);
}
