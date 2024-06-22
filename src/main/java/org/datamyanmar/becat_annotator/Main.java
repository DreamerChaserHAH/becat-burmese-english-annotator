package org.datamyanmar.becat_annotator;
import org.datamyanmar.becat_annotator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableJpaRepositories("org.datamyanmar.becat_annotator.repository")
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

}

@RestController
class BaseController{
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/ping")
	public String ping(){
		return "Hello World";
	}
}