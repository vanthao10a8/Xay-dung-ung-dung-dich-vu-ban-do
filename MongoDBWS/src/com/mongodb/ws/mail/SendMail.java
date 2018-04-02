package com.mongodb.ws.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class SendMail {
	/**
	   Outgoing Mail (SMTP) Server
	   requires TLS or SSL: smtp.gmail.com (use authentication)
	   Use Authentication: Yes
	   Port for TLS/STARTTLS: 587
	 */
	public static boolean sendMail (String recvmail, String hoten, String cmnd, String passcode) {
		final String fromEmail = "johnnguyen140894@gmail.com"; 
		final String password = "francaisecn"; 
		final String toEmail = recvmail; 
		////////////////////////////////////////////////////////////////////////////////////
		String subject = "Thông báo đăng ký thông tin tài xế thành công";
		String body = "Chào "+hoten+","
				+ "\n\n Bạn đã đăng ký thông tin tài xế thành công. Để có thể đăng nhập vui lòng "
				+ "sử dụng tài khoản và mật khẩu chúng tôi cung cấp bên dưới.\n\n"
				+ "\n Tên tài khoản:"+cmnd+""
						+ "\n Mật khẩu: "+passcode+""
								+ "\n\n Sau khi đăng nhập bạn có thể thay đổi mật khẩu."
								+ "\n Vui lòng không reply mail này, Xin chân thành cảm ơn!";	
		///////////////////////////////////////////////////////////////////////////////////
		System.out.println("TLSEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtp.port", "587"); //TLS Port
		props.put("mail.smtp.auth", "true"); //enable authentication
		props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
		
             //create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		Session session = Session.getInstance(props, auth);
		try
		{
			EmailUtil.sendEmail(session, toEmail, subject, body);
			return true;
		}catch (Exception e)
		{
			return false;
		}			
	}
}
