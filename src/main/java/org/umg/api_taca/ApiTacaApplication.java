package org.umg.api_taca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.umg.controladores")
@ComponentScan("org.umg.modelo")
public class ApiTacaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiTacaApplication.class, args);
	}

}
