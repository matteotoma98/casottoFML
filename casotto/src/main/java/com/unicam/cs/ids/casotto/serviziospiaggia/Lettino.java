package com.unicam.cs.ids.casotto.serviziospiaggia;

import com.unicam.cs.ids.casotto.serviziogestione.TariffaPrezzi;

public class Lettino {
    private int id_lettino;
    private TariffaPrezzi tariffaPrezzi;
    public PrenotazioneSpiaggia riserva;
    public TariffaPrezzi appartiene;

    public Lettino() {
        throw new UnsupportedOperationException();
    }

    public void getTariffaPrezzi(Object aPrezzoLettino) {
        throw new UnsupportedOperationException();
    }

    public Lettino(int id_lettino, TariffaPrezzi tariffaPrezzi, boolean disponibilita) {
        this.id_lettino = id_lettino;
        this.tariffaPrezzi = tariffaPrezzi;
    }

    public int getId_lettino() {
        return id_lettino;
    }

    public void setId_lettino(int id_lettino) {
        this.id_lettino = id_lettino;
    }

    public TariffaPrezzi getTariffaPrezzi() {
        return tariffaPrezzi;
    }

    public void setTariffaPrezzi(TariffaPrezzi tariffaPrezzi) {
        this.tariffaPrezzi = tariffaPrezzi;
    }

}