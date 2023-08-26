package com.project.jokes.controller;

import com.project.jokes.config.JokeStore;
import com.project.jokes.entity.Joke;
import com.project.jokes.service.PremiumJokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("/api/v1/jokes")
public class WelcomeController {

    @Autowired
    private PremiumJokeService jokeService;

    @GetMapping("/welcome")
    public String showWelcomePage(Model model) {
        String welcomeMessage = "Hello, user! Welcome to our application.";
        model.addAttribute("message", welcomeMessage);
        return "welcome.html";
    }

    @GetMapping("/submit-joke")
    public String showSubmitJokePage() {
        return "submit_joke";
    }

    @GetMapping("/get")
    public String getJokes(Model model) {
        List<Joke> allJokes = JokeStore.getAllJokes();
        model.addAttribute("jokes", allJokes);
        return "joke_list.html";
    }

    @GetMapping("/category")
    public String getJokesByCategory(@RequestParam(name = "category") String category, Model model) {
        List<Joke> jokesByCategory = jokeService.getJokesByCategory(category);
        model.addAttribute("jokes", jokesByCategory);
        return "joke_list";
    }

    @GetMapping("/random")
    public String getRandom(Model model) {
        Joke randomJoke = jokeService.getRandomJoke();
        model.addAttribute("jokes", randomJoke);
        return "joke_list";
    }
}