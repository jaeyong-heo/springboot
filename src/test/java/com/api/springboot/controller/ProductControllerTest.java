package com.api.springboot.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.api.springboot.dto.ProductDTO;
import com.api.springboot.dto.ProductResponseDTO;
import com.api.springboot.service.impl.ProductServiceImpl;
import com.google.gson.Gson;

import jdk.net.SocketFlow.Status;
import net.bytebuddy.NamingStrategy.SuffixingRandom.BaseNameResolver.ForGivenType;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

	@Autowired
	private MockMvc mockmvc;
	
	@MockBean
	ProductServiceImpl productServiceImpl;
	
	@Test
	@DisplayName("MockMVC를 통한 Product 데이터 가져오기 테스트")
	void getProductTest() throws Exception{
		
		given(productServiceImpl.getProduct(123L)).willReturn(
				new ProductResponseDTO(123L, "pen", 5000, 2000));
		
		String productId = "123";
		
		mockmvc.perform(
				get("/product?number="+productId))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.number").exists())
				.andExpect(jsonPath("$.name").exists())
				.andExpect(jsonPath("$.price").exists())
				.andExpect(jsonPath("$.stock").exists())
				.andDo(print());
		
		verify(productServiceImpl).getProduct(123L);
	}
	
	@Test
	@DisplayName("Product 데이터 생성 테스트")
	void createProductTest() throws Exception
	{
		given(productServiceImpl.saveProduct(new ProductDTO("pen", 5000, 2000)))
		.willReturn(new ProductResponseDTO(12315L, "pen", 5000, 2000));
		
		ProductDTO productDTO = ProductDTO.builder()
				.name("pen")
				.price(5000)
				.stock(2000)
				.build();
		
		Gson gson = new Gson();
		String content = gson.toJson(productDTO);
		
		mockmvc.perform(
				post("/product")
				.content(content)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.number").exists())
		.andExpect(jsonPath("$.name").exists())
		.andExpect(jsonPath("$.price").exists())
		.andExpect(jsonPath("$.stock").exists())
		.andDo(print());
		
		verify(productServiceImpl).saveProduct(new ProductDTO("pen", 5000, 2000));
	}
}
