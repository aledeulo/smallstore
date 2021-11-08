package com.salesforce.smallstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"createdAt", "updatedAt"},
        allowGetters = true,
        allowSetters = true
)
@Data
public class AuditModel {

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    protected Timestamp createdAt;

    @Column(name = "updated_at", nullable = false)
    @LastModifiedDate
    protected Timestamp updatedAt;

    @PrePersist
    public void createdAt() {
        this.createdAt = this.updatedAt = Timestamp.from(Instant.now());
    }

    @PreUpdate
    public void updatedAt() {
        this.updatedAt = Timestamp.from(Instant.now());
    }
}
