package com.warehouseService.rabbitmq.services;


import com.warehouseService.rabbitmq.domains.Content;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface ContentService {
    public List<Content> getAllContents();

    @PreAuthorize("hasPermission(#content,'content-management')")
    public Content save(Content content);
    public Content find(String slug);

    @PreAuthorize("hasPermission(#content,'content-management')")
    public void delete(String slug);
}
