package com.iop.productservice.repository;

import com.iop.productservice.entity.ProductProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPropertyRepository extends JpaRepository<ProductProperty, Long> {
}
