package com.respeso.springwebproject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@Autowired
	private AlienDao dao;
	
	/*
	 * Spring injects a new Model object
	 */
	@ModelAttribute
	public void modelData(Model m) {
		m.addAttribute("name", "Prjeel");
	}
	
	/*
	 * Most controller methods
	 * should be mapped to a specific HTTP method versus using @RequestMapping,
	 * which, by default, matches to all HTTP methods.
	 */
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	/*
	 * Old-fashioned way to use parameters/variables
	 */
	@RequestMapping("add.old")
	public String addOld(HttpServletRequest req) {
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		int k = i + j;

		// return "result.jsp?num3=" + k;
		HttpSession session = req.getSession();
		session.setAttribute("num3", k);
		
		return "result?num3" + k; // Suffix defined in application.proterties doesn't work here the
	}

	@RequestMapping("add.reqparam")
	public String addReqParam(@RequestParam("num1") int i, @RequestParam("num2") int j, HttpSession session) {
		int k = i + j;
		session.setAttribute("num3", k);
		
		return "result";
	}
	
	/*
	 * By adding "prefix" and "suffix" to application.properties we can locate the
	 * files of the views in other folder and always look up for the files ".jsp"
	 */
	@RequestMapping("add.modelandview") 
	public ModelAndView addModelAndView(@RequestParam("num1") int i, @RequestParam("num2") int j) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		int k = i + j;
		mv.addObject(k);
		
		return mv;
	}
	
	/*
	 * Abstraction of the view. Model and ModelMap are similar. ModelMap use a Map
	 * format to save data.
	 */
	@RequestMapping("add.model") 
	public String addModelAndModel(@RequestParam("num1") int i, @RequestParam("num2") int j, Model model) {
		int k = i + j;
		model.addAttribute("num3", k);
		
		return "result";
	}

	/*
	 * Adding POJOs in the Model
	 * The name of the variable is choose by default if the name of the RequestParam is not specified.
	 */
	@RequestMapping("addalien") 
	public String addAlien(@RequestParam int id, @RequestParam int age, Model model) {
		Alien alien = new Alien(id, age);
		model.addAttribute("alien", alien);
		
		return "alienresult";
	}
	
	/*
	 * Refactor of the code above using ModelAttribute. 
	 * The mapping of the properties is done automatically based on the name.
	 * Notice of if we respect the name of the Class of the param as the name of 
	 * the JSP variable ${alien}, it will work. It can be changed: 
	 * @ModelAttribute("name_in_the_jsp") Alien alien.
	 * If there is just one variable of type Alien and the name of the JSP variable
	 * is going to be the name of the class, we could even avoid the annotation. 
	 */
	@RequestMapping("addalien.modelattr") 
	public String addAlienModel(@ModelAttribute Alien a) {
		return "alienresult";
	}
	
	/*
	 * Staic exmaple of GET without using DB
	 */
//	@GetMapping("getAliens")
//	public String getAliens(Model m) {
//		List<Alien> aliens = Arrays.asList(new Alien(0, 12), new Alien(1, 55));
//		// Now we fetch the aliens with the DAO
//		return aliens.toString(); // error
//	}
	
	/*
	 * Using DB and Hibernate
	 */
	@GetMapping("getAliens")
	public String getAliens(Model m) {
		// Now we fetch the aliens with the DAO
		m.addAttribute("result", dao.getAliens());
		return "showAliens";
	}
	
	@GetMapping("getAlien")
	public String getAlien(@RequestParam int aid, Model m) {
		m.addAttribute("result", dao.getAlien(aid));
		return "showAliens";
	}
	
}
