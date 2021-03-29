package com.studio.mattiaferigutti.randomwords;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //site from where to get random words https://randomwordgenerator.com/
    private Button nextButton, previousButton;
    private TextView wordText;
    private List<String> words;
    private int index = 0;
    private static final String SAVE_VALUE = "save_index";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nextButton = findViewById(R.id.nextButton);
        previousButton = findViewById(R.id.previousButton);
        wordText = findViewById(R.id.wordText);

        fillList();
        if (savedInstanceState != null) {
            index = savedInstanceState.getInt(SAVE_VALUE);
        }
        wordText.setText(words.get(index));

        nextButton.setOnClickListener( view -> {
            wordText.setText(getNextItem());
        });

        previousButton.setOnClickListener(view -> {
            wordText.setText(getPreviousItem());
        });
    }

    private String getNextItem() {
        index++;
        return words.get(index % words.size());
    }

    private String getPreviousItem() {
        if (index > 0) index--;
        return words.get(index % words.size());
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(SAVE_VALUE, index);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        index = savedInstanceState.getInt(SAVE_VALUE);
        wordText.setText(words.get(index));
    }

    private void fillList() {
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