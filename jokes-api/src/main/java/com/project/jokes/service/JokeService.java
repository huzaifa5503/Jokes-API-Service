package com.project.jokes.service;

import com.project.jokes.entity.Joke;

import java.util.List;

public interface JokeService {
    Joke getRandomJoke();
    List<Joke> searchJokesByKeyword(String keyword);
    List<Joke> getJokesByCategory(String category);

}

