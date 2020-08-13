package rabbitmq.services;


import com.warehouseService.rabbitmq.domains.Content;

import java.util.List;

public interface ContentService {
    public List<Content> getAllContents();
    public Content save(Content content);
    public Content find(String slug);
    //Content editContentBySlug(String slug);
    public void delete(String slug);
}
