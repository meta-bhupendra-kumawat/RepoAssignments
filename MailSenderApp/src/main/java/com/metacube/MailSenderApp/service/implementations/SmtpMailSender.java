package com.metacube.MailSenderApp.service.implementations;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.metacube.MailSenderApp.service.MailSender;

/**
 * This is a component class. It consists of implementation for MailSender interface.
 * @author Bhupendra.
 */
@Primary
@Component
public class SmtpMailSender implements MailSender {

	@Override
	public String send() {
		System.out.println("Smtp Mail Received!!");
		return "Smtp Mail Received!!";
	}
}
