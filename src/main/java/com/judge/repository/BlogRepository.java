package com.judge.repository;

import com.judge.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BlogRepository extends PagingAndSortingRepository<Blog, Long> {

    Page<Blog> findAllByTopicContaining(String topic, Pageable pageable);
}
