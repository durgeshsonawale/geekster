package com.durgesh.BloggingPlatform.controller;

import com.durgesh.BloggingPlatform.dto.PostResponse;
import com.durgesh.BloggingPlatform.model.Enum.ContentType;
import com.durgesh.BloggingPlatform.model.Post;
import com.durgesh.BloggingPlatform.service.PostService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
@SecurityRequirement(name="AuthenticationToken")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("{id}")
    public PostResponse getById(@PathVariable int id) throws Exception {
        return postService.getPostById(id);
    }

    @PostMapping("create")
    public String createPost(@RequestBody Post post){
        return postService.createPost(post);

    }

    @DeleteMapping("{id}")
    public String deletePostById(@PathVariable int id){
        return postService.deleteByPostId(id);
    }

    @GetMapping("all/{userid}")
    public List<PostResponse> getAllByUserId(@PathVariable int userid){
        return postService.getAllPostByUserId(userid);
    }

    @GetMapping("allPost/{contentType}")
    public List<PostResponse> getAllByPostType(@PathVariable ContentType contentType){
        return postService.getAllPostByPostType(contentType);
    }

    @PutMapping
    public String updatePost(@RequestBody Post post){
        return postService.updatePost(post);
    }

}
