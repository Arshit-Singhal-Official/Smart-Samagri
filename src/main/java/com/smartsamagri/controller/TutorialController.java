package com.smartsamagri.controller;

import com.smartsamagri.model.Tutorial;
import com.smartsamagri.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tutorials")
public class TutorialController {

    @Autowired
    private TutorialService tutorialService;

    @PostMapping
    public Tutorial createTutorial(@RequestBody Tutorial tutorial) {
        return tutorialService.createTutorial(tutorial);
    }

    @GetMapping
    public List<Tutorial> getAllTutorials() {
        return tutorialService.getAllTutorials();
    }
}
