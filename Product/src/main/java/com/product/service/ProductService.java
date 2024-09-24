package com.product.service;

import com.product.entity.ProductEntity;

public interface ProductService {

	public ProductEntity saveProduct(ProductEntity product);
	public String deleteProduct(int id);
	public ProductEntity updateProduct(ProductEntity p);

}
