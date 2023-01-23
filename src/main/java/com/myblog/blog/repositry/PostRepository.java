package com.myblog.blog.repositry;

import com.myblog.blog.entites.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository  extends JpaRepository<Post , Long> {
}
