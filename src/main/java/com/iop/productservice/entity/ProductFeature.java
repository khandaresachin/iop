package com.iop.productservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    private Long productFeatureId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

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
