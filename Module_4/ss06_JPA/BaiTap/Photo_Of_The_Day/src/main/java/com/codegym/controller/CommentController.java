package com.codegym.controller;

import com.codegym.model.Comment;
import com.codegym.service.CommentService;
import com.codegym.service.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService = new CommentServiceImpl();

    @GetMapping("/")
    public ModelAndView showHomePage() {
        List<Comment> commentList = commentService.getAllCommentByDate();
        ModelAndView modelAndView = new ModelAndView("/home", "commentList", commentList);
        modelAndView.addObject("newComment", new Comment());
        return modelAndView;
    }

    @PostMapping("/")
    public String insertComment(@ModelAttribute Comment newComment){
        commentService.insertComment(newComment);
        return "redirect:/home";
    }

    @GetMapping("/increment/{id}")
    public String incrementLikes(@PathVariable int id){
        Comment comment = commentService.getById(id);
        comment.setLikes(comment.getLikes() + 1);
        commentService.incrementLike(comment);
        return "redirect:/home";
    }
}
