package io.codeKonnects.productservice.command.api.repository;

import io.codeKonnects.productservice.command.api.data.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {


}
