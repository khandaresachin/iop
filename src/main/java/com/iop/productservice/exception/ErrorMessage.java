package com.iop.productservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.logging.Logger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {
    Logger logger = (Logger) LoggerFactory.getLogger(ErrorMessage.class);

    private int statusCode;
    private LocalDateTime timestamp;
    private String message;
    private String path;
}
