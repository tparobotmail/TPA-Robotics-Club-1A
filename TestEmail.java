import java.io.UnsupportedEncodingException;
import java.util.*;

//import java.*;

//import javax.mail.internet.*;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.PasswordAuthentication;
//import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
//import javax.activation.*;

public class TestEmail {

    public static void main(String[] args) throws UnsupportedEncodingException {

       String host = "smtp.gmail.com";
       int port = 465;
       //String username = "tparobotmail@gmail.com";
      
       
        // Create properties, get Session
        Properties props = new Properties();

        
        props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		//props.put("mail.smtp.socketFactory.fallback", "false");
        // To see what is going on behind the scene
        props.put("mail.debug", "true");
          
        Session session = Session.getDefaultInstance(props,
      	  new javax.mail.Authenticator() {
      		protected PasswordAuthentication getPasswordAuthentication() {
      		  return new PasswordAuthentication("tparobotmail@gmail.com", "blah blah blah");
      			}
      		});

        try {
            // Instantiate a message
            Message msg = new MimeMessage(session);

            //Set message attributes
            msg.setFrom(new InternetAddress("tparobotmail@gmail.com", "Mr. DiCaro's mail-o-matic"));
            //msg.setRecipient(Message.RecipientType.TO, new InternetAddress("tparobotmail@gmail.com", "mail-o-matic"));
           // Address[] emailListTo=InternetAddress.parse("dcj1000@gmail.com, adicaro@tempeprep.org, jddisch@msn.com, frc@tempeprep.org, cheeto10x@yahoo.com, mlbeene@cox.net");
            Address[] emailListTo=InternetAddress.parse("dcj1000@gmail.com");
            Address[] emailListCC=InternetAddress.parse("tparobotmail@gmail.com, adicaro@tempeprep.org");
            Address[] emailListBCC=InternetAddress.parse("6022951394@vzwpix.com");
            msg.addRecipients(Message.RecipientType.TO, emailListTo);
            msg.addRecipients(Message.RecipientType.CC, emailListCC);
            msg.addRecipients(Message.RecipientType.BCC, emailListBCC);

            msg.setSubject("Mr DiCaro's TPA Robot Mail email test using a Java class");
            msg.setSentDate(new Date());

            // Set message content
             msg.setText("Hi All \n" +
                         "This is a bulk email test using a Java Mail program to send an email to the group.\n" +
            		     "It contains TO, CC, BCC lists. I developed this java class using Eclipse. \n" +
            		     "Eclipse is a free Integrated Development Environment (ide). I am doing \n" +
            		     "it on my Mac.I also created a gmail account called tparobotmail@gmail.com \n" +
            		     "which can be used as a general email account for the robot. The class uses SSL to \n" +
            		     "to send a secure email from this java program to the tparobotmail account on gmail \n" +
            		     "and then out to you guys. Please let me know if you receive it. Thx."
            		    );

            //Send the message
            
            Transport.send(msg);
        }
        catch (MessagingException mex) {
            // Prints all nested (chained) exceptions as well
            mex.printStackTrace();
        }


    }
    	
} //End of class

