package com.salesforce.smallstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "order")
@Table(name = "order")
@Value
@Data
@Builder
public class Order extends AbstractModel {
    @ManyToOne
    @JoinColumn(name = "account_id")
    Account accountId;

    @Column(name = "status", nullable = false)
    OrderStatus status;

    @Column(name = "billing", nullable = false)
    BigDecimal billing;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @OneToMany(mappedBy = "orderId", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    List<OrderProducts> orderProducts;
}
