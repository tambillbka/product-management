package com.example.product.app.controllers.api;

import com.example.product.app.entities.Product;
import com.example.product.app.payloads.requests.ProductRequest;
import com.example.product.app.payloads.response.ListProductResponse;
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
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<ListProductResponse> getProducts(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "12") int size,
            @RequestParam(required = false, defaultValue = "") String search
    ) {
        ListProductResponse response = productService.listBy(page, size, search);
        return ResponseEntity.ok(response);
    }

    // Create new product
    @PostMapping("/products")
    public ResponseEntity<Product> postProduct(@RequestBody ProductRequest req) {
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
    public ResponseEntity<Product> putProduct(@RequestBody ProductRequest req) {
        Product product = productService.updateProduct(req);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok(null);
    }
}
