package com.Project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Project.Dio.Apiserviece;
import com.Project.Dio.Pagenation;
import com.Project.Services.CategoryServices;
import com.Project.model.Category;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Api/Webservice/category")
public class CategoryController {
	
	@Autowired
	private CategoryServices categoryservices;

	// Category added API
	@PostMapping("/create")
	public ResponseEntity<Apiserviece<Category>> createCategory(@Valid @RequestBody Category category) {
		Category existcategory = categoryservices.findByname(category.getCategoryName());
		

		if (existcategory != null && existcategory.getCategoryName().equals(category.getCategoryName())) {
			Apiserviece<Category> apiserviece = new Apiserviece<Category>(false, "Category is alredey exist..!!", null);
			return new ResponseEntity<>(apiserviece, HttpStatus.OK);
		}

		Category category2 = categoryservices.createcategory(category);
		System.out.println(category2);
		Apiserviece<Category> apiserviece = new Apiserviece<Category>(true, "Category is create succesfully ..!",
				category2);
		System.out.println(category2);
		return new ResponseEntity<>(apiserviece, HttpStatus.OK);
	}

	// Get all category API
	@GetMapping("/getallcategory")
	public ResponseEntity<Apiserviece<Pagenation<Category>>> GetallCategory(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int size) {
		Pagenation<Category> pagenation = categoryservices.getallCategory(page, size);
		Apiserviece<Pagenation<Category>> apiserviece = new Apiserviece<Pagenation<Category>>(true,
				"get all Category succesfully ", pagenation);
		return new ResponseEntity<>(apiserviece, HttpStatus.OK);
	}

	// update category AIP
	@PutMapping("/Update")
	public ResponseEntity<Apiserviece<Category>> UpdateCategory(@RequestParam Category category) {

		Category category2 = categoryservices.CategoryUpdate(category);

		Apiserviece<Category> apiserviece = new Apiserviece<Category>(true, "category update succesfully..!",
				category2);
		return new ResponseEntity<>(apiserviece, HttpStatus.OK);
	}

    // Delete category AIP  
	@DeleteMapping("/delete/{categoryId}")
	public ResponseEntity<Apiserviece<Void>> DeleteCategory(@PathVariable Long categoryId) {
		categoryservices.DeleteCategory(categoryId);

		Apiserviece<Void> apiserviece = new Apiserviece<Void>(true, "Category delete succesfully", null);
		return new ResponseEntity<>(apiserviece, HttpStatus.NO_CONTENT);
	}

}
