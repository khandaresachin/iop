package com.iop.productservice.controller;

import com.iop.productservice.dto.ComponentRequest;
import com.iop.productservice.entity.Component;
import com.iop.productservice.service.ComponentService;
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

    private ComponentService service;

    @Autowired
    public ComponentController(ComponentService service) {
        this.service = service;
    }

    /**
     * This API is used to create a component
     *
     * @param request Component create request
     * @return the created component with HttpStatus
     */
    @PostMapping
    public ResponseEntity<Component> createComponent(
            @RequestBody ComponentRequest request
    ) {
        return service.createComponent(request);
    }

    /**
     * This API is used to get component using componentId
     *
     * @param componentId unique id for component
     * @return the component details with HttpStatus
     */
    @GetMapping("{componentId}")
    public ResponseEntity<Component> getComponent(
            @PathVariable Long componentId
    ) {
        Component component = service.getComponent(componentId);
        return new ResponseEntity<>(component, HttpStatus.OK);

    }

    /**
     * This API is used to delete component using componentId
     *
     * @param componentId unique id for component
     * @return message with HttpStatus
     */
    @DeleteMapping("{componentId}")
    public ResponseEntity<String> deleteComponent(
            @PathVariable Long componentId
    ) {
        return service.deleteComponent(componentId);

    }
}
