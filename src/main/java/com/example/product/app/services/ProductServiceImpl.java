package com.example.product.app.services;

import com.example.product.app.entities.Product;
import com.example.product.app.payloads.requests.CreateProductReq;
import com.example.product.app.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class ProductServiceImpl implements ProductService {
    /// Inject dependency
    @Autowired
    ProductRepository productRepository;

    /// Các service tương ứng với các API
    @Override
    public Product createProduct(CreateProductReq createProductReq) {
        // Check request from Client NULL
        if (createProductReq == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        }

        // Tạo một sản phẩm từ Ajax client request
        Product product = new Product(createProductReq);
        return productRepository.save(product);
    }
}
