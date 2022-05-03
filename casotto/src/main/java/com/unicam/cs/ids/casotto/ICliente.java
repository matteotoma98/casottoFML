package com.unicam.cs.ids.casotto;

import java.text.ParseException;

public interface ICliente {

  void PrenotazioneOmbrellone( ) ;
  void ordinazioneBar();
  void cancellazioneOmbrellone();
  void iscrizione_Attivita(Attivita attivita);
  public void registrazione(String email, String username, String password, int id_ombrellone);
}
