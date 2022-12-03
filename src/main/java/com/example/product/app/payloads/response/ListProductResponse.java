package com.example.product.app.payloads.response;

import com.example.product.app.entities.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ListProductResponse {
    private List<Product> products;
    private Integer total;
}
