package com.example.cookbook.controller;

import com.example.cookbook.entity.Recipe;
import com.example.cookbook.repository.RecipeRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private RecipeRepository recipeRepository;

    public HomeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("/")
    public String home(Model model) {

        List<Recipe> recipes = recipeRepository.findAllByOrderByLikeCounterDesc(PageRequest.of(0, 4));

        model.addAttribute("recipes", recipes);

        return "home";
    }
}
