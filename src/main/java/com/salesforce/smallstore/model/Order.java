package com.salesforce.smallstore.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "order")
@Table(name = "order")
@Value
@Data
@Builder
public class Order extends AbstractModel {
    @Column(name = "account", nullable = false)
    Account account;

    @Column(name = "status", nullable = false)
    OrderStatus status;

    @Column(name = "billing", nullable = false)
    BigDecimal billing;

    @Column(name = "order_products", nullable = false)
    List<OrderProducts> orderProducts;
}
