package com.salesforce.smallstore.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Value
@Data
@Entity(name = "product_image")
@Table(name = "product_image")
@Builder
public class ProductImage extends AbstractModel {
    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "image_bytes", length = 1000, nullable = false)
    byte[] imageBytes;

    @Column(name = "product", nullable = false)
    Product product;
}
