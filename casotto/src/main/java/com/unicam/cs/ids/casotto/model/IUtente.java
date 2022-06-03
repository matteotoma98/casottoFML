package com.unicam.cs.ids.casotto.model;

public interface IUtente {

    void registrazione(String email, String username, String password);

    public void login(String username, String password) throws Exception;

    public String getRuolo();

    public void setEmail(String email);

    public void setRuolo(String ruolo);

    public String getUsername();

    public void registrazione(String username, String password, String ruolo, String nome, String cognome, String email);


}
