package io.codeKonnects.productservice.command.api.events;

import io.codeKonnects.productservice.command.api.data.Product;
import io.codeKonnects.productservice.command.api.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
@Slf4j
@ProcessingGroup("productGroup")
public class ProductEventsHandler {

    private ProductRepository productRepository;

    public ProductEventsHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @EventHandler
    public void on(ProductCreatedEvent event) {
        Product product = new Product();
        BeanUtils.copyProperties(event, product);
        productRepository.save(product);
        log.info("Product created event received: " + event);
    }
    @ExceptionHandler
    public void handle(Exception exception){
        log.error("Exception occurred while handling event: " + exception.getMessage());
    }
}
