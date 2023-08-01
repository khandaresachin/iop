package com.iop.productservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompositionRequest {

    private Long productId;

    private Long componentId;

    private Integer quantity;

    private Boolean isEnabled;
}
