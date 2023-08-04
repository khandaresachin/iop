package com.iop.productservice.service;

import com.iop.productservice.dto.ComponentRequest;
import com.iop.productservice.entity.Component;
import com.iop.productservice.exception.ComponentNotFoundException;
import com.iop.productservice.repository.ComponentRepository;
import com.iop.productservice.util.AppConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ComponentService {
    Logger logger = LoggerFactory.getLogger(ComponentService.class);
    private ComponentRepository repository;

    @Autowired
    public ComponentService(ComponentRepository repository) {
        this.repository = repository;
    }

    public Component getComponent(Long componentId) {
        return repository.findById(componentId)
                .orElseThrow(() -> new ComponentNotFoundException(AppConstant.COMPONENT_NOT_FOUND));
    }

    public ResponseEntity<Component> createComponent(ComponentRequest request) {
        Component created = new Component();
        try {
            created.setComponentName(request.getComponentName());
            created.setComponentType(request.getComponentType());
            created.setEnabled(true);
            created.setCreateBy(AppConstant.USER_NAME_FOR_DB_AUDIT);
            created.setCreatedAt(LocalDateTime.now());
            repository.save(created);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteComponent(Long componentId) {
        logger.info("Delete component request for :  {}  ", componentId);
        getComponent(componentId);
        repository.deleteById(componentId);
        return new ResponseEntity<>(AppConstant.COMPONENT_DELETED_SUCCESSFULLY, HttpStatus.OK);
    }
}
