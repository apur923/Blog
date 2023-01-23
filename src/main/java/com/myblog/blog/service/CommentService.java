package com.myblog.blog.service;

import com.myblog.blog.payload.CommentDto;

public interface CommentService {
    CommentDto createComment(long postId,CommentDto commentDto);
}
