package com.example.product.app.controllers.api;

import com.example.product.app.entities.Product;
import com.example.product.app.payloads.requests.CreateProductReq;
import com.example.product.app.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductRestController {
    /// Inject dependency
    @Autowired
    ProductService productService;

    /// API

    // Find and search
    @GetMapping("/products")
    public ResponseEntity<?> getProducts() {
        return null;
    }

    // Create new product
    @PostMapping("/products")
    public ResponseEntity<Product> postProduct(@RequestBody CreateProductReq req) {
        Product product = productService.createProduct(req);
        return ResponseEntity.ok(product);
    }

    // Get detail product information by Id
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer id) {
        Product product = productService.getById(id);
        return ResponseEntity.ok(product);
    }

    // Update Product Information
    @PutMapping("/products")
    public ResponseEntity<?> putProduct() {
        return null;
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/products/csv")
    public ResponseEntity<?> importProducts() {
        return null;
    }
}
