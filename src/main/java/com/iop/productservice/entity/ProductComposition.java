package com.iop.productservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.LoggerFactory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.logging.Logger;

@Data
@Entity
@Table(name = "product_composition")
@NoArgsConstructor
@AllArgsConstructor
public class ProductComposition implements Serializable {
    Logger logger = (Logger) LoggerFactory.getLogger(ProductComposition.class);
    @Column(name = "composition_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long compositionId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToOne
    @JoinColumn(name = "component_id")
    private Component component;

    @Column(name = "quantity")
    private Integer quantity;

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
