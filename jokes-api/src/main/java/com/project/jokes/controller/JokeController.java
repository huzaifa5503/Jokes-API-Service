package com.project.jokes.controller;

import com.project.jokes.entity.Joke;
import com.project.jokes.service.FreeJokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/jokes")
public class JokeController {
    @Autowired
    private FreeJokeService jokeService;

    @GetMapping("/random")
    public Joke getRandomJoke() {
        return jokeService.getRandomJoke();
    }

    @GetMapping("/lookup")
    public List<Joke> searchJokesByKeyword(@RequestParam String keyword) {
        return jokeService.searchJokesByKeyword(keyword);
    }
    @GetMapping("/getJokes")
    public List<Joke> getAllJokes() {
        return jokeService.getJokes();
    }

    @GetMapping("/category")
    public List<Joke> getJokesByCategory(@RequestParam(name = "category") String category) {
        List<Joke> jokesByCategory = jokeService.getJokesByCategory(category);
        return jokesByCategory;
    }

}