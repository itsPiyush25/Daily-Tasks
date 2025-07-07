package com.example.Practice.seventhJuly.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
public class BaseEntity {

    @OneToOne
    @JoinColumn(name = "created_by_id")
    private Users createdBy;

    @OneToOne
    @JoinColumn(name = "modified_by_id")
    private Users modifiedBy;

    private LocalDateTime createdOn;

    @LastModifiedDate
    private LocalDateTime modifiedOn;

    public void setModifiedBy(Users modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public void setCreatedBy(Users createdBy) {
        this.createdBy = createdBy;
    }

    @PrePersist
    protected void onCreate() {
        this.createdOn = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.modifiedOn = LocalDateTime.now();
    }
}


