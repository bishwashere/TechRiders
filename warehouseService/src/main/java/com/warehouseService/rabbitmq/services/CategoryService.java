package com.warehouseService.rabbitmq.services;


import com.warehouseService.rabbitmq.domains.Category;

import java.util.List;

public interface CategoryService {
    Category save(Category category);

    List<Category> findAll();

    void delete(Integer id);
    Category findById(Integer id);
}
