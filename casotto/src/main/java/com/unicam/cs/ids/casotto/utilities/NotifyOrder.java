package com.unicam.cs.ids.casotto.utilities;

import com.unicam.cs.ids.casotto.model.IObserver;

import java.util.ArrayList;
import java.util.List;

public class NotifyOrder implements IObserver {
    private String name;
    private List<IObserver> observers = new ArrayList<>();

    @Override
    public void register(IObserver o) {
        observers.add(o);
    }

    @Override
    public void unregister(IObserver o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (IObserver observer : observers) {
            observer.update();
            // observer.notifyAddettoSpiaggiaOmbrellone();
            //  observer.notifyAddettobar();
        }
    }

    public NotifyOrder(String OrderName) {
        name = OrderName;
    }

    public void update() {

        if (name.equals("Addetto SpiaggiaBar")) {
            try {
                SendEmail.sendMailOmbrellone("francesco.chiocchi@divini.org");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(name + " ha ricevuto l'ordine preparato dall'addetto al Bar\n");
            System.out.println("L'ordine ti verrà portato da " + name + "\n");
        }
        /*if(name.equals("Addetto SpiaggiaOmbrellone")){
            notifyAddettoSpiaggiaOmbrellone("francesco.chiocchi@divini.org",);
        }*/
    }

    public void notifyAddettoSpiaggiaOmbrellone(String emailcliente, String emailaddetto, int id_ombrellone) {
        if (name.equals("Addetto SpiaggiaOmbrellone")) {
            try {
                SendEmail.sendMailAddettoSpiaggiaOmbrellone(emailcliente, emailaddetto, id_ombrellone);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(name + " ha ricevuto l'ordine preparato dall'addetto al Bar\n");
            System.out.println("L'ordine ti verrà portato da " + name + "\n");
        }
    }

    public void notifyAddettobar(String emailcliente, String prodotti, int id_ordine, int id_ombrellone) {
        if (name.equals("Addetto SpiaggiaOmbrellone")) {
            try {
                SendEmail.sendMailBar("matteotoma98@hotmail.it", prodotti, id_ordine, id_ombrellone);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //  System.out.println(name + "Il cliente "+emailcliente+ " ha ordinato i seguenti prodotti: "+prodotti+"id_ordine: " +id_ordine);
            //   System.out.println("L'ombrellone a cui portare i prodotti è: " +id_ombrellone+" .");
            // System.out.println("L'ordine ti verrà portato da " + name + "\n");
        }
    }

    public void updateCliente(String email) {
        if (name.equals("Cliente Ombrellone")) {
            try {
                SendEmail.sendMailOmbrellone(email);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //  System.out.println(name + "Ciao, la prenotazione del tuo ombrellone è stata effettuata con successo. Questa è una mail di conferma, nel caso volessi " +"cancellare effettua il login dall'app di CasottoFML™\n");
        }
    }
}
