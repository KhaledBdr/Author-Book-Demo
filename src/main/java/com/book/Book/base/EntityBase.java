package com.book.Book.base;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDate;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public abstract class EntityBase <IDType>{
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private IDType id;
    @CreatedBy
    private String CreatedBy;
    @CreatedDate
    private LocalDate CreatedAt;
    @LastModifiedBy
    private String lastModifiedBy;
    @LastModifiedDate
    private LocalDate lastModifiedDate;


    public IDType getId() {
        return id;
    }

    public void setId(IDType id) {
        this.id = id;
    }
    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }

    public LocalDate getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        CreatedAt = createdAt;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public LocalDate getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDate lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
