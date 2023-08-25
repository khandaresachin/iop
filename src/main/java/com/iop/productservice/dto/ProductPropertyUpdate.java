package com.iop.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class ProductPropertyUpdate {

    private float height;
    private float weight;
    private float width;
    private String messageOnProduct;
    private boolean specialHandleRequired;
    private boolean isEnabled;

}
