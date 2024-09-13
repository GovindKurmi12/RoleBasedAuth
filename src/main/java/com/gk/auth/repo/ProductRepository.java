package com.gk.auth.repo;

import com.gk.auth.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * @author Govind Kurmi
 * Date : 12-09-2024
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.name = :name")
    Optional<Product> findByName(@Param("name") String name);
}
