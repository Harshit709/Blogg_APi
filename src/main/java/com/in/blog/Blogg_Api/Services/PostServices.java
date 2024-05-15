package com.in.blog.Blogg_Api.Services;

import com.in.blog.Blogg_Api.Entity.Post;
import com.in.blog.Blogg_Api.Payloads.PostDto;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface PostServices {
    PostDto postCreate(PostDto postDto, Integer categoryId, Integer userId);
    List<PostDto>getAllPost();
    PostDto updatePost(Integer PostId, PostDto postDto);
    void deletePost(Integer PostId);
    PostDto getPostById(Integer postId);
    List<PostDto> getByCategory(Integer categoryId);
    List<PostDto> getByUser(Integer userId);
    List<PostDto> postBySearch(String keyword);






}
