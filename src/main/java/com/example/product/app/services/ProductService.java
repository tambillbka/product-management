package com.example.product.app.services;

import com.example.product.app.entities.Product;
import com.example.product.app.payloads.requests.CreateProductReq;

public interface ProductService {
    Product createProduct(CreateProductReq req);

    void deleteProduct(Integer id);

    Product getById(Integer id);
}
