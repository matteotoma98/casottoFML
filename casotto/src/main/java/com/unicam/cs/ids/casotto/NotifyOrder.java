package com.unicam.cs.ids.casotto;

import java.sql.SQLOutput;
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
        }
    }

    NotifyOrder(String OrderName) {
        name = OrderName;
    }

    public void update() {
        if (name.equals("Addetto Bar")) {
            try {
                SendEmail.sendMail("fchiocchi@libero.it");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(name + " ha ricevuto l'ordine\n");
        }

        if (name.equals("Addetto Spiaggia")) {
            try {
                SendEmail.sendMail("francesco.chiocchi@divini.org");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(name + " ha ricevuto l'ordine preparato dall'addetto al Bar\n");
            System.out.println("L'ordine ti verrà portato da " + name + "\n");
        }
    }

    public void updateCliente(String email) {
        if (name.equals("Cliente Bar")) {
            try {
                SendEmail.sendMail(email);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(name + "Ciao, questo è il riepilogo del tuo ordine dal bar di CasottoFML™ hai ordinato dal bar {lista prodotti}\n");
        }
        if (name.equals("Cliente Ombrellone")) {
            try {
                SendEmail.sendMail(email);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(name + "Ciao, la prenotazione del tuo ombrellone è stata effettuata con successo. Questa è una mail di conferma, nel caso volessi " +
                    "cancellare effettua il login dall'app di CasottoFML™\n");
        }
    }
}
