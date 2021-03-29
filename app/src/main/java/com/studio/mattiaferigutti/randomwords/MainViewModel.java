package com.studio.mattiaferigutti.randomwords;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.Arrays;
import java.util.List;

public class MainViewModel extends ViewModel {
    /**
     * The ViewModel must contain all the logic in order to respect the MVVM Pattern
     */

    //Defines list of words
    private final List<String> words;

    //MutableLiveData of the current word
    private final MutableLiveData<String> _currentWord = new MutableLiveData<>();

    //LiveData of the current word
    public LiveData<String> getCurrentWord() {
        return _currentWord;
    }

    //index of the list
    private int index = 0;

    //next word and notify the word has changed
    public void nextWord() {
        index++;
        _currentWord.setValue(words.get(index % words.size()));
    }

    //previous word and notify the word has changed
    public void previousWord() {
        if (index > 0) index--;
        _currentWord.setValue(words.get(index % words.size()));
    }

    public MainViewModel() {
        //set list of random words
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

        //set the initial value for the list
        _currentWord.setValue(words.get(0));
    }
}
