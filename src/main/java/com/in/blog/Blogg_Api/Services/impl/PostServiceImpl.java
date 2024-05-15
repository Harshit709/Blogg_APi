package com.in.blog.Blogg_Api.Services.impl;
import com.in.blog.Blogg_Api.Entity.Category;
import com.in.blog.Blogg_Api.Entity.Post;
import com.in.blog.Blogg_Api.Entity.User;
import com.in.blog.Blogg_Api.Exceptions.ResourcesNotFoundExecption;
import com.in.blog.Blogg_Api.Payloads.PostDto;
import com.in.blog.Blogg_Api.Repository.CategoryRepo;
import com.in.blog.Blogg_Api.Repository.PostRepo;
import com.in.blog.Blogg_Api.Repository.UserRepo;
import com.in.blog.Blogg_Api.Services.PostServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostServices {
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private  ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public PostDto postCreate(PostDto postDto, Integer categoryId, Integer userId) {
        User uId= userRepo.findById(userId).
            orElseThrow(()->new ResourcesNotFoundExecption("User","Id",userId));
        Category category= categoryRepo.findById(categoryId)
                .orElseThrow(()->new ResourcesNotFoundExecption("Category","Id" , categoryId ));
        Post createPost = modelMapper.map(postDto, Post.class);
        createPost.setImageName("default.png");
        createPost.setAddDate(new Date());
        createPost.setUser(uId);
        createPost.setCategory(category);
        Post newPost=this.postRepo.save(createPost);
        PostDto postDto1= modelMapper.map(newPost, PostDto.class);
        return postDto1 ;

    }
    @Override
    public List<PostDto> getAllPost() {
       List<Post> posts= postRepo.findAll();
       List<PostDto> postDtos=posts.stream().map((post -> this.modelMapper.map(post,PostDto.class))).
               collect(Collectors.toList());
       return postDtos;
    }

    @Override
    public PostDto updatePost(Integer PostId, PostDto postDto) {
        return null;
    }

    @Override
    public void deletePost(Integer PostId) {

    }

    @Override
    public PostDto getPostById(Integer postId) {
     Post post= postRepo.findById(postId).
             orElseThrow(()->new ResourcesNotFoundExecption("Post","Id",postId));
     return this.modelMapper.map(post , PostDto.class);
    }

    @Override
    public List<PostDto> getByCategory(Integer categoryId) {
        Category category=categoryRepo.findById(categoryId).
                orElseThrow(()->new ResourcesNotFoundExecption("category","id",categoryId));
        List<Post> posts=postRepo.findByCategory(category);
        List<PostDto> postDtos =posts.stream().map((post)->this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<PostDto> getByUser(Integer userId) {
        User user= userRepo.findById(userId).
                orElseThrow(()->new ResourcesNotFoundExecption("User","id",userId));
        List<Post>posts =postRepo.findByUser(user);
        List<PostDto> postDtos=posts.stream().map((post)-> this.modelMapper.map(post,PostDto.class)).
                collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<PostDto> postBySearch(String keyword) {
        return null;
    }
}
