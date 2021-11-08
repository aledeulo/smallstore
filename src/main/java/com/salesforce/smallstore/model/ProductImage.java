package com.salesforce.smallstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Setter
@Data
@Entity(name = "product_image")
@Table(name = "product_image")
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductImage extends AuditModel {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "uuid", nullable = false, unique = true)
    String uuid;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "image_bytes", length = 1000, nullable = false)
    byte[] imageBytes;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    @JsonIgnore
    Product product;
}
