package com.judge.service;

import com.judge.model.Blog;
import com.judge.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Blog findByIdHaveBusiness(Long id) {
        return blogRepository.findOne(id);
    }

    @Override
    public void saveHaveBusiness(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void removeHaveBusiness(Long id) {
        blogRepository.delete(id);
    }

//    @Override
//    public Page<Blog> findAllHaveBusiness(Pageable pageable) {
//        return blogRepository.findAll(pageable);
//    }

//    @Override
//    public Page<Blog> findAllHaveBusiness(Pageable pageable) {
//        return blogRepository.findAll(pageable);
//    }

    @Override
    public Page<Blog> findAllByTopicContaining(String topic, Pageable pageable) {
        return blogRepository.findAllByTopicContaining(topic,pageable);
    }

    @Override
    public Page<Blog> findAllHaveBusiness(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public void addHaveBusiness(Blog blog) {

    }
}
