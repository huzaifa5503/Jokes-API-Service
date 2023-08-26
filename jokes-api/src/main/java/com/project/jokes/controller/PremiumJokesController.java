package com.project.jokes.controller;

import com.project.jokes.annotations.PremiumApi;
import com.project.jokes.dto.JokeRequestDto;
import com.project.jokes.entity.Joke;
import com.project.jokes.service.PremiumJokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/premium/jokes")
public class PremiumJokesController {

    @Autowired
    private PremiumJokeService jokeService;

    @PremiumApi
    @GetMapping("/getJokes")
    public List<Joke> getAllJokes() {
        return jokeService.getJokes();
    }

    @PremiumApi
    @GetMapping("/random")
    public Joke getRandomJoke() {
        return jokeService.getRandomJoke();
    }

    @PremiumApi
    @PostMapping("/submit")
    public ResponseEntity<String> submitJoke(@RequestBody JokeRequestDto jokeRequestDto) {
        jokeService.submitJoke(jokeRequestDto);
        return ResponseEntity.ok("Joke submitted for approval.");
    }

    @PremiumApi
    @GetMapping("/lookup")
    public List<Joke> searchJokesByKeyword(@RequestParam String keyword) {
        return jokeService.searchJokesByKeyword(keyword);
    }

    @PremiumApi
    @GetMapping("/category")
    public List<Joke> getJokesByCategory(@RequestParam(name = "category") String category) {
        List<Joke> jokesByCategory = jokeService.getJokesByCategory(category);
        return jokesByCategory;
    }
}
