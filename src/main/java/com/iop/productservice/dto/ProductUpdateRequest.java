package com.iop.productservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

import java.util.logging.Logger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class ProductUpdateRequest {
    Logger logger= (Logger) LoggerFactory.getLogger("ProductUpdateRequest");
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
