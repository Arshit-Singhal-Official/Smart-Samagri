package com.smartsamagri.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class RecipeWebController {

    private final String API_KEY = "3a6663a01202453c88a46bbe0f911c73";
    private final String API_URL = "https://api.spoonacular.com/recipes/findByIngredients";

    @PostMapping("/recipes/findRecipes")
public ResponseEntity<String> findRecipes(@RequestBody List<String> ingredients) {
    System.out.println("Received ingredients: " + ingredients);  // Log received ingredients
    RestTemplate restTemplate = new RestTemplate();
    String ingredientsParam = String.join(",", ingredients);
    String url = API_URL + "?ingredients=" + ingredientsParam + "&number=5&apiKey=" + API_KEY;
    String response = restTemplate.getForObject(url, String.class);
    return ResponseEntity.ok(response);  // Return the response from Spoonacular API
}

}
