package org.strasa.web.main.view.model;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.strasa.middleware.manager.UserManagerImpl;
import org.strasa.middleware.manager.UserValidationManager;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;

public class Registration extends RegistrationModel {

	private String dateFormat;

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public String getForegroundColour() {
		return foregroundColour;
	}

	public void setForegroundColour(String foregroundColour) {
		this.foregroundColour = foregroundColour;
	}

	public String getBackgroundColour() {
		return backgroundColour;
	}

	public void setBackgroundColour(String backgroundColour) {
		this.backgroundColour = backgroundColour;
	}

	private String foregroundColour = "#000000", backgroundColour = "#FDC966";
	private String validationCode;

	@Command
	@NotifyChange("captcha")
	public void regenerate() {
		this.regenerateCaptcha();
	}

	@NotifyChange("*")
	@Command
	public void submit() {

		UserManagerImpl userManger = new UserManagerImpl();
		this.getUser().setRole("ROLE_USER");
		userManger.addUser(this.getUser());
		validationCode = new UserValidationManager().addValidation(user);
		System.out.println("Sending mail...");
		sendMail();
		Executions.sendRedirect("registrationmsg.zul");

	}

	public void sendMail() {

		String msg = "Hello " + this.getUser().getFirstname() + ", \n\n\n\n" + "Here is your activitaion code for the registration. Please click or the link to activate your account. Cheers! \n\n\n\n" + "<a href=\"http://localhost:8080/StrasaWeb/validate.zul?code="
				+ validationCode + "\"" + "";

		String from = "d.talay@irri.org", pass = "1nc0rr3cT";
		String[] to = { this.getUser().getEmail() };
		Properties props = System.getProperties();
		String host = "smtp.gmail.com";
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.password", pass);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);

		try {
			message.setFrom(new InternetAddress(from));
			InternetAddress[] toAddress = new InternetAddress[to.length];

			// To get the array of addresses
			for (int i = 0; i < to.length; i++) {
				toAddress[i] = new InternetAddress(to[i]);
			}

			for (int i = 0; i < toAddress.length; i++) {
				message.addRecipient(Message.RecipientType.TO, toAddress[i]);
			}

			message.setSubject("Activation code - DMAS ");
			message.setText(msg);
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (AddressException ae) {
			ae.printStackTrace();
		} catch (MessagingException me) {
			me.printStackTrace();
		}
	}

}
