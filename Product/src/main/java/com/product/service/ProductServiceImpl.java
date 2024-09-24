package com.product.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.ProductEntity;
import com.product.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService{

	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductEntity saveProduct(ProductEntity product) {
		ProductEntity save = productRepository.save(product);
		return save;
	}

	@Override
	public String deleteProduct(int id) {
		productRepository.deleteById(id);
		return "Delete Successfully !...";
	}

	@Override
	public ProductEntity updateProduct(ProductEntity pe) {
		ProductEntity p = productRepository.findById(pe.getId()).get();
		p.setName(pe.getName());
		p.setCompanyName(pe.getCompanyName());
		p.setRate(pe.getRate());
		ProductEntity save = productRepository.save(p);
		
		
		return save;
	}


	
}
