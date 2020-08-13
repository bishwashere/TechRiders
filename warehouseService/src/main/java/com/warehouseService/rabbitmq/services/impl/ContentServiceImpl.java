<<<<<<< HEAD:warehouseService/src/main/java/com/techriders/logisticservice/services/impl/ContentServiceImpl.java
package com.techriders.logisticservice.services.impl;


import com.techriders.logisticservice.domains.Content;
import com.techriders.logisticservice.repositories.ContentRepository;
import com.techriders.logisticservice.services.ContentService;
=======
package com.warehouseService.rabbitmq.services.impl;


import com.warehouseService.rabbitmq.domains.Content;
import com.warehouseService.rabbitmq.repositories.ContentRepository;
import com.warehouseService.rabbitmq.services.ContentService;
>>>>>>> 74e49a5e86fbe11f21dd98e2f840978f217ebe7a:warehouseService/src/main/java/com/warehouseService/rabbitmq/services/impl/ContentServiceImpl.java
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
