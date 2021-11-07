package com.salesforce.smallstore.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.persistence.*;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "order_products")
@Table(name = "order_products")
@Value
@Data
@Builder
public class OrderProducts extends AbstractModel {
    @ManyToOne
    @JoinColumn(name = "order_id")
    Order orderId;

    @Column(name = "product", nullable = false)
    Product product;

    @Column(name = "quantity", nullable = false)
    int quantity;

    @Column(name = "amount", nullable = false)
    BigDecimal amount;
}
