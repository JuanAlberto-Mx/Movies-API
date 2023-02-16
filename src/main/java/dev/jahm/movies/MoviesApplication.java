package dev.jahm.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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

	/**
	 * Method to allows enabling the CORS origin requests.
	 * Alternatively, this feature can be established at a method-level by using
	 * the annotation <code>@CrossOrigin(origins = "http://localhost:8080")</code>
	 * @return the WebMvcConfigurer instance.
	 */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("*")
						.allowedMethods("*")
						.allowedHeaders("*")
						.allowCredentials(false).maxAge(3600);
			}
		};
	}
}