package com.durgesh.BloggingPlatform.service;

import com.durgesh.BloggingPlatform.dto.CommentResponse;
import com.durgesh.BloggingPlatform.dto.PostResponse;
import com.durgesh.BloggingPlatform.model.Comment;
import com.durgesh.BloggingPlatform.model.Enum.ContentType;
import com.durgesh.BloggingPlatform.model.Post;
import com.durgesh.BloggingPlatform.repo.IPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private IPostRepo iPostRepo;

    @Autowired
    private PostResponse postResponse;
    @Autowired
    private UserService userService;

    //create post
    public String createPost(Post post){
        if(!userService.validate(post.getPostOwner().getUserId()))return "u cannot create post on someone elses id";
            post.setPostCreatedTimeStamp(LocalDateTime.now());
        iPostRepo.save(post);
        //logic to post a blog using our own id only ??
        return "post created Successfully";
    }

    // delete post by id

    public String deleteByPostId(int id){
        if(iPostRepo.findById(id).isEmpty()){
            return "No such post found ...";
        }
        Post post=iPostRepo.findById(id).get();
        if(!userService.validate(post.getPostOwner().getUserId())) return "u cannot delete someone elses post";
        else iPostRepo.deleteById(id);
        //logic to delete a post of our own ..not others
        return "post deleted successfully";
    }

    // get post by id

    public PostResponse getPostById(int id) throws Exception {
        Post post = iPostRepo.findById(id).orElseThrow(() -> new RuntimeException("post not found"));
        postResponse.setPostContent(post.getPostContent());
        postResponse.setPostCaption(post.getPostCaption());
        postResponse.setPostLocation(post.getPostLocation());
        postResponse.setPostCreatedTimeStamp(post.getPostCreatedTimeStamp());
        postResponse.setPostOwnerUserHandle(post.getPostOwner().getUserHandle());
        postResponse.setContentType(post.getContentType());
        postResponse.setPostId(post.getPostId());
        return postResponse;
    }
    //get post by user id

    public List<PostResponse> getAllPostByUserId(int userId){
        Pageable pageable = PageRequest.of(0, 10);
            List<Post> posts=iPostRepo.findAllByUserId(userId,pageable);
            List<PostResponse> postResponses=new ArrayList<>();
            for(Post c:posts){
                postResponses.add(new PostResponse(c.getPostId(),c.getPostContent(),
                        c.getPostCaption(),c.getPostLocation(),c.getContentType(),c.getPostCreatedTimeStamp()
                ,c.getPostOwner().getUserHandle()));

            }
            return postResponses;
        }

    public List<PostResponse> getAllPostByPostType(ContentType type){
        Pageable pageable = PageRequest.of(0, 10);
        List<Post> posts=iPostRepo.findAllByContentType1(String.valueOf(type),pageable);
        List<PostResponse> postResponses=new ArrayList<>();
        for(Post c:posts){
            postResponses.add(new PostResponse(c.getPostId(),c.getPostContent(),
                    c.getPostCaption(),c.getPostLocation(),c.getContentType(),c.getPostCreatedTimeStamp()
                    ,c.getPostOwner().getUserHandle()));

        }
        return postResponses;
    }

    //update postcontent using postBody

    public String updatePost(Post post){
        int postId=post.getPostId();
        if(iPostRepo.findById(postId).isEmpty())return "no such post present";
        Post updatePost=iPostRepo.findById(postId).orElseThrow(()->new NullPointerException("post u r looking for is not present"));
        if(!userService.validate(updatePost.getPostOwner().getUserId()))return "u cant update someone elses post";
        updatePost.setPostCaption(post.getPostCaption());
        updatePost.setPostContent(post.getPostContent());
        updatePost.setPostLocation(post.getPostLocation());
        updatePost.setPostCreatedTimeStamp(LocalDateTime.now());
        updatePost.setContentType(post.getContentType());
        iPostRepo.save(updatePost);
        return "post updated successfully";

    }





}
