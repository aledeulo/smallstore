package com.salesforce.smallstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "order_products")
@Table(name = "order_products")
@Setter
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderProduct extends AuditModel {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "uuid", nullable = false, unique = true)
    String uuid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    @JsonIgnore
    Order order;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "uuid")
    Product product;

    @Column(name = "quantity", nullable = false)
    int quantity;

    @Column(name = "amount", nullable = false)
    BigDecimal amount;
}
