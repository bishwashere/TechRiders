package com.techriders.instorepickupservice.services.impl;


import com.techriders.instorepickupservice.domains.Category;
import com.techriders.instorepickupservice.repositories.CategoryRepository;
import com.techriders.instorepickupservice.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category findById(Integer id) {
        Optional optional =  categoryRepository.findById(id);
        if(optional.isPresent()){
            return (Category)optional.get();
        }else{
            return null;
        }
    }
}
