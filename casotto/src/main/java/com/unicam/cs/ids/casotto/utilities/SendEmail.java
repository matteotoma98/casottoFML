package com.unicam.cs.ids.casotto.utilities;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SendEmail {

    public static boolean sendMail(String recipient) throws Exception {
        boolean inviata = false;
        Properties properties = new Properties();
        properties.put("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.host", "smtp.gmail.com");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
        //  properties.put("mail.debug", "true");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.fallback", "false");
        String myAccountEmail = "matteotomaKingdomHearts@gmail.com";
        String password = "nebamhselddwspis"; //password generata da google app generate: https://support.google.com/accounts/answer/185833?hl=it
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
        Message message = prepareMessage(session, myAccountEmail, recipient);
        Transport.send(message);
        inviata = true;
        // System.out.println("Email inviate correttamente");
        return inviata;
    }

    private static Message prepareMessage(Session session, String myAccountEmail, String recipient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("CasottoFML™");
            message.setText("Ciao " + myAccountEmail + ", un'attività a cui sei iscritto presso lo chalet CasottoFML™ è stata aggiornata,  \n effettua il Login per dare un'occhiata e prenotarti!");
            return message;
        } catch (Exception ex) {
            Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void sendEmailBarCliente(String recipient, List<String> prodotti, int id_ordine, int id_ombrellone, String quantita_prodotti, int minuti) throws Exception {
        Properties properties = new Properties();
        properties.put("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.host", "smtp.gmail.com");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
        //  properties.put("mail.debug", "true");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.fallback", "false");
        String myAccountEmail = "matteotomaKingdomHearts@gmail.com";
        String password = "nebamhselddwspis"; //password generata da google app generate: https://support.google.com/accounts/answer/185833?hl=it
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
        Message message = prepareMessageBarCliente(session, myAccountEmail, recipient, prodotti, id_ordine, id_ombrellone, quantita_prodotti, minuti);
        Transport.send(message);
        // System.out.println("Messaggio inviato correttamente");
    }

    private static Message prepareMessageBarCliente(Session session, String myAccountEmail, String recipient, List<String> prodotti, int id_ordine, int id_ombrellone, String quantita_prodotti, int minuti) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("CasottoFML™");
            message.setText("Ciao, il tuo ordine relativo è stato confermato. \nRiepilogo ordine: prodotti: " + prodotti + "\nQuantità: " + quantita_prodotti + ".\n3 Tra circa " + minuti + " minuti arriverà un'addetto spiaggia con il tuo ordine al tuo ombrellone " + id_ombrellone + ".");
            return message;
        } catch (Exception ex) {
            Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void sendMailBar(String recipient, List<String> prodotti, int id_ordine, int id_ombrellone, String quantita_prodotti) throws Exception {
        Properties properties = new Properties();
        properties.put("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.host", "smtp.gmail.com");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
        //  properties.put("mail.debug", "true");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.fallback", "false");
        String myAccountEmail = "matteotomaKingdomHearts@gmail.com";
        String password = "nebamhselddwspis"; //password generata da google app generate: https://support.google.com/accounts/answer/185833?hl=it
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
        Message message = prepareMessageBar(session, myAccountEmail, recipient, prodotti, id_ordine, id_ombrellone, quantita_prodotti);
        Transport.send(message);
        // System.out.println("Messaggio inviato correttamente");
    }

    private static Message prepareMessageBar(Session session, String myAccountEmail, String recipient, List<String> prodotti, int id_ordine, int id_ombrellone, String quantita_prodotti) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("CasottoFML™");
            message.setText("ID ordine:" + id_ordine + ".\n prodotti ordinati: " + prodotti + " quantità prodotti: " + quantita_prodotti + " .\n Ombrellone n°: " + id_ombrellone + ".\n associato al cliente: " + recipient + " .");
            return message;
        } catch (Exception ex) {
            Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void sendMailAddettoSpiaggiaOrdine(String recipient, int id_ordine, int id_ombrellone) throws Exception {
        Properties properties = new Properties();
        properties.put("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.host", "smtp.gmail.com");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
        //  properties.put("mail.debug", "true");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.fallback", "false");
        String myAccountEmail = "matteotomaKingdomHearts@gmail.com";
        String password = "nebamhselddwspis"; //password generata da google app generate: https://support.google.com/accounts/answer/185833?hl=it
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
        Message message = prepareMessageAddettoSpiaggiaOrdine(session, myAccountEmail, recipient, id_ordine, id_ombrellone);
        Transport.send(message);
        // System.out.println("Messaggio inviato correttamente");
    }

    private static Message prepareMessageAddettoSpiaggiaOrdine(Session session, String myAccountEmail, String recipient, int id_ordine, int id_ombrellone) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("CasottoFML™");
            message.setText("L'ordine:" + id_ordine + ".\n è pronto. Consegnarlo all'ombrellone : " + id_ombrellone + ".");
            return message;
        } catch (Exception ex) {
            Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


    public static void sendMailOmbrellone(String recipient) throws Exception {
        //  System.out.println("Preparing to send email");
        Properties properties = new Properties();
        properties.put("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.host", "smtp.gmail.com");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
        //  properties.put("mail.debug", "true");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.fallback", "false");
        String myAccountEmail = "matteotomaKingdomHearts@gmail.com";
        String password = "nebamhselddwspis"; //password generata da google app generate: https://support.google.com/accounts/answer/185833?hl=it
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
        Message message = prepareMessageOmbrellone(session, myAccountEmail, recipient);
        Transport.send(message);
        System.out.println("Messaggio inviato correttamente");
    }

    private static Message prepareMessageOmbrellone(Session session, String myAccountEmail, String recipient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("CasottoFML™");
            message.setText("Ciao " + myAccountEmail + " , hai prenotato il tuo ombrellone con successo CasottoFML™,  \n. Ricordati che puoi annullare in qualsiasi " +
                    "momento la tua prenotazione effettuando il login e scegliendo \033[3mcancella prenotazione ombrellone\033[0m dal menù");
            return message;
        } catch (Exception ex) {
            Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void sendMailAddettoSpiaggiaOmbrellone(String cliente, String recipient, int id_ombrellone) throws Exception {
        Properties properties = new Properties();
        properties.put("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.host", "smtp.gmail.com");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
        //  properties.put("mail.debug", "true");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.fallback", "false");
        String myAccountEmail = "matteotomaKingdomHearts@gmail.com";
        String password = "nebamhselddwspis"; //password generata da google app generate: https://support.google.com/accounts/answer/185833?hl=it
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
        Message message = prepareMessaggeAddettoSpiaggiaOmbrellone(session, myAccountEmail, recipient, id_ombrellone, cliente);
        Transport.send(message);
        System.out.println("Messaggio inviato correttamente");
    }

    private static Message prepareMessaggeAddettoSpiaggiaOmbrellone(Session session, String myAccountEmail, String recipient, int id_ombrellone, String cliente) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("CasottoFML™");
            message.setText("Ciao, il cliente " + cliente + " ha prenotato l'ombrellone " + id_ombrellone);
            return message;
        } catch (Exception ex) {
            Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}