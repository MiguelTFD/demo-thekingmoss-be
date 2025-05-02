package com.thekingmoss.repository;

import com.thekingmoss.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory_Name(String categoryName);

}
