package com.unicam.cs.ids.casotto;

import java.util.Date;

public class Scontrino {

        private int id_scontrino;
        private Date data_scontrino;
        private int id_ombrellone;
        private double prezzo_totale;

        @Override
        public String toString() {
            return "Scontrino{" +
                    "id_scontrino=" + id_scontrino +
                    ", data_scontrino=" + data_scontrino +
                    ", id_ombrellone=" + id_ombrellone +
                    ", prezzo_totale=" + prezzo_totale +
                    '}';
        }

        public Scontrino(int id_scontrino, Date data_scontrino, int id_ombrellone, double prezzo_totale) {
                this.id_scontrino = id_scontrino;
                this.data_scontrino = data_scontrino;
                this.id_ombrellone = id_ombrellone;
                this.prezzo_totale = prezzo_totale;
        }

        public int getId_scontrino() {
                return id_scontrino;
        }

        public void setId_scontrino(int id_scontrino) {
                this.id_scontrino = id_scontrino;
        }

        public Date getData_scontrino() {
                return data_scontrino;
        }

        public void setData_scontrino(Date data_scontrino) {
                this.data_scontrino = data_scontrino;
        }

        public int getId_ombrellone() {
                return id_ombrellone;
        }

        public void setId_ombrellone(int id_ombrellone) {
                this.id_ombrellone = id_ombrellone;
        }

        public double getPrezzo_totale() {
                return prezzo_totale;
        }

        public void setPrezzo_totale(double prezzo_totale) {
                this.prezzo_totale = prezzo_totale;
        }
}
