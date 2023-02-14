package dev.jahm.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}

	/**
	 * Method to establish a starting point to the Web page.
	 * The final path depends on the method's parameter value.
	 * For instance, <code>http://localhost:8080/parameter_value</code>
	 * @return the message to display in the Web page.
	 */
	@GetMapping("/")
	public String apiRoot() {
		return "Hello World";
	}
}
