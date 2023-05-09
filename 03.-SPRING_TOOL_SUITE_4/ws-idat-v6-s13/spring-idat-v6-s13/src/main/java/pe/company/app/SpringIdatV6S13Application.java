package pe.company.app;

import javax.persistence.Entity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"pe.company.controller","pe.company.service","pe.company.repository","pe.company.model"})
@PropertySource ("classpath:application.properties")
@EntityScan("pe.company.model")
@EnableJpaRepositories("pe.company.repository")

public class SpringIdatV6S13Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringIdatV6S13Application.class, args);
	}

}
