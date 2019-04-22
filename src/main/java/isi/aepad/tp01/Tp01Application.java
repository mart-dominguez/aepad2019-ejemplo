package isi.aepad.tp01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("isi.aepad.tp01.repository")
public class Tp01Application {

	public static void main(String[] args) {
		SpringApplication.run(Tp01Application.class, args);
	}

}
