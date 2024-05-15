package com.in.blog.Blogg_Api.Payloads;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {
    private Integer categoryId;
    @NotBlank(message = "title should be field")
    @Size(min=20 , max = 25)
    private String categoryTitle;
    @NotBlank
    private String categoryDescription;

}
