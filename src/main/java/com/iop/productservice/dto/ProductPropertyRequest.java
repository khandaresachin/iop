package com.iop.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPropertyRequest {
    private long productId;
    private float width;
    private float height;
    private float weight;
    private String messageOnProduct;
    private boolean specialHandleRequire;

}
