package com.curiouscoder.product_service.base_entity.repository;

import com.curiouscoder.product_service.base_entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product , String> {

}
