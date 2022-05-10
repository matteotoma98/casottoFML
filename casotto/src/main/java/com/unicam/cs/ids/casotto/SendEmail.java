package com.unicam.cs.ids.casotto;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

    public static void sendMail(String recepient) throws Exception {
        System.out.println("Preparing to send email");
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
        Message message = prepareMessage(session, myAccountEmail, recepient);
        Transport.send(message);
        System.out.println("Messaggio inviato correttamente");
    }

    private static Message prepareMessage(Session session, String myAccountEmail, String recepient) {

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("CasottoFML™");
            message.setText("Ciao" + myAccountEmail + " , ci sono delle nuove attività allo chalet CasottoFML™,  \n effettua il Login per dare un'occhiata e prenotarti!");
            return message;
        } catch (Exception ex) {
            Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}