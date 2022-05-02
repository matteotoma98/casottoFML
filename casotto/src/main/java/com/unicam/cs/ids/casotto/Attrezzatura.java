package com.unicam.cs.ids.casotto;

import java.util.List;

public class Attrezzatura {
    private String nomeAttrezzatura;
    private int quantita;

    public String getNomeAttrezzatura() {
        return nomeAttrezzatura;
    }

    public void setNomeAttrezzatura(String nomeAttrezzatura) {
        this.nomeAttrezzatura = nomeAttrezzatura;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public Attrezzatura(String nAttr, int q){
        this.nomeAttrezzatura= nAttr;
        this.quantita= q;
    }


}
