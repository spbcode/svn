package springmvcintegrationwebsockets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(value = "springmvcintegrationwebsockets.controller")
public class SpringMvcIntegrationWebsocketsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcIntegrationWebsocketsApplication.class, args);
	}

}
