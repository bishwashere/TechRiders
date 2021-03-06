package com.techriders.frontservice.controllers.admin;


import com.techriders.frontservice.domains.Category;
import com.techriders.frontservice.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/administration/product-category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping(value = {"/",""})
    public String index(Model model){
        model.addAttribute("categories",categoryService.findAll());
        return  "admin/category_list";
    }

    @GetMapping(value = "/add")
    public String showCategoryForm(@ModelAttribute("category") Category category){
        return "admin/category_form";
    }
    @PostMapping(value = "/add")
    public String addCategoruy(@Valid  @ModelAttribute("category")Category category, BindingResult bindingResult,RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "admin/category_form";
        }else{
            categoryService.save(category);
            redirectAttributes.addFlashAttribute("success_msg","Category has been created successfully.");
            return "redirect:/administration/product-category";
        }

    }
    @GetMapping(value = "/edit/{id}")
    public String showCategoryFormEdit(Model model, @PathVariable("id") Integer id){
        Category category = categoryService.findById(id);
        model.addAttribute("category",category);
        return "admin/category_form";
    }
    @PostMapping(value = "/edit/{id}")
    public String editCategoruy(@Valid  @ModelAttribute("category")Category category, BindingResult bindingResult,@PathVariable("id") Integer id,RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "admin/category_form";
        }else{
            category.setId(id);
            categoryService.save(category);
            redirectAttributes.addFlashAttribute("success_msg","Category has been updated successfully.");
            return "redirect:/administration/product-category";
        }

    }
    @GetMapping(value = "/delete/{id}")
    public String deleteCategory(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("success_msg","Category has been deleted successfully.");
        categoryService.delete(id);
        return "redirect:/administration/product-category";

    }
}
