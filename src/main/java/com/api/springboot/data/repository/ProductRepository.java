package com.api.springboot.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.springboot.data.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
