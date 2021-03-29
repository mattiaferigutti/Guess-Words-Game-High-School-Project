package com.studio.mattiaferigutti.randomwords;

import androidx.lifecycle.ViewModel;
import java.util.Arrays;
import java.util.List;

public class MainViewModel extends ViewModel {

    //list of words
    List<String> words;

    //index of the list
    int index = 0;

    void fillList() {
        //20 words
        words = Arrays.asList(
                "stand",
                "tank",
                "food",
                "mirror",
                "message",
                "investment",
                "dead",
                "scandal",
                "rock",
                "resort",
                "clown",
                "employ",
                "house",
                "bed"
        );
    }
}
