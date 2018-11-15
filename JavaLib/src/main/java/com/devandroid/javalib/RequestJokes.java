package com.devandroid.javalib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RequestJokes {

    private static List<String> lstJokes = Arrays.asList(
            "This is the first funny joke from Java Library!",
            "This is the second funny joke from Java Library!",
            "This is the third funny joke from Java Library!",
            "This is the fourth funny joke from Java Library!",
            "This is the fifth funny joke from Java Library!",
            "This is the last funny joke from Java Library!");


    public String getJoke() {

        Random random = new Random();
        return lstJokes.get(random.nextInt(lstJokes.size()));
    }

}
