package com.project.jokes.service.impl;

import com.project.jokes.config.JokeStore;
import com.project.jokes.entity.Joke;
import com.project.jokes.service.FreeJokeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class FreeJokeServiceImpl implements FreeJokeService {
    private List<Joke> jokes = new ArrayList<>();

    @Override
    public Joke getRandomJoke() {
        System.out.println("Random Joke api called");
        List<Joke> allJokes = JokeStore.getAllJokes();
        if (allJokes.isEmpty()) {
            return null;
        }
        Random random = new Random();
        int randomIndex = random.nextInt(allJokes.size());
        return allJokes.get(randomIndex);
    }

    @Override
    public List<Joke> searchJokesByKeyword(String keyword) {
        List<Joke> allJokes = JokeStore.getAllJokes();
        List<Joke> matchingJokes = new ArrayList<>();
        allJokes.stream().forEach(joke -> {
            if (joke.getContent().contains(keyword)){
                matchingJokes.add(joke);
            }
        });
        return matchingJokes;
    }

    @Override
    public List<Joke> getJokesByCategory(String category) {
        List<Joke> matchingJokes = new ArrayList<>();
        for (Joke joke : this.getJokes()) {
            if (joke.getCategory().equalsIgnoreCase(category)) {
                matchingJokes.add(joke);
            }
        }
        return matchingJokes;
    }

    @Override
    public List<Joke> getJokes() {
        List<Joke> allJokes = JokeStore.getAllJokes();
        List<Joke> basicJokes = new ArrayList<>();
        for (int i = 0; i < allJokes.size() - 5; i++) {
            basicJokes.add(allJokes.get(i));
        }
        return basicJokes;
    }
}
