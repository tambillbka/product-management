package com.example.product.app.payloads.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

@NoArgsConstructor
@Getter
@Setter
public class CreateProductReq {
    @NonNull
    private String productName;

    @NonNull
    private String productDescription;

    @NonNull
    private Float productCost;

    @NonNull
    private Integer productQuantity;

    @NonNull
    private String productLink;
}
