package com.in.blog.Blogg_Api.Payloads;
import com.in.blog.Blogg_Api.Entity.Category;
import com.in.blog.Blogg_Api.Entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
    private String title;
    private  String content;
    private Date addDate;
    private String imageName;
    private Category category;
    private User user;


}
