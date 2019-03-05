package io.github.tintinrevient.productservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.repository.query.Param;
import io.github.tintinrevient.productservice.model.Product;

@RepositoryRestResource(collectionResourceRel = "product", path = "product")
public interface ProductRepository  extends JpaRepository<Product, Long> {
}
