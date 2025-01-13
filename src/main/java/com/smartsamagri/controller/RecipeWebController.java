package com.smartsamagri.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecipeWebController {
    @GetMapping("/Ingredients")
    public String listRecipes() {
        return "DiscoverRecipe";
    }
}
