package io.codeKonnects.productservice;

import io.codeKonnects.productservice.command.api.exception.ProductServiceExceptionHandler;
import org.axonframework.config.EventProcessingConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
	@Autowired
	public void configure(EventProcessingConfigurer configurer) {
		configurer.registerListenerInvocationErrorHandler("productGroup", conf -> new ProductServiceExceptionHandler());
	}

}
