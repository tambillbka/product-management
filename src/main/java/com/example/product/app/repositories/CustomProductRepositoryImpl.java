package com.example.product.app.repositories;

import com.example.product.app.entities.Product;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;

@Repository
@SuppressWarnings("unchecked")
public class CustomProductRepositoryImpl implements CustomProductRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Product> listProductBy(int page, int size, String search) {
        StringBuilder query = new StringBuilder("SELECT * FROM products AS p");
        if (StringUtils.hasText(search)) {
            query.append(" WHERE p.product_name LIKE '%").append(search).append("%'")
                    .append(" OR p.description LIKE '%").append(search).append("%'");
        }
        query.append(" ORDER BY p.updated_date DESC");

        Query productQuery = entityManager.createNativeQuery(query.toString(), Product.class);

        // Paging
        productQuery.setFirstResult(size * page);
        productQuery.setMaxResults(size);
        return productQuery.getResultList();
    }

    @Override
    public Integer totalProductBy(String search) {
        StringBuilder query = new StringBuilder("SELECT p.id FROM products AS p");
        if (StringUtils.hasText(search)) {
            query.append(" WHERE p.product_name LIKE '%").append(search).append("%'")
                    .append(" OR p.description LIKE '%").append(search).append("%'");
        }
        Query productQuery = entityManager.createNativeQuery(query.toString(), Product.class);
        return productQuery.getResultList().size();
    }
}
