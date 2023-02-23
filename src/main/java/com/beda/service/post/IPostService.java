package com.beda.service.post;

import com.beda.model.Post;
import com.beda.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public interface IPostService extends IGeneralService<Post> {
    Page<Post> getAll(Pageable pageable);

    Iterable<Post> getAllPostByIndex(int index);

    Iterable<Post> findAllByStatus(int status);

    Iterable<Post> findAllByTitle(String title);

    Iterable<Post> findAllByCategoryIdAndIndex(Long id, int index);

    Iterable<Post> findByTitleContainingAndCategoryId(String title, Long id);

    Iterable<Post> findAllByUserId(Long userId);

    Page<Post> findAllByCategoryId(Long categoryId, Pageable pageable);

    Iterable<Post> findTop6ByCategoryId(Long categoryId);

    Iterable<Post> findTop6New();
}
