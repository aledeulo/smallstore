package com.salesforce.smallstore.repository;

import com.salesforce.smallstore.model.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, String> {
}
