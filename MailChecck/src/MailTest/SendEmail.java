package MailTest;

 
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.omg.PortableInterceptor.USER_EXCEPTION;

import javax.mail.internet.*;
import javax.mail.*;
import javax.activation.*;

public class SendEmail {
  public static void main(String[] args) {
  final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
  // Get a Properties object
     Properties props = System.getProperties();
     props.setProperty("mail.smtp.host", "smtp.gmail.com");
     props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
     props.setProperty("mail.smtp.socketFactory.fallback", "false");
     props.setProperty("mail.smtp.port", "465");
     props.setProperty("mail.smtp.socketFactory.port", "465");
     props.put("mail.smtp.auth", "true");
     props.put("mail.debug", "true");
     props.put("mail.store.protocol", "pop3");
     props.put("mail.transport.protocol", "smtp");
     final String username = "DummyMail@xyz.com";//
     final String password = "yourPassword";
     try{
     Session session = Session.getDefaultInstance(props, 
                          new Authenticator(){
                             protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(username, password);
                             }});

   // -- Create a new message --
     Message msg = new MimeMessage(session);

  // -- Set the FROM and TO fields --
     msg.setFrom(new InternetAddress(username,"Name by which u want to send"));
     msg.setRecipients(Message.RecipientType.BCC, 
                      InternetAddress.parse("To@gmail.com",false));
     msg.setSubject("Invitation for the PARTY");
     msg.setText("Hello, we team of INFOSYS CHD invite you to the SUNDERBAN HALL,dresscode is saree and chief guest is MR. VISHAL GUPTA");
     msg.setSentDate(new Date());
     
     //Attachemnt code
 
           //attachment code ends here
     Transport.send(msg);
     System.out.println("Message sent.");
  }catch (Exception e){ System.out.println(e);}
  }
}