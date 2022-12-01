package com.example.product.app.controllers.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductRestController {
    /// Inject dependency

    /// API
    @GetMapping("/products")
    public ResponseEntity<?> getProduct() {
        return null;
    }

    @PostMapping("/products")
    public ResponseEntity<?> postProduct() {
        return null;
    }

    @PutMapping("/products")
    public ResponseEntity<?> putProduct() {
        return null;
    }

    @DeleteMapping("/products")
    public ResponseEntity<?> deleteProduct() {
        return null;
    }

    @PostMapping("/products/csv")
    public ResponseEntity<?> importProducts() {
        return null;
    }
}
