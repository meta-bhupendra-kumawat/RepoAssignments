package com.metacube.MailSenderApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.metacube.MailSenderApp.service.MailSender;
import com.metacube.MailSenderApp.service.implementations.SmtpMailSender;

/**
 * This is a configuration class.
 * @author Bhupendra.
 */
@Configuration
public class MailAppConfig {

	/**
	 * When we use @Component , we don't need to use @Bean annotation for
	 * instantiation of objects.
	 * 
	 * @Primary is used with and before @Component annotation. If we use @Component,
	 *          there will be no need to create configuration file. If we use
	 *          both @Component and @Bean, there will be an error.
	 */
	
//	@Bean
//	public MailSender smtpMailSender() {
//		return new SmtpMailSender2();
//	}

//	@Bean
//	public MailSender mockMailSender() {
//		return new MockMailSender();
//	}
}
