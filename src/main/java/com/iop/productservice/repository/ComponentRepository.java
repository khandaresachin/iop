package com.iop.productservice.repository;

import com.iop.productservice.entity.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponentRepository extends JpaRepository<Component, Long> {
    Logger logger= LoggerFactory.getLogger(ComponentRepository.class);

}
