package io.codeKonnects.productservice.query.api.projection;

import io.codeKonnects.productservice.command.api.data.Product;
import io.codeKonnects.productservice.command.api.model.ProductRestModel;
import io.codeKonnects.productservice.command.api.repository.ProductRepository;
import io.codeKonnects.productservice.query.api.queries.FIndProductQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductProjection {
    private ProductRepository productRepository;

    public ProductProjection(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @QueryHandler
    public List<ProductRestModel> handler(FIndProductQuery fIndProductQuery){
        List<Product> products = productRepository.findAll();
        List<ProductRestModel> productRestModels = products.stream().map(product -> ProductRestModel
                .builder()
                .quantity(product.getQuantity())
                .price(product.getPrice())
                .name(product.getName())
                .build()).toList();
        return productRestModels;
    }
}
