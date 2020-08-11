package com.techriders.instorepickupservice.services;


import com.techriders.instorepickupservice.domains.Category;

import java.util.List;

public interface CategoryService {
    Category save(Category category);

    List<Category> findAll();

    void delete(Integer id);
    Category findById(Integer id);
}
