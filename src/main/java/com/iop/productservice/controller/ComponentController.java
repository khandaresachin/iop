package com.iop.productservice.controller;

import com.iop.productservice.dto.ComponentRequest;
import com.iop.productservice.entity.Component;
import com.iop.productservice.service.ComponentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/components")
public class ComponentController {
    Logger logger = LoggerFactory.getLogger(ComponentController.class);

    private ComponentService service;

    @Autowired
    public ComponentController(ComponentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Component> createComponent(
            @RequestBody ComponentRequest request
    ) {
        return service.createComponent(request);
    }

    @GetMapping("{componentId}")
    public ResponseEntity<Component> getComponent(
            @PathVariable Long componentId
    ) {
        Component component = service.getComponent(componentId);
        return new ResponseEntity<>(component, HttpStatus.OK);

    }

    @DeleteMapping("{componentId}")
    public ResponseEntity<String> deleteComponent(
            @PathVariable Long componentId
    ) {
        logger.info("Delete product request for productId :{} ", componentId);
        return service.deleteComponent(componentId);

    }
}
