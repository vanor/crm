package com.crm.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.crm.app.utils.CryptoUtils;
import com.crm.app.utils.StaticUtils;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Value("${app.file-base-location}")
	public void setFileBaseLocationStatic(String location) {
		StaticUtils.FILE_BASE_LOCATION = location;
	}
	
	@Value("${app.secret-key}")
	public void setSecretKey(String secretKey) {
		CryptoUtils.SECRET_KEY = secretKey;
	}
	
	@Value("${app.base-secret-url}")
	public void setBaseSecretUrl(String baseSecretUrl) {
		CryptoUtils.BASE_SECRET_URL = baseSecretUrl;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/css/**", "/js/**", "/images/**", "/fonts/**", "/register", 
						"/enquiry", "/redirect", "/saveBusiness", "/register-your-account", 
						"/register-your-business", "/new-account", "/external-company-**", 
						"/toggle-validation-question-**", "/files/**").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login").permitAll()
				.and()
			.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login");
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder(11);
	}
}
