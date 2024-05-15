package com.in.blog.Blogg_Api.Controllers;
import com.in.blog.Blogg_Api.Payloads.PostDto;
import com.in.blog.Blogg_Api.Services.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    private PostServices postServices;
    @PostMapping("/create/{categoryId}/user/{userId}")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer categoryId, @PathVariable Integer userId)
    {
        PostDto newPost=postServices.postCreate(postDto,categoryId,userId);
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }
    @GetMapping("/user/{userId}/post")
    public ResponseEntity<List<PostDto>> getPostByUserId(@PathVariable Integer userId)
    {
        List<PostDto> postDtos=postServices.getByUser(userId);
        return new ResponseEntity<List<PostDto>>(postDtos , HttpStatus.OK);
    }
    @GetMapping("/{categoryId}/category")
    public ResponseEntity<List<PostDto>> getPostByCategoryId(@PathVariable Integer categoryId)
    {
        List<PostDto> posts=this.postServices.getByCategory(categoryId);
        return new ResponseEntity<>(posts,HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<PostDto>> getAllPost()
    {
        List<PostDto> posts=this.postServices.getAllPost();
        return new ResponseEntity<>(posts, HttpStatus.ACCEPTED);
    }
    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId )
    {
        PostDto postDto=this.postServices.getPostById(postId);
        return new ResponseEntity<>(postDto,HttpStatus.OK);
    }

}
