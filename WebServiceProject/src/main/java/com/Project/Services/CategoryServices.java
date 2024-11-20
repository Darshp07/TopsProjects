package com.Project.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.Project.Dio.Pagenation;
import com.Project.Repository.CategoryRepository;
import com.Project.model.Category;

import jakarta.validation.Valid;

@Service
public class CategoryServices {

	@Autowired
	private CategoryRepository categoryrepository;

	public Category createcategory(@Valid Category category) {

		return categoryrepository.save(category);
	}

	public Pagenation<Category> getallCategory(int page, int size) {
		PageRequest pageRequest = PageRequest.of(page - 1, size);
		Page<Category> page2 = categoryrepository.findAll(pageRequest);
		List<Category> categories = page2.getContent();

		Pagenation<Category> pagenation = new Pagenation<Category>(page2.getNumber() + 1, page2.getTotalPages(),
				page2.getTotalElements(), page2.getSize(), categories);
		return pagenation;
	}

	public Category findByname(String categoryName) {

		return categoryrepository.findByCategoryName(categoryName);
	}

	public Category CategoryUpdate(Category category) {
		Optional<Category> optional = categoryrepository.findByCategoryId(category.getCategoryId());

		Category category2 = optional.get();
		category2.setCategoryName(category.getCategoryName());
		category2.setDescription(category.getDescription());
		return category2;
	}

	public void DeleteCategory(Long categoryId) {
		categoryrepository.deleteByCategoryId(categoryId);
	}

}
