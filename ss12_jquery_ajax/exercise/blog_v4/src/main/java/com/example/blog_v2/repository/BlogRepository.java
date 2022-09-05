package com.example.blog_v2.repository;


import com.example.blog_v2.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

Page<Blog> findAllByTitleContaining(String title, Pageable pageable);

Page<Blog> findAllByTitleContainingAndCategory_Id(String title,Integer id, Pageable pageable);

Page<Blog> findAllByCategory_Id(Integer id, Pageable pageable);


}
