package com.durgesh.BloggingPlatform.controller;

import com.durgesh.BloggingPlatform.dto.CommentRequest;
import com.durgesh.BloggingPlatform.dto.CommentResponse;
import com.durgesh.BloggingPlatform.model.Comment;
import com.durgesh.BloggingPlatform.service.CommentService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comment")
@SecurityRequirement(name="AuthenticationToken")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("all/{postId}")
    public List<CommentResponse> getAllCommentByPostId (@PathVariable int postId){
        return commentService.getAllByPostId(postId);
    }

    @PostMapping("create")
    public String createComment(@RequestBody CommentRequest commentRequest){
        return commentService.createComment(commentRequest);

    }

    @DeleteMapping("{id}")
    public String deleteCommentById(@PathVariable int id){
        return commentService.deleteCommentById(id);
    }
    @PutMapping("{commentBody}/{commentId}")
    public String updateComment(@PathVariable String commentBody,@PathVariable int commentId){
        return commentService.updateComment(commentBody,commentId);
    }
}
