package com.demo.blog.services.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.blog.entities.Category;
import com.demo.blog.exceptions.ResourceNotFoundException;
import com.demo.blog.payloads.CategoryDto;

import com.demo.blog.repositories.CategoryRepo;

import com.demo.blog.services.CategoryService;

import lombok.Setter;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		// TODO Auto-generated method stub
		Category cat = this.modelMapper.map(categoryDto, Category.class);
		Category savedCategory = this.categoryRepo.save(cat);
		return this.modelMapper.map(savedCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		// TODO Auto-generated method stub
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException ("category", "Id", categoryId));
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		Category updatedcategory = this.categoryRepo.save(category);
		CategoryDto categoryDto1 = this.categoryToDto (updatedcategory);
		return categoryDto1;
	}

	@Override
	public CategoryDto getCategoryById(Integer categoryId) {
		// TODO Auto-generated method stub
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category", "Id", categoryId));
		return this.categoryToDto(category);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		// TODO Auto-generated method stub
		List<Category> categorys = this.categoryRepo.findAll();
		List<CategoryDto> categoryDtos = categorys.stream().map(category->this.categoryToDto(category)).collect(Collectors.toList());
		return categoryDtos;
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("category", "Id", categoryId));
		this.categoryRepo.delete(category);

	}
	
	private Category dtoTocategory(CategoryDto categoryDto)
	{
		Category category = this.modelMapper.map(categoryDto, Category.class);
		return category;
	}
	
		public CategoryDto categoryToDto (Category category) {
		CategoryDto categoryDto = this.modelMapper.map(category, CategoryDto.class);
		return categoryDto;
		}

}
