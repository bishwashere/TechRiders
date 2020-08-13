package com.techriders.frontservice.services;


import com.techriders.frontservice.domains.Content;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface ContentService {
    public List<Content> getAllContents();


    public Content save(Content content);

    public Content find(String slug);


    public void delete(String slug);
}
