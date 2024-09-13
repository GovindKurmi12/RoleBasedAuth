package com.gk.auth.service;

import com.gk.auth.model.Product;
import com.gk.auth.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Govind Kurmi
 * Date : 12-09-2024
 */
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product updateProduct(Long id, Product product) {
        Product existingProduct = productRepository.findById(id).orElseThrow();
        existingProduct.setName(product.getName());
        existingProduct.setQty(product.getQty());
        existingProduct.setPrice(product.getPrice());
        return productRepository.save(existingProduct);
    }


    public Product getByName(String name) {
        return productRepository.findByName(name).orElse(null);
    }

}
