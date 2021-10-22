package br.com.emanuelgabriel.beta.processos.api.config;

import org.springdoc.webmvc.ui.SwaggerConfig;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;


@OpenAPIDefinition(
		info = @Info(description = "Documentação do Beta Processos API", 
		termsOfService = "Termos de uso", 
		title = "API Beta Processos Ltda", 
		version = "1.0.0", 
		contact = @Contact(name = "Emanuel Gabriel Sousa", 
		email = "emanuel.gabriel.sousa@hotmail.com")))
public class DocumentationConfig extends SwaggerConfig {

}
