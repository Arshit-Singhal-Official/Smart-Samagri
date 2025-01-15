package com.smartsamagri.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IngredientWebController {
    @GetMapping("/Ingredients")
    public String listRecipes() {
        return "DiscoverRecipe-new";
    }

    @GetMapping("/test")
    public String test(){
        return "Recipe";
    }
}