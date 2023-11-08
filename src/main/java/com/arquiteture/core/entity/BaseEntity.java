package com.arquiteture.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
abstract public class BaseEntity {

    private boolean active;

    @Column(name = "createAt", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime createAt;

    @Column(name = "updateAt", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime updateAt;

    @PrePersist
    public void prePersit(){
        if(this.getId() == null || this.getId().isBlank()){
            this.setId(UUID.randomUUID().toString());
            this.active = Boolean.TRUE;
            this.createAt = LocalDateTime.now();
        }

        this.updateAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        this.updateAt = LocalDateTime.now();
    }

    public abstract String getId();

    public abstract void setId(String id);

}
