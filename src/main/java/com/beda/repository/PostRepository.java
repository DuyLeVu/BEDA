package com.beda.repository;

import com.beda.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Modifying
    @Query(value = "select * from Post where status = 1 order by id desc limit ?1,5;", nativeQuery = true)
    Iterable<Post> getAllPostByIndex(int index);

    @Modifying
    @Query(value = "select * from Post where status = 1 order by id desc limit 6;", nativeQuery = true)
    Iterable<Post> findTop6New();

    @Modifying
    @Query(value = "select * from Post where status = 1 and category_id = :id order by id desc limit 6;", nativeQuery = true)
    Iterable<Post> findTop6NewByCategory(@Param("id") Long id);

    Iterable<Post> findAllByStatus(int status);
    Iterable<Post> findAllByTitle(String title);

    @Modifying
    @Query(value = "select * from Post where status = 1 and category_id = :id", nativeQuery = true)
    Iterable<Post> findAllByCategoryId(@Param("id") Long id);

    @Modifying
    @Query(value = "select * from Post where status = 1 and category_id = ?1 order by id desc limit ?2,5;", nativeQuery = true)
    Iterable<Post> findAllByCategoryIdAndIndex(Long id, int index);

    Iterable<Post> findByTitleContainingAndCategoryId(String title, Long id);
    Iterable<Post> findAllByUserId(Long id);
}
