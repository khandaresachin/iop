package com.iop.productservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompositionRequest {
    Logger logger = (Logger) LoggerFactory.getLogger(CompositionRequest.class);

    private Long productId;

    private Long componentId;

    private Integer quantity;

    private Boolean isEnabled;
}
