package utilities;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.io.File;
import jakarta.mail.PasswordAuthentication;
import java.util.Properties;

public class EmailUtils {

    public static void sendTestReportEmail(String reportPath){ //Can be called without creating an object

        //Sender Credentials
        final String senderEmail = "sanjaykharel199@gmail.com";
        final String appPassword = "evsownvrjpjxnbga";
        final String recipientEmail = "sanjaykharel199@gmail.com" ;
        final String recipientEmail2 = "sandhyagyawali63@gmail.com";
        final String recipientEmail3 = "sakuntalasharma0406@gmail.com";

        // SMTP Server Properties
        Properties prop = new Properties();  //Creates a Properties object to hold mail server settings.
        prop.put("mail.smtp.auth", "true"); //Tells SMTP server that login authentication is required.
        prop.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        prop.put("mail.smtp.starttls.enable", "true"); //Enables encryption using TLS.
        prop.put("mail.smtp.port", "587"); //Port 587 is used for TLS email sending.

        // Create session with Authentication
        Session session = Session.getInstance(prop, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, appPassword);
            }
        });
        session.setDebug(true);

        try {
            // Create Email message
            Message message = new MimeMessage(session);  //Creates a new email object.
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("hgiri0576@gmail.com"));
            message.setRecipients(Message.RecipientType.CC,InternetAddress.parse(recipientEmail2));
            message.setRecipients(Message.RecipientType.BCC,InternetAddress.parse(recipientEmail3));
            message.setSubject("Test Email From Ebooking QA Automation");

            // Email Body Part
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText("Hello \n\n This is a Ebooking QA Automation test email from Java \n\n Regards,\nQA Team");

            // Attachment Part
            MimeBodyPart attachmentPart = new MimeBodyPart();
            System.out.println("Attachment path is - "+ reportPath);
            attachmentPart.attachFile(new File(reportPath));

            // Combine body and attachment parts
            MimeMultipart multipart = new MimeMultipart();
            multipart.addBodyPart(textPart);
            multipart.addBodyPart(attachmentPart);
            message.setContent(multipart);

            // Send Email
            Transport.send(message);
            System.out.println("Email Sent Successfully ***");

        } catch (Exception e) {
            e.printStackTrace(); //printStackTrace() prints detailed error information.
        }

    }
}
