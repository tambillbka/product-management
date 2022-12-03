package com.example.product.app.entities;

import com.example.product.app.payloads.requests.ProductRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@Entity(name = "products")
@Table(name = "products")
@EntityListeners(AuditingEntityListener.class)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Tên sản phẩm
    @Column(name = "product_name")
    private String name;

    // Mô tả sản phẩm
    @Column(name = "description")
    private String description;

    // Giá sản phẩm
    @Column(name = "cost")
    private Float cost;

    // Số lượng sản phẩm
    @Column(name = "quantity")
    private Integer quantity;

    // Link avatar
    @Column(name = "image_url")
    private String imageUrl;

    // Ngày tạo sản phẩm
    @Column(name = "created_date")
    @CreatedDate
    private Date createdDate;

    // Ngày Update sản phẩm
    @Column(name = "updated_date")
    @LastModifiedDate
    private Date updatedDate;

    // Constructor create product from product request (Request from Client)
    public Product(ProductRequest req) {
        this.name = req.getProductName().trim();
        this.description = req.getProductDescription().trim();
        this.cost = req.getProductCost();
        this.quantity = req.getProductQuantity();
        this.imageUrl = req.getProductLink();
    }

    public Product(String name, String description, Float cost, Integer quantity, String imageUrl) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
    }
}
