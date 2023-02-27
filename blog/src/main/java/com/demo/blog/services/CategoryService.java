package com.demo.blog.services;

import java.util.List;

import com.demo.blog.payloads.CategoryDto;

public interface CategoryService {
CategoryDto createCategory (CategoryDto categoryDto);
CategoryDto updateCategory (CategoryDto categoryDto, Integer categoryId);
CategoryDto getCategoryById(Integer categoryId);
List<CategoryDto> getAllCategory();
void deleteCategory(Integer categoryId);
}