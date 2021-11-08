package com.salesforce.smallstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "product")
@Table(name = "product")
@Data
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true, allowGetters = true, allowSetters = true)
public class Product extends AuditModel {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "uuid", nullable = false, unique = true)
    String uuid;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "color", nullable = false)
    ProductColors color;

    @ManyToMany
    @JoinTable(name = "product_category",
            joinColumns = @JoinColumn(name = "product_uuid"),
            inverseJoinColumns = @JoinColumn(name = "category_uuid"))
    Set<Category> categories;

    @Column(name = "description")
    String description;

    @Column(name = "unit_price", nullable = false, precision = 18, scale = 6)
    BigDecimal unitPrice;

    @OneToOne(mappedBy = "product")
    OrderProduct orderProduct;
}
