package com.in.blog.Blogg_Api.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Entity
@Table(name="Post_info")
@Getter
@Setter
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer post_Id;
    @Column(nullable = false, length =1000)
    private String title;
    @Column(nullable = false)
    private String content;
    private String imageName;
    private Date addDate;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "categoryId")
    private Category category;
    @ManyToOne
    @JsonIgnore
    private User user;
}
