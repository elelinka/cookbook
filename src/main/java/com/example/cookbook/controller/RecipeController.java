package com.example.cookbook.controller;

import com.example.cookbook.entity.Ingredient;
import com.example.cookbook.entity.Recipe;
import com.example.cookbook.entity.RecipeCategory;
import com.example.cookbook.repository.RecipeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/admin/add")
    public String addForm(Model model, @RequestParam(required = false) String name, @RequestParam(required = false) String description,
                          @RequestParam(required = false) String img, @RequestParam(required = false) List<Ingredient> ingredient,
                          @RequestParam(required = false) RecipeCategory category) {

        Recipe recipe = new Recipe(name, description, img);
        model.addAttribute("recipe", recipe);
        return "add";
    }

    @PostMapping("/admin/add")
    public String addRecipe(Recipe recipe) {
        recipeRepository.save(recipe);

        return "redirect:/";
    }

    @GetMapping("/recipe/{id}")
    public String getRecipeDetails(@PathVariable Long id, Model model) {
        Optional<Recipe> recipeById = recipeRepository.findById(id);

        if (recipeById.isPresent()) {
            Recipe recipe = recipeById.get();
            List<Ingredient> ingredients = recipe.getIngredients();

            model.addAttribute("ingredients", ingredients);
            model.addAttribute("recipe", recipe);
            return "recipeDetails";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/recipe/edit/{id}")
    public String editRecipe(@PathVariable Long id, Model model) {

        Optional<Recipe> byId = recipeRepository.findById(id);
        if (byId.isPresent()) {
            Recipe recipe = byId.get();
            List<Ingredient> ingredients = recipe.getIngredients();

            recipe.setName(recipe.getName());
            recipe.setDescription(recipe.getDescription());
            recipe.setIngredients(ingredients);
            recipe.setImg(recipe.getImg());
            recipe.setRecipeCategory(recipe.getRecipeCategory());

            model.addAttribute("editRecipe", recipe);
            model.addAttribute("ingredients", ingredients);
            return "edit";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/recipe/edit/{id}")
    public String editRecipeSave(@PathVariable Long id, Recipe recipe) {

        recipeRepository.save(recipe);
        return "redirect:/";
    }
}
