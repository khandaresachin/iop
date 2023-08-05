package com.iop.productservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.LoggerFactory;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.logging.Logger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {
    Logger logger = (Logger) LoggerFactory.getLogger(BaseEntity.class);
    @Column(name = "created_by")
    private String createBy;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "modified_by")
    private String modifiedBy;
    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;
}
