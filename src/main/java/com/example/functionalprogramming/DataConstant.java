package com.example.functionalprogramming;

import java.util.ArrayList;

public class DataConstant {

    public static ArrayList<Artist> artists = new ArrayList<>();
    static {
        Artist artistOne = new Artist();
        artistOne.setName("John");
        artistOne.setOrigin("London");
        Artist artistTwo = new Artist();
        artistTwo.setOrigin("London");
        artistTwo.setName("Paul");
        Artist artistThree = new Artist();
        artistThree.setOrigin("paris");
        artistThree.setName("george");
        artists.add(artistOne);
        artists.add(artistTwo);
        artists.add(artistThree);
    }
}
