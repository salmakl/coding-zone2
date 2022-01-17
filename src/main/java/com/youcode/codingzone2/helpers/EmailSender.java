package com.youcode.codingzone2.helpers;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSender {
    public static void sendMail(String email, String accessCode, String url) throws MessagingException {
        Properties props = new Properties();

        props.put("mail.smtp.ssl.trust", "*");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.starttls.enable", "true");

        final String myEmail = "email";
        final String password = "password";

        Session session = Session.getInstance(props,new Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return  new PasswordAuthentication(myEmail,password);
            }
        });
        Message sendMsg = prepareMessage(session, myEmail, email, accessCode, url);
        Transport.send(sendMsg);
        System.out.println("Message envoyé avec succes !!");
    }

    private static Message prepareMessage(Session session, String myEmail, String email, String accessCode, String url){

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(myEmail));
            msg.setRecipient(Message.RecipientType.TO,new InternetAddress(email));
            msg.setSubject("You have a new quizz on Coding Zone!");
            msg.setContent("<div>" +
                            "    <span>You have been invited to pass a quizz on Coding Zone !</span>" +
                            "    <p>Here are the details</p>" +
                            "    <ul>" +
                            "        <li><a href="+ url +">Quizz</a></li>" +
                            "        <li>Access Code : "+ accessCode +"</li>" +
                            "    </ul>" +
                            "</div>",
                    "text/html; charset=utf-8");
            return  msg;

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return  null;
    }
}
