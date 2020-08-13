package com.warehouseService.rabbitmq.services.impl;


import com.warehouseService.rabbitmq.domains.Content;
import com.warehouseService.rabbitmq.repositories.ContentRepository;
import com.warehouseService.rabbitmq.services.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
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
    public Content findBySlug(String slug) {

        return contentRepository.findBySlug(slug);
    }

    @Override
    public void deleteBySlug(String slug) {
        contentRepository.deleteBySlug(slug);

    }



//    @Override
//    public Content editContentBySlug(String slug) {
//        return null;
//    }
}
