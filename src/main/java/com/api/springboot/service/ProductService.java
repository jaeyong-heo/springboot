package com.api.springboot.service;

import com.api.springboot.dto.ProductDTO;
import com.api.springboot.dto.ProductResponseDTO;

public interface ProductService {

	ProductResponseDTO getProduct(Long number);
	
	ProductResponseDTO saveProduct(ProductDTO productDTO);
	
	ProductResponseDTO changeProductName(Long number, String name) throws Exception;
	
	void deleteProduct(Long number) throws Exception;
}
