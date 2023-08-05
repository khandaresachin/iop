package com.iop.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.logging.Logger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class ProductRequest {
    Logger logger = (Logger) LoggerFactory.getLogger(ProductRequest.class);
    @NotNull(message = "productName should not be null")
    @Valid
    private String productName;

    private String productDescription;

    @NotNull(message = "productUrl should not be null")
    private String productUrl;

    private String productType;

    private String productSubType;
}