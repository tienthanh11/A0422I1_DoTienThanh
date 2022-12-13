package com.codegym.picture_update.controller;

import com.codegym.picture_update.model.Comment;
import com.codegym.picture_update.service.CommentService;
import com.codegym.picture_update.service.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService = new CommentServiceImpl();

    @GetMapping("/")
    public ModelAndView showHomePage(@PageableDefault(value = 2) Pageable pageable) {
        Page<Comment> comments = commentService.getAllCommentByDate(pageable);
        ModelAndView modelAndView = new ModelAndView("home", "listComment", comments);
        modelAndView.addObject("newComment", new Comment());
        return modelAndView;
    }

    @PostMapping("/")
    public String insertComment(@ModelAttribute Comment newComment){
        commentService.insertComment(newComment);
        return "redirect:/";
    }

    @GetMapping("/increment/{id}")
    public String incrementLikes(@PathVariable int id){
        Comment comment = commentService.getById(id);
        comment.setLikes(comment.getLikes() + 1);
        commentService.incrementLike(comment);
        return "redirect:/";
    }
}
