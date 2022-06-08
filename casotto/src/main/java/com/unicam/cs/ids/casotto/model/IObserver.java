package com.unicam.cs.ids.casotto.model;

import java.util.List;

public interface IObserver {

    public void register(IObserver o);

    public void unregister(IObserver o);

    public void notifyObservers();

    public void update();

    public void notifyAddettoSpiaggiaOmbrellone(String emailcliente, String emailaddetto, int id_ombrellone);

    public void notifyAddettobar(String emailcliente, List<String> prodotti, int id_ordine, int id_ombrellone, String quantita_prodotti);

    public void updateCliente(String email);
}
