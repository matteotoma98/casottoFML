package com.unicam.cs.ids.casotto.model;

public interface IObserver {

    public void register(IObserver o);

    public void unregister(IObserver o);

    public void notifyObservers();

    public void update();

    public void notifyAddettoSpiaggiaOmbrellone(String emailcliente, String emailaddetto, int id_ombrellone);

    public void notifyAddettobar(String emailcliente, String prodotti, int id_ordine, int id_ombrellone, String quantita_prodotti);

    public void updateCliente(String email);
}
