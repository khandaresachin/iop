package com.iop.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    @NotNull(message = "productName should not be null")
    @Valid
    private String productName;

    private String productDescription;

    @NotNull(message = "productUrl should not be null")
    private String productUrl;

    private String productType;

    private String productSubType;
}