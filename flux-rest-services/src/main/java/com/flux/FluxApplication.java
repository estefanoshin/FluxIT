package main.java.com.flux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.candidato.dao.CandidatoDao;

@Configuration
@SpringBootApplication
@ComponentScan(basePackages = { "main.java.com.flux.candidatos.*" })
public class FluxApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(FluxApplication.class, args);
	}

	@Bean
	public CandidatoDao getCandidatoDao() {
		return new CandidatoDao();
	}

}
