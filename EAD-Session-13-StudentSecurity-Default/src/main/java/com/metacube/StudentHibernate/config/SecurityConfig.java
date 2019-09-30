package com.metacube.StudentHibernate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Spring Security configuration file 
 * @author Bhupendra
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(final AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication()
		.withUser("bhupendra").password(passwordEncoder().encode("kumawat")).roles("Admin").and()
				.withUser("vinay").password(passwordEncoder().encode("pancholi")).roles("User");
	}

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		
		 http.authorizeRequests().antMatchers("/home")
         .hasAnyRole("User", "Admin").antMatchers("/showStudent").hasAnyRole("User", "Admin")
         .antMatchers("/signUp").hasAnyRole("Admin").anyRequest().authenticated().and().formLogin()
         .loginPage("/login")
         .defaultSuccessUrl("/home", true)
         .permitAll().and().logout().permitAll();

     http.csrf().disable();

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
