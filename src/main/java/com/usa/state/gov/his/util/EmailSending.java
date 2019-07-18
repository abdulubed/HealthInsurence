package com.usa.state.gov.his.util;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.text.StrSubstitutor;

import com.usa.state.gov.his.model.AdminModel;

@Component
public class EmailSending {
	
	@Autowired
	private JavaMailSender sender;
	
	/**
	 * 
	 * method to send email to the user having all the data
	 * @param model
	 * @throws MessagingException 
	 * @throws AddressException 
	 */
	
	public void emailSending(AdminModel model)  {
		try {
		MimeMessageHelper helper=null;
		MimeMessage message=null;
		String fileName=null;
		// read the file
		fileName="Email/EmailMessage.txt";
		BufferedReader br = new BufferedReader(new FileReader(fileName));
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        Map<String , String> values=new HashMap<>();
	        values.put("FNAME", model.getFirstName());
        	values.put("LNAME", model.getLastName());
        	values.put("PWD", model.getPassword());
        	values.put("EMAIL", model.getEmail());
        	values.put("ROLE", model.getRole());
        	values.put("PHNO", "9492960786");
        	values.put("URL", "https://www.instagram.com/anupamaparameswaran96/?hl=en");
        	values.put("STATUS", model.getStatus());
	        while (line != null) {
	            //StrSubstitutor.replace(line, values);
	            String newLine=StrSubstitutor.replace(line, values);
	            System.out.println(newLine);
	            sb.append(newLine); 
	            sb.append("\n");
	            line = br.readLine();
	        }
	    System.out.println(sb);      
        message=sender.createMimeMessage();
		helper=new MimeMessageHelper(message,true);
		String msg=sb.toString();
		message.setContent(msg, "text/html; charset=utf-8");
		helper.setText(msg);
		helper.setFrom(new InternetAddress("shaikabdulubed@gmail.com"));
		helper.setTo(new InternetAddress(model.getEmail()));
		System.out.println(model.getEmail());
		helper.setSubject("HIS Application");
		helper.setSentDate(new Date());
		sender.send(message);
	}
		catch(Exception e) {
			e.printStackTrace();
		}
}

	
}

	


