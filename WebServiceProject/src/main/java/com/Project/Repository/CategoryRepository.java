package com.Project.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.Project.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	Category findByCategoryName(String categoryName);

	Optional<Category> findByCategoryId(Long categoryId);

	void deleteByCategoryId(Long categoryId);

	Optional<Category> findBycategoryId(Long categoryId);

}
