package com.iop.productservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class ProductUpdateRequest {

    @JsonProperty("productName")
    private String productName;

    @JsonProperty("productDescription")
    private String productDescription;

    @JsonProperty("productUrl")
    private String productUrl;

    @JsonProperty("productType")
    private String productType;

    @JsonProperty("productSubType")
    private String productSubType;

    @JsonProperty("isDeleted")
    private boolean isDeleted;
}
