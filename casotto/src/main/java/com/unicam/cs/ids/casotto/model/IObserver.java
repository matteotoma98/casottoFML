package com.unicam.cs.ids.casotto.model;

import java.util.List;

public interface IObserver {

    void register(IObserver o);

    void unregister(IObserver o);

    void notifyObservers();

    void update();

    void notifyAddettoSpiaggiaOmbrellone(String emailcliente, String emailaddetto, int id_ombrellone);

    void notifyAddettobar(String emailcliente, List<String> prodotti, int id_ordine, int id_ombrellone, String quantita_prodotti);

    void updateCliente(String email);
}
