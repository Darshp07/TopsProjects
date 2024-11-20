package com.Project.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

//	Optional<Product> updateproductbyid(Long product);

//	Optional<Product> updateproduct(Product product);

	Optional<Product> findByProductId(Long productId);

	void deleteByproductId(long productId);

	Product findByproductId(long productId);

}
