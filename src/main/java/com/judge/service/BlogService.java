package com.judge.service;

import com.judge.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService extends GeneralService<Blog>{

    Page<Blog> findAllByTopicContaining(String topic,Pageable pageable);

    Page<Blog> findAllHaveBusiness(Pageable pageable);

    Blog findByIdHaveBusiness(Long id);

    void saveHaveBusiness(Blog blog);

    void removeHaveBusiness(Long id);
}
