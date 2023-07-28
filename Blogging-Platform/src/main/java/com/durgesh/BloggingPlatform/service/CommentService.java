package com.durgesh.BloggingPlatform.service;

import com.durgesh.BloggingPlatform.dto.CommentRequest;
import com.durgesh.BloggingPlatform.dto.CommentResponse;
import com.durgesh.BloggingPlatform.model.Comment;
import com.durgesh.BloggingPlatform.model.Post;
import com.durgesh.BloggingPlatform.model.User;
import com.durgesh.BloggingPlatform.repo.IComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    private IComment iComment;
    @Autowired
    private CommentResponse commentResponse;
    @Autowired
    private UserService userService;
    @Autowired
    private CommentRequest commentRequest;

    //create comment
    public String createComment(CommentRequest commentRequest){
        Comment comment=new Comment();
        comment.setCommentId(commentRequest.getCommentId());
        comment.setCommentBody(commentRequest.getCommentBody());
        comment.setInstaPost(new Post(commentRequest.getPostId()));
        comment.setCommenter(new User(commentRequest.getCommenterId()));
        if(!userService.validate(comment.getCommenter().getUserId())) return "u cannot create comment by others id";
        comment.setCommenter(comment.getCommenter());
        comment.setCommentCreationTimeStamp(LocalDateTime.now());

        iComment.save(comment);
        return "comment created succesfully";
    }

    //delete comment

    public String deleteCommentById(int id){
        if(iComment.findById(id).isEmpty()){
            return "No such comment found ...";
        }
        Comment comment=iComment.findById(id).get();
        if(!userService.validate(comment.getCommenter().getUserId())) return "u cannot delete someone elses comment";

        else iComment.deleteById(id);
        //logic to delete a comment of our own ..not others
        return "comment deleted successfully";
    }

    //get All comments By post id

    public List<CommentResponse> getAllByPostId(int postId){
        Pageable pageable= PageRequest.of(0,2);
        List<Comment> comments=iComment.findAllByPostId(postId,pageable);
        List<CommentResponse> commentResponses=new ArrayList<>();
        for(Comment c:comments){
            commentResponses.add(new CommentResponse(c.getCommentId(),c.getCommentBody(),
                    c.getCommentCreationTimeStamp(),c.getInstaPost().getPostId(),c.getInstaPost().getPostOwner().getUserHandle(),
                    c.getCommenter().getUserId(),c.getCommenter().getUserHandle()));

        }
        return commentResponses;

    }
    //update comment using comment body
    public String updateComment(String commentBody,int commentId){

        if(iComment.findById(commentId).isEmpty())return "no such comment found";
        Comment comment=iComment.findById(commentId).get();
        if(!userService.validate(comment.getCommenter().getUserId()))return "u cant update someone elses comment";
        comment.setCommentBody(commentBody);
        iComment.save(comment);
        return "comment body updated successfully";

    }
}
