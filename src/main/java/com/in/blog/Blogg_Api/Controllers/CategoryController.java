package com.in.blog.Blogg_Api.Controllers;

import com.in.blog.Blogg_Api.Entity.Category;
import com.in.blog.Blogg_Api.Payloads.ApiResponse;
import com.in.blog.Blogg_Api.Payloads.CategoryDto;
import com.in.blog.Blogg_Api.Services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto)
    {
        CategoryDto createdCategory =categoryService.createCategory(categoryDto);
        return new ResponseEntity<CategoryDto>(createdCategory, HttpStatus.CREATED);
    }
    @GetMapping("{categoryId}")
    public ResponseEntity<CategoryDto> getCategory(@Valid @PathVariable Integer categoryId)
    {
        CategoryDto existCategory=categoryService.getCategoryById(categoryId);
        return new ResponseEntity<CategoryDto>(existCategory, HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategiry()
    {
      List<CategoryDto> allCategory=  categoryService.getAllCategory();
      return new ResponseEntity<>(allCategory,HttpStatus.OK);

    }
    @PutMapping("{categiryId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @PathVariable Integer categiryId ,@RequestBody CategoryDto categoryDto)
    {
         CategoryDto updatedCategory=categoryService.UpdateCategory(categoryDto, categiryId);
         return new ResponseEntity<CategoryDto>(updatedCategory,HttpStatus.OK);
    }
    @DeleteMapping("{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId)
    {
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("user deleted ", true),HttpStatus.OK);
    }
}
