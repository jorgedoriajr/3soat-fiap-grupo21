package br.com.postechfiap.jlapp.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenAPIConfig {

	@Value("${jlapp.openapi.dev-url}")
	private String devUrl;

	@Value("${jlapp.openapi.prod-url}")
	private String prodUrl;

	@Value("${jlapp.openapi.hom-url}")
	private String homUrl;

	@Bean
	public OpenAPI myOpenAPI() {
		Server devServer = new Server();
		devServer.setUrl(devUrl);
		devServer.setDescription("Server URL in Development environment");

		Server homServer = new Server();
		homServer.setUrl(homUrl);
		homServer.setDescription("Server URL in Homologation environment");

		Server prodServer = new Server();
		prodServer.setUrl(prodUrl);
		prodServer.setDescription("Server URL in Production environment");

		Contact contact = new Contact();
		contact.setEmail("jlaap@gmail.com");
		contact.setName("JeffLuis");
		contact.setUrl("https://www.localhost.com");

		License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

		Info info = new Info().title("Tutorial Management API").version("1.0").contact(contact)
				.description("This API exposes endpoints to manage tutorials.")
				.termsOfService("https://www.localhost.com/terms").license(mitLicense);

		return new OpenAPI().info(info).servers(List.of(devServer, homServer, prodServer));
	}
}