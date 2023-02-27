package com.demo.blog.controllers;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.blog.entities.Category;
import com.demo.blog.payloads.ApiResponse;
import com.demo.blog.payloads.CategoryDto;
import com.demo.blog.services.CategoryService;
import com.demo.blog.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	// POST-create category
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createcategory (@Valid @RequestBody CategoryDto categoryDto) {
	CategoryDto createcategoryDto = this.categoryService.createCategory(categoryDto);
	return new ResponseEntity<>(createcategoryDto, HttpStatus.CREATED);
	}
	// PUT- update category
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> updatecategory (@RequestBody CategoryDto categoryDto,@PathVariable Integer categoryId) {
	CategoryDto updatedcategoryDto = this.categoryService.updateCategory (categoryDto,categoryId);
	return ResponseEntity.ok(updatedcategoryDto);
	}
	// DELETE -delete category
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<ApiResponse> deletecategory (@PathVariable Integer categoryId) {
	this.categoryService.deleteCategory(categoryId);
	return new ResponseEntity<ApiResponse>(new ApiResponse("category deleted successfully",false),HttpStatus.OK);
	}
	// GET category get
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> getcategoryById (@PathVariable Integer categoryId) {
	CategoryDto fetchedcategory =  this.categoryService.getCategoryById(categoryId);
	return ResponseEntity.ok(fetchedcategory);
	}
	
	// GET all category get
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllcategorys () {
	List<CategoryDto> allcategorys =  this.categoryService.getAllCategory();
	return ResponseEntity.ok(allcategorys);
	}
}
