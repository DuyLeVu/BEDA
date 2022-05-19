package com.beda.service.post;

import com.beda.model.Post;
import com.beda.service.IGeneralService;
import org.springframework.stereotype.Service;

@Service
public interface IPostService extends IGeneralService<Post> {
    Iterable<Post> findAllByStatus(int status);

    Iterable<Post> findAllByTitle(String title);

    Iterable<Post> findAllByCategoryId(Long id);

    Iterable<Post> findByTitleContainingAndCategoryId(String title, Long id);

    Iterable<Post> findAllByUserId(Long userId);
}
