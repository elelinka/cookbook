package com.example.cookbook.repository;

import com.example.cookbook.entity.Recipe;
import com.example.cookbook.entity.RecipeCategory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findAllByOrderByLikeCounterDesc(Pageable pageable);

    List<Recipe> findAllByRecipeCategory(RecipeCategory recipeCategory);
}
