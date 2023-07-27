package com.iop.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPropertyRepository extends JpaRepository<ProductRepository, Long> {
}
