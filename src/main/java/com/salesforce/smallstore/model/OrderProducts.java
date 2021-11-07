package com.salesforce.smallstore.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "order_products")
@Table(name = "order_products")
@Value
@Data
@Builder
public class OrderProducts extends AbstractModel {
    @Column(name = "order", nullable = false)
    Order order;

    @Column(name = "product", nullable = false)
    Product product;

    @Column(name = "quantity", nullable = false)
    int quantity;

    @Column(name = "amount", nullable = false)
    BigDecimal amount;
}
