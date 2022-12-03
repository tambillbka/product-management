package com.example.product.app.services;

import com.example.product.app.entities.Product;
import com.example.product.app.payloads.requests.ProductRequest;
import com.example.product.app.payloads.response.ListProductResponse;

public interface ProductService {
    Product createProduct(ProductRequest req);

    void deleteProduct(Integer id);

    Product getById(Integer id);

    Product updateProduct(ProductRequest req);

    ListProductResponse listBy(int page, int size, String search);
}
