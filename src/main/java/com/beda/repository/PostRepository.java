package com.beda.repository;

import com.beda.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    //    Post findByName(String roleName);
    Iterable<Post> findAllByStatus(int status);
    Iterable<Post> findAllByTitle(String title);
    Iterable<Post> findAllByCategoryId(Long id);
    Iterable<Post> findByTitleContainingAndCategoryId(String title, Long id);
    Iterable<Post> findAllByUserId(Long id);
}
