package com.in.blog.Blogg_Api.Exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourcesNotFoundExecption extends RuntimeException {
    String resourceName;
    String fieldName;
    long fieldValue;

    public ResourcesNotFoundExecption(String resourceName, String fieldName, long fieldValue) {
        super(String.format("%s not found with %s : %s",resourceName , fieldName,fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
