package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.ProductEntity;
import com.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;

	@PostMapping("/ra")
	public ProductEntity saveproducts(@RequestBody ProductEntity pro) {
		productService.saveProduct(pro);
		return productService.saveProduct(pro);

	}
	
	
	@DeleteMapping("/{id}")
	public void deleteproducts(@PathVariable("id")Integer id) {
		productService.deleteProduct(id);

	}
	@PutMapping("/{id}")
	public ProductEntity updateProduct(@PathVariable("id")Integer id, @RequestBody ProductEntity p){
		p.setId(id);
		
		ProductEntity updateProduct = productService.updateProduct(p);
		return updateProduct;
		
	}
	


}
