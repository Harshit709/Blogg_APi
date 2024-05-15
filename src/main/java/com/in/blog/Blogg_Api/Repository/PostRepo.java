package com.in.blog.Blogg_Api.Repository;
import com.in.blog.Blogg_Api.Entity.Category;
import com.in.blog.Blogg_Api.Entity.Post;
import com.in.blog.Blogg_Api.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {
    List<Post> findByUser(User user );
    List<Post> findByCategory(Category category );


}
