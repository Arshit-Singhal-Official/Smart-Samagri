package com.smartsamagri.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class APIProxyService {

    private static final String API_URL = "https://spoonacular.com/recipes/";

    public String fetchRecipeDetails(String recipeId) {
        String url = API_URL + recipeId;

        // Fetch the HTML response from Spoonacular
        RestTemplate restTemplate = new RestTemplate();
        String htmlContent = restTemplate.getForObject(url, String.class);

        // Optionally, parse the HTML content with JSoup if you want to modify it
        Document doc = Jsoup.parse(htmlContent);
        
        // Further processing can be done here if needed (e.g., cleaning or modifying HTML)

        return doc.html(); // Return the modified HTML
    }
}
