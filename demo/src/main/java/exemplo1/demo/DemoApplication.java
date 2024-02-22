package exemplo1.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableWebSecurity
@EntityScan(basePackages = "exemplo1/demo/model")
@ComponentScan(basePackages = {"exemplo1.demo.*"})
@EnableJpaRepositories(basePackages = {"exemplo1.demo.*"})
@EnableTransactionManagement
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		BCryptPasswordEncoder script = new BCryptPasswordEncoder();
		String senha = script.encode("123");
		System.out.println(senha);
	}
}
