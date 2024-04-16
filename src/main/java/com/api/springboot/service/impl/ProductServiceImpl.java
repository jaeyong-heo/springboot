package com.api.springboot.service.impl;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.springboot.dao.ProductDAO;
import com.api.springboot.data.entity.Product;
import com.api.springboot.data.repository.ProductRepository;
import com.api.springboot.dto.ProductDTO;
import com.api.springboot.dto.ProductResponseDTO;
import com.api.springboot.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	private final ProductRepository productRepository;
	private final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	@Autowired
	public ProductServiceImpl(ProductRepository productRepository)
	{
		this.productRepository = productRepository;
	}
	
	@Override
	public ProductResponseDTO changeProductName(Long number, String name) throws Exception {
//		Product changedProduct = productDAO.updateProductName(number, name);
		Product foundProduct = productRepository.findById(number).get();
		foundProduct.setName(name);
		Product changedProduct = productRepository.save(foundProduct);
		
		ProductResponseDTO productResponseDTO = new ProductResponseDTO();
		productResponseDTO.setNumber(changedProduct.getNumber());
		productResponseDTO.setName(changedProduct.getName());
		productResponseDTO.setPrice(changedProduct.getPrice());
		productResponseDTO.setStock(changedProduct.getStock());
		
		return productResponseDTO;
	}
	
	@Override
	public void deleteProduct(Long number) throws Exception {
		productRepository.deleteById(number);
		
	}
	@Override
	public ProductResponseDTO getProduct(Long number) {
//		Product product = productDAO.selectProduct(number);
		logger.info("[getProduct] input number : {}", number);
		Product product = productRepository.findById(number).get();
		logger.info("[getProduct] product number : {}, name : {} ", product.getNumber(), product.getName());
		
		ProductResponseDTO productResponseDTO = new ProductResponseDTO();
		productResponseDTO.setNumber(product.getNumber());
		productResponseDTO.setName(product.getName());
		productResponseDTO.setPrice(product.getPrice());
		productResponseDTO.setStock(product.getStock());
		
		return productResponseDTO;
	}
	
	@Override
	public ProductResponseDTO saveProduct(ProductDTO productDTO) {
		logger.info("[saveProduct] productDTO : {}", productDTO.toString());
		Product product = new Product();
		product.setName(productDTO.getName());
		product.setPrice(productDTO.getPrice());
		product.setStock(productDTO.getStock());
		product.setCreatedAt(LocalDateTime.now());
		product.setUpdatedAt(LocalDateTime.now());
		
//		Product savedProduct = productDAO.insertProduct(product);
		Product savedProduct = productRepository.save(product);
		logger.info("[saveProduct] saveProduct : {}", savedProduct);
		
		ProductResponseDTO productResponseDTO = new ProductResponseDTO();
		productResponseDTO.setNumber(savedProduct.getNumber());
		productResponseDTO.setName(savedProduct.getName());
		productResponseDTO.setPrice(savedProduct.getPrice());
		productResponseDTO.setStock(savedProduct.getStock());
		
		
		return productResponseDTO;
	}
	
}
