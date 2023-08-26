package com.project.jokes.config;

import com.project.jokes.entity.Joke;

import java.util.ArrayList;
import java.util.List;

public class JokeStore {
    private static List<Joke> jokes = new ArrayList<>();

    static {
        jokes.add(new Joke(1L, "Why don't scientists trust atoms?", "Science", true));
        jokes.add(new Joke(2L, "Why did the scarecrow win an award?", "Puns", true));
        jokes.add(new Joke(3L, "Parallel lines have so much in common. It's a shame they'll never meet.", "Math", true));
        jokes.add(new Joke(4L, "I told my wife she was drawing her eyebrows too high. She seemed surprised.", "Humor", true));
        jokes.add(new Joke(5L, "I'm reading a book about anti-gravity. It's impossible to put down!", "Science", true));
        jokes.add(new Joke(6L, "Did you hear about the claustrophobic astronaut? He just needed a little space.", "Space", true));
        jokes.add(new Joke(7L, "I used to play piano by ear, but now I use my hands.", "Music", true));
        jokes.add(new Joke(8L, "Why don't seagulls fly over the bay? Because then they'd be bagels.", "Puns", true));
        jokes.add(new Joke(9L, "What do you call someone who steals energy? A jolt-er.", "Electricity", true));
        jokes.add(new Joke(10L, "I only know 25 letters of the alphabet. I don't know y.", "Alphabet", true));
        jokes.add(new Joke(11L, "What's orange and sounds like a parrot? A carrot.", "Puns", true));
        jokes.add(new Joke(12L, "Why did the bicycle fall over? Because it was two-tired.", "Puns", true));
        jokes.add(new Joke(13L, "I only know how to tell 25% of a joke. But I'll give it a shot!", "Humor", true));
        jokes.add(new Joke(14L, "Why did the scarecrow become a successful politician? He was outstanding in his field!", "Puns", true));
        jokes.add(new Joke(15L, "I used to be a baker, but I couldn't make enough dough.", "Occupation", true));
        jokes.add(new Joke(16L, "What do you call a can opener that doesn't work? A can't opener!", "Puns", true));
        jokes.add(new Joke(17L, "What do you call a fish wearing a crown? An anemone!", "Animal", true));
        jokes.add(new Joke(18L, "Why did the tomato turn red? Because it saw the salad dressing!", "Food", true));
        jokes.add(new Joke(19L, "Why don't skeletons fight each other? They don't have the guts!", "Humor", true));
        jokes.add(new Joke(20L, "Why did the golfer bring two pairs of pants? In case he got a hole in one!", "Sports", true));

    }

    public static List<Joke> getAllJokes() {
        return jokes;
    }
}
