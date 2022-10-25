package io.codeKonnects.productservice.query.api.controller;

import io.codeKonnects.productservice.command.api.model.ProductRestModel;
import io.codeKonnects.productservice.query.api.queries.FIndProductQuery;
import org.axonframework.messaging.responsetypes.ResponseType;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductQueryController {
    private QueryGateway queryGateway;

    public ProductQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping
    public List<ProductRestModel> getAllProducts(){
        FIndProductQuery fIndProductQuery = new FIndProductQuery();
        List<ProductRestModel> productRestModels = queryGateway.query(fIndProductQuery, ResponseTypes.multipleInstancesOf(ProductRestModel.class)).join();
        return productRestModels;
    }

}
