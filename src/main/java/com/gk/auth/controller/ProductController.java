package com.gk.auth.controller;

import com.gk.auth.model.Product;
import com.gk.auth.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Govind Kurmi
 * Date : 12-09-2024
 */
@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;


    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return service.getProducts();
    }

    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return service.updateProduct(id, product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        service.deleteProduct(id);
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return service.getProductById(id);
    }

    @GetMapping("/byname/{name}")
    public Product getByName(@PathVariable String name) {
        return service.getByName(name);
    }


}
