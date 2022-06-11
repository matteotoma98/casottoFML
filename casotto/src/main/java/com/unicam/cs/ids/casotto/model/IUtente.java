package com.unicam.cs.ids.casotto.model;

public interface IUtente {

    void registrazione(String email, String username, String password);

    void login(String username, String password) throws Exception;

    String getRuolo();

    void setEmail(String email);

    void setRuolo(String ruolo);

    String getUsername();

    void registrazione(String username, String password, String ruolo, String nome, String cognome, String email);


}
