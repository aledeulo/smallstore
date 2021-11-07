package com.salesforce.smallstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Value
@Data
@Entity(name = "account")
@Table(name = "account")
@Builder
@JsonIgnoreProperties(ignoreUnknown = true, allowGetters = true, allowSetters = true)
public class Account extends AbstractModel {
    @Column(name = "name", nullable = false)
    String name;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @OneToMany(mappedBy = "accountId", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    List<Order> orders;
}
