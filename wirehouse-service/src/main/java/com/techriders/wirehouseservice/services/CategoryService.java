package com.techriders.wirehouseservice.services;


import com.techriders.wirehouseservice.domains.Category;

import java.util.List;

public interface CategoryService {
    Category save(Category category);

    List<Category> findAll();

    void delete(Integer id);
    Category findById(Integer id);
}
