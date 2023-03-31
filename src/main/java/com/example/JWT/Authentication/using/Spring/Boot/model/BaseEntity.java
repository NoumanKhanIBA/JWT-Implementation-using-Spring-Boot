package com.example.JWT.Authentication.using.Spring.Boot.model;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "created_at", nullable = false,updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;
    @Column(name = "created_by")
    @CreatedBy
    private Long createdBy;
    @Column(name = "modified_by")
    @LastModifiedBy
    private Long modifiedBy;

    public Long getId() {
        return id;
    }

    public BaseEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public BaseEntity setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public BaseEntity setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public BaseEntity setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public Long getModifiedBy() {
        return modifiedBy;
    }

    public BaseEntity setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }
}
