package buildingmaintenance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan
@EnableWebMvc
@EnableAutoConfiguration
public class BuildingmaintenanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuildingmaintenanceApplication.class, args);
    }
}
