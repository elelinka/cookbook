package com.example.cookbook.controller;

import com.example.cookbook.entity.Recipe;
import com.example.cookbook.repository.RecipeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RecipeController {

    private RecipeRepository recipeRepository;

    public RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("/admin")
    public String getAll(Model model) {
        List<Recipe> all = recipeRepository.findAll();

        model.addAttribute("all", all);
        return "admin";
    }

    @GetMapping("/admin/1")
    public String addForm() {
        return "admin";
    }

}
