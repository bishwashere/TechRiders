package com.techriders.instorepickupservice.services.impl;


import com.techriders.instorepickupservice.domains.Content;
import com.techriders.instorepickupservice.repositories.ContentRepository;
import com.techriders.instorepickupservice.services.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    ContentRepository contentRepository;

    @Override
    public List<Content> getAllContents() {
        return (List<Content>)contentRepository.findAll();
    }

    @Override
    public Content save(Content content) {
        return contentRepository.save(content);
    }

    @Override
    public Content find(String slug) {
        return contentRepository.findById(slug).get();
    }

    @Override
    public void delete(String slug) {
        contentRepository.deleteById(slug);

    }



//    @Override
//    public Content editContentBySlug(String slug) {
//        return null;
//    }
}