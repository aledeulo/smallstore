package com.salesforce.smallstore.repository;

import com.salesforce.smallstore.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

    Order findByAccountUuid(String accountUuid);

    Optional<Order> findByUuidAndAccountUuid(String uuid, String accountUuid);

    List<Order> getAllByAccountUuid(String accountUuid);
}
