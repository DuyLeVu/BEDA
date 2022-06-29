package com.beda.service.post;

import com.beda.model.Post;
import com.beda.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface IPostService extends IGeneralService<Post> {
    Iterable<Post> getAllPostByIndex(int index);

    Iterable<Post> findAllByStatus(int status);

    Iterable<Post> findAllByTitle(String title);

    Iterable<Post> findAllByCategoryIdAndIndex(Long id, int index);

    Iterable<Post> findByTitleContainingAndCategoryId(String title, Long id);

    Iterable<Post> findAllByUserId(Long userId);

    Iterable<Post> findAllByCategoryId(Long categoryId);

    Iterable<Post> findTop6New();
}
