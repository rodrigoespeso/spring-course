package com.respeso.springsecurityapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	/**
	 * 1. Request login & pass
	 * 2. Verify
	 * 3. Mantain the sesion
	 * Using Spring Security we can achives all these features with one dependency:
	 * Spring Security Boot Starter
	 * For default we got an login page Spring Boot courtesy ;)
	 * user/[generated security password in the console]
	 * 
	 * To configure this you can use anotations or create a Config Class @see  {@link AppSecurityConfig}
	 * 
	 */
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
}
