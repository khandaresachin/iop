package com.iop.productservice.controller;

import com.iop.productservice.dto.ComponentRequest;
import com.iop.productservice.entity.Component;
import com.iop.productservice.service.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/components")
public class ComponentController {

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
        return service.deleteComponent(componentId);

    }
}
