package com.judge.controller;

import com.judge.model.Blog;
import com.judge.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/blog")
    public ModelAndView listBlog(@RequestParam("s") Optional<String> s,@PageableDefault(value = 3) Pageable pageable) {

        Page<Blog> blogList;
        if(s.isPresent()){
            blogList=blogService.findAllByTopicContaining(s.get(),pageable);
        } else {
            blogList=blogService.findAllHaveBusiness(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("blog/list");
        modelAndView.addObject("blog", blogList);
        return modelAndView;
    }

    @GetMapping("/create-blog")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("blog/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveBlog(@ModelAttribute("blog") Blog blog) {
        blogService.saveHaveBusiness(blog);

        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("message", "New blog created");
        return modelAndView;
    }

    @GetMapping("/edit-blog/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Blog blog = blogService.findByIdHaveBusiness(id);
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @PostMapping("/edit-blog")
    public ModelAndView updateBlog(@ModelAttribute("blog") Blog blog) {
        blogService.saveHaveBusiness(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Blog updated");
        return modelAndView;
    }

    @GetMapping("/delete-blog/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Blog blog = blogService.findByIdHaveBusiness(id);
        ModelAndView modelAndView = new ModelAndView("/blog/delete");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @PostMapping("/delete-blog")
    public ModelAndView deleteBlog(@ModelAttribute Blog blog) {
        blogService.removeHaveBusiness(blog.getId());
        ModelAndView modelAndView = new ModelAndView("/blog/delete");
        return modelAndView;
    }
}
