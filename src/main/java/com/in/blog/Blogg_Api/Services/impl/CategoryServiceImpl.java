package com.in.blog.Blogg_Api.Services.impl;
import com.in.blog.Blogg_Api.Entity.Category;
import com.in.blog.Blogg_Api.Exceptions.ResourcesNotFoundExecption;
import com.in.blog.Blogg_Api.Payloads.CategoryDto;
import com.in.blog.Blogg_Api.Repository.CategoryRepo;
import com.in.blog.Blogg_Api.Services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category=categorydtoToCategory(categoryDto);
        categoryRepo.save(category);
        return categoryToCategoryDto(category);
    }
    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> allCategory=categoryRepo.findAll();
        List<CategoryDto> listOfCategory= allCategory.stream().map(category->modelMapper.map(category,CategoryDto.class))
                .collect(Collectors.toList());
        return listOfCategory;

    }
    @Override
    public CategoryDto UpdateCategory(CategoryDto categoryDto, Integer categoryId) {
       Category existCategory = this.categoryRepo.findById(categoryId).
               orElseThrow(()->new ResourcesNotFoundExecption("Category","Id",categoryId));
       existCategory.setCategoryTitle(categoryDto.getCategoryTitle());
       existCategory.setCategoryDescription(categoryDto.getCategoryDescription());
       Category updatedCat=this.categoryRepo.save(existCategory);
       return categoryToCategoryDto(updatedCat);
    }
    @Override
    public CategoryDto getCategoryById(Integer categoryId) {
        Category existCategory=this.categoryRepo.findById(categoryId)
                .orElseThrow(()->new ResourcesNotFoundExecption("Category","ID",categoryId));
        return categoryToCategoryDto(existCategory);
    }
    @Override
    public void deleteCategory(Integer categoryID) {
        Category existCategory=this.categoryRepo.findById(categoryID) .
                orElseThrow(()->new ResourcesNotFoundExecption("Category","id", categoryID));
        this.categoryRepo.delete(existCategory);
    }
    private Category categorydtoToCategory(CategoryDto categoryDto)
    {
         return modelMapper.map(categoryDto,Category.class);
    }
    private CategoryDto categoryToCategoryDto(Category category)
    {
        return modelMapper.map(category , CategoryDto.class);
    }
}
