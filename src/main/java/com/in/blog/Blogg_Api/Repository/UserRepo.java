package com.in.blog.Blogg_Api.Repository;

import com.in.blog.Blogg_Api.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
