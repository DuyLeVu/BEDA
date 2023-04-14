package com.beda.service.category;

import com.beda.model.Category;
import com.beda.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ICategoryService extends IGeneralService<Category> {
    Iterable<Category> findTop7Category();

    Page<Category> getAll(Pageable pageable);

    Iterable<Category> getAllNoPaging();

    Long countPostByCategory(Long categoryId);
}
