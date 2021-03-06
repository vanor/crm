package com.crm.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry) {
		//registry.addViewController("/").setViewName("index");
		registry.addViewController("/login").setViewName("login");
		//registry.addViewController("/enquiry").setViewName("register");
		//registry.addViewController("/register").setViewName("register_provider");
	}
}
