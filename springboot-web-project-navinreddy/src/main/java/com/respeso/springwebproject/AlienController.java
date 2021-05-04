package com.respeso.springwebproject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody - tells a controller that the object returned is automatically serialized into JSON and passed back into the HttpResponse object.
//@Controller
@RestController // = @Controller + @ResponseBody. See javadoc
public class AlienController {
	
	@Autowired
	private AlienRepo repo;
	
	/*
	 * We dont use Model here, because no JSPs and session are used
	 * With @ResponseBody we specify that we want the data, the string list of aliens.
	 * Otherwise the return will be interpreted as a JSP page to show, and it will give a 404 after retrieve the data.
	 */
	/*
	 * Jackson API (dependency of Spring Boot) converts the objects to JSON
	 * automatically.
	 * We we want Jackson to converting it to XML, we need another dependency: Jackson Dataformat XML
	 * CAREFUL WITH THE VERSION: Do not override the using one, so delete the tag <version>
	 * 
	 * With the attributes "produces" we limit the output format
	 */
//	@ResponseBody - in class level
	@GetMapping(value = "aliens", produces = MediaType.APPLICATION_XML_VALUE)
	public List<Alien> getAliens() {
		System.out.println("Fetching aliens...");
		// Now we fetch the aliens with the DAO
//		int i = 9/0; // exception to show the AfterThrowing case
		return repo.findAll();
	}
	
//	@ResponseBody - in class level
	@GetMapping("alien/{aid}")
	public Alien getAliens(@PathVariable Integer aid) {
		// Now we fetch the aliens with the DAO
		Alien a = repo.findById(aid).orElse(new Alien());
		return a;
	}
	

	/*
	 * It is mandatory to use @RequestBody in the param if we are going to receive a JSON in a raw format
	 * Maps the HttpRequest body to a transfer or domain object, enabling automatic deserialization.
	 * If we send data as form-data there is no problem
	 * If the "consumes" property is not specified, the service can received json or xml
	 * but if it is defined, it only can return the specifed format, 415 error otherwise
	 */
//	@ResponseBody - in class level
	@PostMapping(path = "alien", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Alien addAlien(@RequestBody Alien a) {
		// Now we fetch the aliens with the DAO
		return repo.save(a);
	}
	
}
