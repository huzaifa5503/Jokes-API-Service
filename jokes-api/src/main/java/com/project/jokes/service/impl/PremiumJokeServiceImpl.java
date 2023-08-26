package com.project.jokes.service.impl;

import com.project.jokes.config.JokeStore;
import com.project.jokes.dto.JokeRequestDto;
import com.project.jokes.entity.Joke;
import com.project.jokes.service.PremiumJokeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PremiumJokeServiceImpl implements PremiumJokeService {
    @Override
    public Joke getRandomJoke() {
        System.out.println("Random Joke api in premium service called");
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
        for (Joke joke : JokeStore.getAllJokes()) {
            if (joke.getCategory().equalsIgnoreCase(category)) {
                matchingJokes.add(joke);
            }
        }
        return matchingJokes;
    }

    @Override
    public List<Joke> getJokes() {
        return JokeStore.getAllJokes();
    }

    @Override
    public void submitJoke(JokeRequestDto jokeRequestDto) {
        if (!jokeRequestDto.getContent().isEmpty() && !jokeRequestDto.getCategory().isEmpty()){
            // joke to be approved by admin
            Joke joke = Joke.builder()
                    .id(Long.valueOf(JokeStore.getAllJokes().size()))
                    .content(jokeRequestDto.getContent()).category(jokeRequestDto.getCategory())
                    .approved(Boolean.TRUE).build();
            JokeStore.getAllJokes().add(joke);
        }else {
            System.out.println("Joke invalid");
        }
    }
}
