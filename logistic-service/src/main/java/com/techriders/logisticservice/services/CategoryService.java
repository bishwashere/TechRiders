package com.techriders.logisticservice.services;


import com.techriders.logisticservice.domains.Category;

import java.util.List;

public interface CategoryService {
    Category save(Category category);

    List<Category> findAll();

    void delete(Integer id);
    Category findById(Integer id);
}
