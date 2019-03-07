package io.github.tintinrevient.productservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import io.github.tintinrevient.productservice.model.Product;
import java.util.List;

public interface ProductRepository  extends JpaRepository<Product, Integer> {
    public List<Product> findAll();
    public List<Product> findById(int id);
}
