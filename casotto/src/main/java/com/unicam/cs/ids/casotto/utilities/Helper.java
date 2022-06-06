package com.unicam.cs.ids.casotto.utilities;

import com.unicam.cs.ids.casotto.Connectors.OrdinazioneBarConnector;
import com.unicam.cs.ids.casotto.serviziobar.OrdinazioneBar;
import com.unicam.cs.ids.casotto.utenti.Cliente;

import java.util.Timer;
import java.util.TimerTask;


public class Helper {
    private int a_number;

    public int getNumber() {
        return a_number;
    }

    Timer timer;
    private int b_number;

    public void setNumber(int num) {
        b_number = num;
    }

    OrdinazioneBarConnector ordinazioneBarConnector = new OrdinazioneBarConnector();
    OrdinazioneBar ordinazione_bar = new OrdinazioneBar();
    SendEmail sendEmail = new SendEmail();
    Cliente cliente = new Cliente();
    public static int i = 1;
    int minutes = 0;
   /* public boolean sendMailBar(String recipient, String prodotti, int id_ordine, int id_ombrellone){
        boolean inviata=true;
        try {
            SendEmail.sendMailBar(recipient, prodotti, id_ordine, id_ombrellone);
            inviata= true;
        } catch (Exception e) {
            System.out.println("Errore nell'invio dell'email");
            e.printStackTrace();
            inviata=false;
        }
        return inviata;
    } */

    public Helper(int minutes) {
        timer = new Timer();
        timer.schedule(new RemindTask(), (minutes * 60000)); // schedule the task
    }

    class RemindTask extends TimerTask {
        //cliente.getProdotti_ordinati()
        //nel recipient mettere fchiocchi@libero.it
        public void run() {
            try {
                SendEmail.sendMailBar("matteotoma98@hotmail.it", cliente.getProdotti_ordinati(), cliente.getId_ordinazione(), cliente.getId_ombrellone(), cliente.getQuantita_prodotti());
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Errore");
            }
            timer.cancel(); //Terminate the timer thread
        }
    }

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        int minuti = 0;
        minuti = cliente.getNumber();
        Timer timer = new Timer();

        // run() method to carry out the action of the task
        new Helper(cliente.getNumber());
      /*        if(sendMailBar(cliente.getEmail(), ordinazione_bar.getLista_prodotti().toString(), ordinazioneBarConnector.last_ordinazione(cliente.getId_ombrellone()), cliente.getId_ombrellone())){
                   System.out.println("Ha funzionato");
               }
               else System.out.println("Nope"); */


        // timer.schedule(task, 0, cliente.getNumber());
        /*
         *  schedule() method to schedule the execution with start time
         */

    }
}

