package com.example.product.app.services;

import com.example.product.app.common.utils.InitData;
import com.example.product.app.entities.Product;
import com.example.product.app.payloads.requests.ProductRequest;
import com.example.product.app.payloads.response.ListProductResponse;
import com.example.product.app.repositories.CustomProductRepository;
import com.example.product.app.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    /// Inject dependency
    @Autowired
    ProductRepository productRepository;

    @Autowired
    CustomProductRepository productRepositoryCustom;

    @PostConstruct
    @Transactional
    void initProduct() {
        long totalDbProduct = productRepository.count();
        if (totalDbProduct > 0) {
            // Đã có sản phẩm trong DB
            return;
        }

        // hông có sản phẩm trong DB -> Khởi tạo sản phẩm cho DB
        productRepository.saveAll(InitData.products);
    }

    /// Các service tương ứng với các API
    @Override
    @Transactional
    public Product createProduct(ProductRequest createProductReq) {
        // Check request from Client NULL
        if (createProductReq == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        }

        // Tạo một sản phẩm từ Ajax client request
        Product product = new Product(createProductReq);
        return productRepository.save(product);
    }

    @Override
    @Transactional
    public void deleteProduct(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        }
        productRepository.deleteById(id);
    }

    @Override
    public Product getById(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        }
        return optionalProduct.get();
    }

    @Override
    @Transactional
    public Product updateProduct(ProductRequest req) {
        // Check request from Client NULL
        if (req == null || req.getProductId() == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        }
        Optional<Product> optionalProduct = productRepository.findById(req.getProductId());
        if (optionalProduct.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        }
        Product product = optionalProduct.get();
        product.setName(req.getProductName().trim());
        product.setDescription(req.getProductDescription().trim());
        product.setImageUrl(req.getProductLink());
        product.setQuantity(req.getProductQuantity());
        product.setCost(req.getProductCost());
        return productRepository.save(product);
    }

    @Override
    public ListProductResponse listBy(int page, int size, String search) {
        ListProductResponse response = new ListProductResponse();
        List<Product> products = productRepositoryCustom.listProductBy(page, size, search);
        Integer total = productRepositoryCustom.totalProductBy(search);
        response.setProducts(products);
        response.setTotal(total);
        return response;
    }
}
