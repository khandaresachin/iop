package com.iop.productservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.LoggerFactory;

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
import java.util.logging.Logger;

@Data
@Entity
@Table(name = "product_property")
@NoArgsConstructor
@AllArgsConstructor
public class ProductProperty {
    Logger logger = (Logger) LoggerFactory.getLogger(ProductProperty.class);

    @Column(name = "property_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long propertyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "height")
    private float height;

    @Column(name = "weight")
    private float weight;

    @Column(name = "width")
    private float width;

    @Column(name = "messageOnProduct")
    private String messageOnProduct;

    @Column(name = "specialHandleRequired")
    private boolean specialHandleRequired;

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
