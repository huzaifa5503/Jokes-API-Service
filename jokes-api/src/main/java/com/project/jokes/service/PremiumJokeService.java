package com.project.jokes.service;

import com.project.jokes.dto.JokeRequestDto;
import com.project.jokes.entity.Joke;

import java.util.List;

public interface PremiumJokeService extends JokeService {
    List<Joke> getJokes();

    void submitJoke(JokeRequestDto jokeRequestDto);
}
