package com.iop.productservice.repository;

import com.iop.productservice.entity.ProductFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductFeatureRepository extends JpaRepository<ProductFeature, Integer> {
}
