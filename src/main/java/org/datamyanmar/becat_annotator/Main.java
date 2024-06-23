package org.datamyanmar.becat_annotator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.security.oauth2.server.resource.web.DefaultBearerTokenResolver;
import org.springframework.security.oauth2.server.resource.web.BearerTokenResolver;
import org.springframework.security.oauth2.server.resource.web.DefaultBearerTokenResolver;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "http://localhost:*")
@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
@EnableJpaRepositories("org.datamyanmar.becat_annotator.repository")
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

}

@RestController
class BaseController{
	@Autowired
	private HttpServletRequest request;

	@GetMapping("/ping")
	public String ping(){
		return "Hello World";
	}

	@GetMapping("/bearerToken")
	public String bearerToken(){
		DefaultBearerTokenResolver resolver = new DefaultBearerTokenResolver();
		resolver.setAllowFormEncodedBodyParameter(true);
		String token = resolver.resolve(request);
		return "Your token: " + token;
	}
}