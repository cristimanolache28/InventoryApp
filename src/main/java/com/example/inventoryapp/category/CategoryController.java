package com.example.inventoryapp.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository repo;

    @GetMapping("/categories")
    public String listCategories(Model model) {
        List<Category> listCategories = repo.findAll();
        model.addAttribute("listCategories", listCategories);
        return "categories";
    }

    @GetMapping("/categories/new")
    public String showCategoryNewForm(Model model) {
        model.addAttribute("category", new Category());
        return "category_form";
    }

    @GetMapping("/categories/save")
    @RequestMapping(method = RequestMethod.POST)
    public String saveCategory(Category category) {
        repo.save(category);
        return "redirect:/categories";
    }
}
