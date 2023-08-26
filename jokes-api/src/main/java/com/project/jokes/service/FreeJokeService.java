package com.project.jokes.service;

import com.project.jokes.entity.Joke;

import java.util.List;

public interface FreeJokeService extends JokeService {
    List<Joke> getJokes();
}
