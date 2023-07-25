package com.iop.productservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "product_feature")
@NoArgsConstructor
@AllArgsConstructor
public class ProductFeature {

    @Column(name = "productFeatureId")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productFeatureId;

    @JoinColumn(name = "product_id", table = "product")
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "color")
    private String color;

    @Column(name = "size")
    private String size;

    @Column(name = "isEnabled")
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
