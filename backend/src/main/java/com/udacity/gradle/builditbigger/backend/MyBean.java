package com.udacity.gradle.builditbigger.backend;

import com.devandroid.javalib.RequestJokes;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private String myData;

    public String getData() {
        //new
        myData = new RequestJokes().getJoke();
        return myData;
    }

    public void setData(String data) {
        myData = data;
    }
}