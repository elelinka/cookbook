package com.example.cookbook.controller;

import com.example.cookbook.entity.Recipe;
import com.example.cookbook.entity.RecipeCategory;
import com.example.cookbook.repository.RecipeCategoryRepository;
import com.example.cookbook.repository.RecipeRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    private RecipeRepository recipeRepository;
    private RecipeCategoryRepository recipeCategoryRepository;

    public HomeController(RecipeRepository recipeRepository, RecipeCategoryRepository recipeCategoryRepository) {
        this.recipeRepository = recipeRepository;
        this.recipeCategoryRepository = recipeCategoryRepository;
    }

    @GetMapping("/")
    public String home(Model model) {

        List<Recipe> recipes = recipeRepository.findAllByOrderByLikeCounterDesc(PageRequest.of(0, 4));

        model.addAttribute("recipes", recipes);

        return "home";
    }

    @GetMapping("/category")
    public String category(@RequestParam Long id, Model model){
        Optional<RecipeCategory> category = recipeCategoryRepository.findById(id);
        if (category.isPresent()) {
            RecipeCategory recipeCategory = category.get();
            List<Recipe> allByRecipeCategory = recipeRepository.findAllByRecipeCategory(recipeCategory);

            model.addAttribute("recipesByCategory", allByRecipeCategory);
            model.addAttribute("category", recipeCategory);
            return "category";
        } else {
            return "redirect:/";
        }
    }
}
