package com.salesforce.smallstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Setter
@Data
@Entity(name = "account")
@Table(name = "account")
@Builder
@JsonIgnoreProperties(ignoreUnknown = true, allowGetters = true, allowSetters = true)
public class Account extends AuditModel {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "uuid", nullable = false, unique = true)
    String uuid;

    @Column(name = "name", nullable = false)
    String name;

    public Account() {
    }

    public Account(String uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }
}
