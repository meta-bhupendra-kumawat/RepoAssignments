package com.metacube.MailSenderApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.MailSenderApp.service.MailSender;
import com.metacube.MailSenderApp.service.implementations.MockMailSender;

/**
 * This is a controller class. 
 * @author Bhupendra.
 */
@RestController
public class MailAppController {

//	@Autowired
	private MailSender mailSender;

	/**
	 * Calling another component that is MockMailSender by using SMTP Mail bean as
	 * Primary bean. Use @Autowire for finding another non primary bean object(Here
	 * MockMailSender class object).
	 */
	@Autowired
	private MockMailSender mck;

	// Constructor.
	@Autowired
	public MailAppController(@Qualifier("SmtpSender") MailSender mailSender) {
		this.mailSender = mailSender;
		System.out.println("Constructor");
	}

	// Setter.
	@Autowired
	public void setMailSender(@Qualifier("SmtpSender")MailSender mailSender) {
		this.mailSender = mailSender;
		System.out.println("Setter");
	}

	// Mapping method call with the given url.
	@RequestMapping("/sendmail")
	public String display() {
		return mck.send() + "<br>" + mailSender.send();
	}
}
