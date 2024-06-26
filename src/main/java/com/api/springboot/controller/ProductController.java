package com.api.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.springboot.dto.ChangeProductDTO;
import com.api.springboot.dto.ProductDTO;
import com.api.springboot.dto.ProductResponseDTO;
import com.api.springboot.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	private final ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService)
	{
		this.productService = productService;
	}
	
	@GetMapping
	public ResponseEntity<ProductResponseDTO> getProduct(Long number)
	{
		ProductResponseDTO productResponseDTO = productService.getProduct(number);
		
		return ResponseEntity.status(HttpStatus.OK).body(productResponseDTO);
	}
	
	@PostMapping
	public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductDTO productDTO)
	{
		ProductResponseDTO productResponseDTO = productService.saveProduct(productDTO);
		
		return ResponseEntity.status(HttpStatus.OK).body(productResponseDTO);
	}
	
	@PutMapping
	public ResponseEntity<ProductResponseDTO> changeProductName(
			@RequestBody ChangeProductDTO changeProductDTO) throws Exception {
		
		ProductResponseDTO productResponseDTO = productService.changeProductName(changeProductDTO.getNumber(), changeProductDTO.getName());
		
		return ResponseEntity.status(HttpStatus.OK).body(productResponseDTO);
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteProduct(Long number) throws Exception 
	{
		productService.deleteProduct(number);
		
		return ResponseEntity.status(HttpStatus.OK).body("삭제 완료");
	}
}
