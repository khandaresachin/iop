package com.iop.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMessage {
    Logger logger = (Logger) LoggerFactory.getLogger(ResponseMessage.class);

    private String message;
}
