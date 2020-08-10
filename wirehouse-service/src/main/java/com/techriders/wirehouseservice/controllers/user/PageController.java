package com.techriders.wirehouseservice.controllers.user;

import com.techriders.wirehouseservice.domains.Content;
import com.techriders.wirehouseservice.services.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {
    @Autowired
    ContentService contentService;

    @GetMapping("page/{slug}")
    public String getPage(@PathVariable("slug") String slug, Model model) {
        Content content = contentService.find(slug);
        model.addAttribute("content", content);
        return "user/page";

    }
}
