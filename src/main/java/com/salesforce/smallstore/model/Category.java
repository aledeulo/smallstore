package com.salesforce.smallstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Setter
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true, allowGetters = true, allowSetters = true)
@Entity(name = "categories")
@Table(name = "categories")
public class Category extends AuditModel {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "uuid", nullable = false, unique = true)
    String uuid;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "description")
    String description;

    @ManyToMany(mappedBy = "categories")
    Set<Product> products;
}
