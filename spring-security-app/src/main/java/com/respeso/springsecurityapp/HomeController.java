package com.respeso.springsecurityapp;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	 * To configure this you can use anotations or create a Config Class @see  {@link AppSecurityConfig_old}
	 * 
	 */
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/login")
	public String loginPage()
	{
		return "login.jsp";
	}
	
	@RequestMapping("/logout-success")
	public String logoutPage()
	{
		return "logout.jsp";
	}
	
	@RequestMapping("user")
	@ResponseBody
	public Principal user(Principal principal)
	{
		return principal;
	}
}
