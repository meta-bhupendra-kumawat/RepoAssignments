package com.metacube.MailSenderApp.service.implementations;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.metacube.MailSenderApp.service.MailSender;

/**
 * This is a component class. It consists of implementation for MailSender interface.
 * @author Bhupendra.
 */
@Component
public class MockMailSender implements MailSender {

	@Override
	public String send() {
		System.out.println("Mock Mail Received!");
		return "Mock Mail Received!";
	}
}
