package com.salesforce.smallstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Entity(name = "product")
@Table(name = "product")
@Data
@Value
@Builder
@JsonIgnoreProperties(ignoreUnknown = true, allowGetters = true, allowSetters = true)
public class Product extends AbstractModel {
    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "images")
    List<ProductImage> images;

    @Column(name = "color", nullable = false)
    ProductColors color;

    @Column(name = "categories", nullable = false)
    List<Categories> categories;

    @Column(name = "description")
    String description;

    @Column(name = "unit_price", nullable = false)
    BigDecimal unitPrice;

    @Column(name = "order_product", nullable = false)
    OrderProducts orderProduct;
}
