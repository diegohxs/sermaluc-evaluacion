package pe.sermaluc.register;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@SpringBootApplication(scanBasePackages = "pe.sermaluc")
@SpringBootConfiguration
@EntityScan(basePackages = {"pe.sermaluc.register.*"})
@EnableJpaRepositories(basePackages = {"pe.sermaluc.register"})
public class RegisterApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(RegisterApplicationMain.class, args);
    }
}