package com.salesforce.smallstore.repository;

import com.salesforce.smallstore.model.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, String> {
}
