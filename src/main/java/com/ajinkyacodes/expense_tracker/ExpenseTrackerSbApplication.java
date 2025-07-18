package com.ajinkyacodes.expense_tracker;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "Expense Tracker REST API Documentation",
				description = "Expense Tracker REST API Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Ajinkya",
						email = "info.ajinkyacodes@gmail.com",
						url = "https://ajinkyacodes.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.ajinkyacodes.com/license"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Expense Tracker REST API Documentation for Developers",
				url = "https://www.ajinkyacodes.com/external-doc"
		)
)
@SpringBootApplication
public class ExpenseTrackerSbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerSbApplication.class, args);
	}

}
