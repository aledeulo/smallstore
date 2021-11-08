package com.salesforce.smallstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "orders")
@Table(name = "orders")
@Setter
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order extends AuditModel {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "uuid", nullable = false, unique = true)
    String uuid;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    @JsonIgnore
    Account account;

    @Column(name = "status", nullable = false)
    OrderStatus status;

    @Column(name = "billing", precision = 18, scale = 6, nullable = false)
    BigDecimal billing;

    public Order() {
    }

    public Order(String uuid, Account account, OrderStatus status, BigDecimal billing) {
        this.uuid = uuid;
        this.account = account;
        this.status = status;
        this.billing = billing;
    }
}
