package com.example.product.app.repositories;

import com.example.product.app.entities.Product;

import java.util.List;

public interface CustomProductRepository {
    List<Product> listProductBy(int page, int size, String search);

    Integer totalProductBy(String search);
}
