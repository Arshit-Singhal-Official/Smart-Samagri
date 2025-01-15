package com.smartsamagri.controller;

import com.smartsamagri.service.APIProxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private APIProxyService APIProxyService;

    @GetMapping("/{recipeId}")
    @ResponseBody
    public String getRecipePage(@PathVariable String recipeId, HttpServletRequest request) {
        // Extract the domain dynamically from the request
        String domain = request.getRequestURL().toString().replace(request.getRequestURI(), "");

        // Fetch the HTML content
        String recipePage = APIProxyService.fetchRecipeDetails(recipeId);

        // Replace external URLs in the HTML with the domain
        recipePage = recipePage.replace("https://spoonacular.com/recipes/", domain + "/recipes/");

        return recipePage;
    }
}
