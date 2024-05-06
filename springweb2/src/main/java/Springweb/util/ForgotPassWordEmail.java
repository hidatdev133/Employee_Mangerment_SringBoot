package Springweb.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import springweb.service.thanhvienService;

@Component
public class ForgotPassWordEmail {
    @Autowired
    private thanhvienService membersService; 

    public void sendPasswordByEmail(String toEmail) {
        String fromEmail = "datdeptrai30114@gmail.com"; 
        String fromPassword = "vgym brlo opsa huld"; 

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, fromPassword);
            }
        });

        try {
            // Lấy password từ email
            String password = membersService.getEmail(toEmail);

            if (password != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");

                Date now = new Date();
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(fromEmail));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
                message.setSubject("Forgot PassWord");
                 message.setText("Your password is: " + password + "\n" +
                    "Sent at: " + sdf.format(now));

                Transport.send(message);
                System.out.println("Email sent successfully!");
            } else {
                System.out.println("Failed to retrieve password for email: " + toEmail);
            }
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
