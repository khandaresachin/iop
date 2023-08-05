package com.iop.productservice.dto;

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
public class ComponentRequest {
    Logger logger = (Logger) LoggerFactory.getLogger(ComponentRequest.class);

    private String componentName;

    private String componentType;
}
