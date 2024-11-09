package com.smartsamagri.controller;

import com.smartsamagri.model.RecipeIngredient;
import com.smartsamagri.service.RecipeIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipe-ingredients")
public class RecipeIngredientController {

    @Autowired
    private RecipeIngredientService recipeIngredientService;

    @PostMapping
    public RecipeIngredient createRecipeIngredient(@RequestBody RecipeIngredient recipeIngredient) {
        return recipeIngredientService.createRecipeIngredient(recipeIngredient);
    }

    @GetMapping
    public List<RecipeIngredient> getAllRecipeIngredients() {
        return recipeIngredientService.getAllRecipeIngredients();
    }
}
