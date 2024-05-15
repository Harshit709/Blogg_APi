package com.in.blog.Blogg_Api.Services;

import com.in.blog.Blogg_Api.Payloads.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto0);
    List<CategoryDto> getAllCategory();
    CategoryDto UpdateCategory(CategoryDto categoryDto, Integer categoryId);
    CategoryDto getCategoryById(Integer categoryId);
    void deleteCategory(Integer categoryID);

}
