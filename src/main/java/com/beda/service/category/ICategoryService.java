package com.beda.service.category;

import com.beda.model.Category;
import com.beda.service.IGeneralService;
import org.springframework.stereotype.Service;

@Service
public interface ICategoryService extends IGeneralService<Category> {
    Iterable<Category> findTop7Category();
}
