package com.beda.service.category;

import com.beda.model.Category;

import java.util.Optional;

public class CategoryServiceImpl implements ICategoryService{
    @Override
    public Iterable<Category> findAll() {
        return null;
    }

    @Override
    public Optional<Category> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Category save(Category category) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
