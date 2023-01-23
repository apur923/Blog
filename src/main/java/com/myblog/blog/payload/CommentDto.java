package com.myblog.blog.payload;

import com.myblog.blog.entites.Post;
import lombok.Data;

import javax.persistence.*;

@Data
public class CommentDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String body;

    private String email;
    private String name;

}
