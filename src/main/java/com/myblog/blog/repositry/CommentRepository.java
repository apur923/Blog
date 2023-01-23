package com.myblog.blog.repositry;

import com.myblog.blog.entites.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long>{
}
