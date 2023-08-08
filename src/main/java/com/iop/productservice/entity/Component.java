package com.iop.productservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "component")
@NoArgsConstructor
@AllArgsConstructor
public class Component implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "component_id")
    private Long componentId;

    @Column(name = "component_name")
    private String componentName;

    @Column(name = "component_type")
    private String componentType;

    @Column(name = "is_enabled")
    private boolean isEnabled;

    @Column(name = "created_by")
    private String createBy;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "modified_by")
    private String modifiedBy;
    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

}
